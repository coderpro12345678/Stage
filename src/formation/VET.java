package formation;

import java.util.Objects;

import exception.StructureCoursException;
import modalites.Grade;
import modalites.Mention;

import releves.ResultatELP;
import releves.Statut;

public class VET extends ELP {
	
	private final static String PRINTEMPS = "printemps";
	private final static String AUTOMNE = "automne";

	public final Grade niveau;
	public final Mention mention;
	public final String parcours;

	private SEM semestreAutomne = null;
	private SEM semestrePrintemps = null;
	private final int hashCode;
	
	
	public VET(String codeAPOGEE, Grade niveau, Mention mention, String parcours, String nom, int creditsECTS) {
		super(codeAPOGEE, nom, creditsECTS);
		Objects.requireNonNull(niveau);
		Objects.requireNonNull(mention);
		Objects.requireNonNull(nom);
		this.niveau = niveau;
		this.mention = mention;
		this.parcours = parcours;
		this.hashCode = Objects.hash(codeAPOGEE, niveau, mention, parcours, nom, creditsECTS);
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}
	
	@Override
	public ResultatELP calculerResultat(float resultatNumerique) {
		// TODO vérifier les cas avec notes seuil, et les cas où aucune note n'est retournée (DEF)
		// TODO vérifier les cas où la matière n'est pas capitalisée mais compensée (COMP)
		// TODO vérifier les cas avec 3 BCC /4
		Statut st = Statut.NACQ;
		if (resultatNumerique >= 10f) st = Statut.ACQ;
		return new ResultatELP(codeAPOGEE, this, resultatNumerique, st);
	}

	public SEM ajouterSemestre(String codeAPOGEE, String saison, int creditsSemestre) throws StructureCoursException {
		Objects.requireNonNull(codeAPOGEE);
		Objects.requireNonNull(saison);
		Objects.requireNonNull(creditsSemestre);
		if (saison.equals(AUTOMNE)) {
			if (semestreAutomne == null) semestreAutomne = new SEM(codeAPOGEE, "S"+niveau.getNiveau(), creditsSemestre);
			return semestreAutomne;
		} else if (saison.equals(PRINTEMPS)) {
			if (semestrePrintemps == null) semestrePrintemps = new SEM(codeAPOGEE, "S"+(niveau.getNiveau()+1), creditsSemestre);
			return semestrePrintemps;
		} else {
			throw new StructureCoursException("La saisonalité du semestre doit être correcte (\"printemps\" ou \"automne\")");
		}
	}
	
	public ECUE getECUEByCodeAPOGEE(String codeAPOGEE) {
		ECUE ecue = semestreAutomne.getECUEByCodeAPOGEE(codeAPOGEE);
		if (ecue == null)
			ecue = semestrePrintemps.getECUEByCodeAPOGEE(codeAPOGEE);
		// TODO throw new exception si ecue still == null ?
		return ecue;
	}
	
	public UE getUEByCodeAPOGEE(String codeAPOGEE) {
		UE ue = semestreAutomne.getUEByCodeAPOGEE(codeAPOGEE);
		if (ue == null)
			ue = semestrePrintemps.getUEByCodeAPOGEE(codeAPOGEE);
		// TODO throw new exception si ue still == null ?
		return ue;
	}
	
	public BCC getBCCByCodeAPOGEE(String codeAPOGEE) {
		BCC bcc = semestreAutomne.getBCCByCodeAPOGEE(codeAPOGEE);
		if (bcc == null)
			bcc = semestrePrintemps.getBCCByCodeAPOGEE(codeAPOGEE);
		// TODO throw new exception si ecue still == null ?
		return bcc;
	}
	
	public SEM getSEMByCodeAPOGEE(String codeAPOGEE) {
		if (semestreAutomne.codeAPOGEE.equals(codeAPOGEE)) return semestreAutomne;
		if (semestrePrintemps.codeAPOGEE.equals(codeAPOGEE)) return semestrePrintemps;
		return null;
	}
	
	@Override
	public String toString() {
		String affiche = "";
		affiche += niveau+" "+mention;
		if (parcours != "") affiche += " "+parcours;
		affiche += " ("+nom+")";
		if (semestreAutomne != null) affiche += "\n"+semestreAutomne.toString(1);
		if (semestrePrintemps != null) affiche += "\n"+semestrePrintemps.toString(1);
		return affiche;
	}
	
	public String getName() {
		String affiche = "";
		affiche += niveau+" "+mention;
		if (parcours != "") affiche += " "+parcours;
		affiche += " ("+nom+")";
		return affiche;
	}

	public SEM getSemestreAutomne() {
		return semestreAutomne;
	}
	
	public SEM getSemestrePrintemps() {
		return semestrePrintemps;
	}
}
