package formation;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Objects;

import objet.Enseignant;
import releves.ResultatELP;
import releves.Statut;

/**
 * UE = Unité d'Enseignement
 */
public class UE extends ELP {

	public final boolean option;
	public final ArrayList<ECUE> listeECUE;
	private final int hashCode;
	
	public UE(String codeAPOGEE, String nomUE, int credits, boolean option, ArrayList<ECUE> listeECUE) {
		this(codeAPOGEE, nomUE, credits, option);
		Objects.requireNonNull(listeECUE);
		this.listeECUE.addAll(listeECUE);
	}
	
	public UE(String codeAPOGEE, String nom, int creditsECTS, boolean option) {
		super(codeAPOGEE, nom, creditsECTS);
		Objects.requireNonNull(option);
		this.option = option;
		this.listeECUE = new ArrayList<ECUE>();
		this.hashCode = Objects.hash(codeAPOGEE, nom, creditsECTS, option);
	}

	@Override
	public int hashCode() {
		return hashCode;
	}
	
	@Override
	public ResultatELP calculerResultat(float resultatNumerique) {
		// TODO vérifier les cas avec notes seuil, et les cas où aucune note n'est retournée (DEF)
		// TODO vérifier les cas où la matière n'est pas capitalisée mais compensée (COMP)
		Statut st = Statut.NACQ;
		if (resultatNumerique >= 10f) st = Statut.ACQ;
		return new ResultatELP(codeAPOGEE, this, resultatNumerique, st);
	}

	public void ajouterECUE(ECUE ecue) {
		if (listeECUE.contains(ecue)) return; //On peut laisser ArrayList, le besoin d'un Set n'est pas justifié avec en moyenne 2 ECUE par UE...
		listeECUE.add(ecue);
	}
	
	public ECUE getECUEByCodeAPOGEE(String codeAPOGEE) {
		for (ECUE ecue : listeECUE) if (ecue.codeAPOGEE.equals(codeAPOGEE)) return ecue;
		return null;
	}
	
	@Override
	public String toString() {
		String affiche = codeAPOGEE + " - " + nom + " (" + creditsECTS + " credits";
		if (option) affiche += ", option";
		affiche += ")";
		for (ECUE ecue : listeECUE) affiche += "\n"+ecue.toString();
		return affiche;
	}
	
	public String toString(int decalage) {
		String affiche = "";
		for (int i=0; i<decalage; i++) affiche += "  ";
		affiche += codeAPOGEE + " - " + nom + " (" + creditsECTS + " credits";
		if (option) affiche += ", option";
		affiche += ")";
		for (ECUE ecue : listeECUE) affiche += "\n"+ecue.toString(decalage+1);
		return affiche;
	}
}


