package objet;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Objects;

import ecue.ECUE;

public class UE {

	public final String nomUE;
	public final int credits;
	public final boolean option;
	public final ArrayList<ECUE> listeECUE;
	public ArrayList<Enseignant> listeEnseignant; //est-ce nécessaire?
	
	public UE(String nomUE, int credits, boolean option, ArrayList<ECUE> listeECUE) {
		this(nomUE, credits, option);
		Objects.requireNonNull(listeECUE);
		this.listeECUE.addAll(listeECUE);
		this.listeEnseignant = new ArrayList<>(); //ajout
		for (ECUE ecue : listeECUE) {
         
            this.listeEnseignant.add(ecue.getEnseignant());
        }
	}
	
	public UE(String nomUE, int credits, boolean option) {
		Objects.requireNonNull(nomUE);
		Objects.requireNonNull(credits);
		Objects.requireNonNull(option);
		this.nomUE = nomUE;
		this.credits = credits;
		this.option = option;
		this.listeECUE = new ArrayList<ECUE>();
		this.listeEnseignant = new ArrayList<Enseignant>();
	}
	
	public void ajouterECUE(ECUE ecue) {
		if (listeECUE.contains(ecue)) return; //On peut laisser ArrayList, le besoin d'un Set n'est pas justifié avec en moyenne 2 ECUE par UE...
		listeECUE.add(ecue);
	}
	
	public ECUE getECUEFromId(String idECUE) {
		for (ECUE ecue : listeECUE) if (ecue.idECUE.equals(idECUE)) return ecue;
		return null;
	}
	
	@Override
	public String toString() {
		String affiche = nomUE + " (" + credits + " credits";
		if (option) affiche += ", option";
		affiche += ")";
		for (ECUE ecue : listeECUE) affiche += "\n"+ecue.toString();
		return affiche;
	}
	
	public String toString(int decalage) {
		String affiche = "";
		for (int i=0; i<decalage; i++) affiche += "  ";
		affiche += nomUE + " (" + credits + " credits";
		if (option) affiche += ", option";
		affiche += ")";
		for (ECUE ecue : listeECUE) affiche += "\n"+ecue.toString(decalage+1);
		return affiche;
	}
}

