package formation;

import java.util.ArrayList;
import java.util.Objects;

import releves.ResultatELP;
import releves.Statut;

/**
 * BCC = Bloc de connaissances et de compétences
 */
public class BCC extends ELP {

	public final ArrayList<UE> listeUE;
	private final int hashCode;
	
	public BCC(String codeAPOGEE, String nom, int creditsECTS, ArrayList<UE> listeUE) {
		this(codeAPOGEE, nom, creditsECTS);
		Objects.requireNonNull(listeUE);
		this.listeUE.addAll(listeUE);
	}
	
	public BCC(String codeAPOGEE, String nom, int creditsECTS) {
		super(codeAPOGEE, nom, creditsECTS);
		this.listeUE = new ArrayList<UE>();
		this.hashCode = Objects.hash(codeAPOGEE, nom, creditsECTS);
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}
	
	@Override
	public ResultatELP calculerResultat(float resultatNumerique) {
		// TODO vérifier les cas avec notes seuil, et les cas où aucune note n'est retournée (DEF)
		// TODO vérifier les cas où la matière n'est pas capitalisée mais compensée (COMP)
		// TODO vérifier les cas où le BCC est entre 9 et 10
		Statut st = Statut.NACQ;
		if (resultatNumerique >= 10f) st = Statut.ACQ;
		return new ResultatELP(codeAPOGEE, this, resultatNumerique, st);
	}
	
	public void ajouterUE(UE ue) {
		if (listeUE.contains(ue)) return; //On peut laisser ArrayList, le besoin d'un Set n'est pas justifié avec en moyenne 3 UE par BCC...
		listeUE.add(ue);
	}
	
	public ECUE getECUEByCodeAPOGEE(String codeAPOGEE) {
		ECUE ecue = null;
		for (UE ue : listeUE) if ((ecue = ue.getECUEByCodeAPOGEE(codeAPOGEE)) != null) return ecue;
		return null;
	}
	
	public UE getUEByCodeAPOGEE(String codeAPOGEE) {
		for (UE ue : listeUE) if (ue.codeAPOGEE.equals(codeAPOGEE)) return ue;
		return null;
	}
	
	@Override
	public String toString() {
		String affiche = codeAPOGEE + " - " + nom + " (" + creditsECTS + " credits)";
		for (UE ue : listeUE) affiche += "\n"+ue.toString();
		return affiche;
	}
	
	public String toString(int decalage) {
		String affiche = "";
		for (int i=0; i<decalage; i++) affiche += "  ";
		affiche += codeAPOGEE + " - " + nom + " (" + creditsECTS + " credits)";
		for (UE ue : listeUE) affiche += "\n"+ue.toString(decalage+1);
		return affiche;
	}
	
}