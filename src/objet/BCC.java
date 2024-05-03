package objet;

import java.util.ArrayList;
import java.util.Objects;

import ecue.ECUE;

public class BCC {

	public final String nomBCC;
	public final int credits;
	public final ArrayList<UE> listeUE;
	
	public BCC(String nomBCC, int credits, ArrayList<UE> listeUE) {
		this(nomBCC, credits);
		Objects.requireNonNull(listeUE);
		this.listeUE.addAll(listeUE);
	}
	
	public BCC(String nomBCC, int credits) {
		Objects.requireNonNull(nomBCC);
		Objects.requireNonNull(credits);
		this.nomBCC = nomBCC;
		this.credits = credits;
		this.listeUE = new ArrayList<UE>();
	}
	
	public void ajouterUE(UE ue) {
		if (listeUE.contains(ue)) return; //On peut laisser ArrayList, le besoin d'un Set n'est pas justifié avec en moyenne 3 UE par BCC...
		listeUE.add(ue);
	}
	
	public ECUE getECUEFromId(String idECUE) {
		ECUE ecue = null;
		for (UE ue : listeUE) if ((ecue = ue.getECUEFromId(idECUE)) != null) return ecue;
		return null;
	}
	
	@Override
	public String toString() {
		String affiche = nomBCC + " (" + credits + " credits)";
		for (UE ue : listeUE) affiche += "\n"+ue.toString();
		return affiche;
	}
	
	public String toString(int decalage) {
		String affiche = "";
		for (int i=0; i<decalage; i++) affiche += "  ";
		affiche += nomBCC + " (" + credits + " credits)";
		for (UE ue : listeUE) affiche += "\n"+ue.toString(decalage+1);
		return affiche;
	}
}
