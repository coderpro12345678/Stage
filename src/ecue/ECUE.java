package ecue;

import java.util.Objects;

import objet.Enseignant;

public class ECUE {

	public final String idECUE;
	public final int credits;
	public final Enseignant enseignant; //ajout
	public final TypeECUE type;
	public final boolean coloration;
	public final int HCM;
	public final int HTD;
	
	public ECUE(String idECUE, int credits, TypeECUE type, boolean coloration, int hCM, int hTD, Enseignant ens) {
		Objects.requireNonNull(idECUE);
		Objects.requireNonNull(credits);
		Objects.requireNonNull(ens);
		Objects.requireNonNull(type);
		Objects.requireNonNull(coloration);
		Objects.requireNonNull(hTD);
		Objects.requireNonNull(hCM);
		this.idECUE = idECUE;
		this.enseignant = ens;
		this.credits = credits;
		this.type = type;
		this.coloration = coloration;
		HCM = hCM;
		HTD = hTD;
	}
	public ECUE(ECUE ecue) {
		Objects.requireNonNull(ecue);
		this.idECUE = ecue.idECUE;
		this.credits = ecue.credits;
		this.enseignant = ecue.enseignant;
		this.type = ecue.type;
		this.coloration = ecue.coloration;
		HCM = ecue.HCM;
		HTD = ecue.HTD;
	}

	/**
	 * @return the enseignant
	 */
	public Enseignant getEnseignant() {
		return enseignant;
	}
	
	public void modifierRegleCalculCCP(RegleCalculCCP regle) {
		this.type.modifierRegleCalculCCP(regle);
	}

	
	@Override
	public String toString() {
		String affiche = idECUE + " (" + credits + " credits";
		affiche += ", evaluation "+type;
		if (coloration) affiche += ", coloration DD";
		affiche += ", "+HCM+"h CM - "+HTD+"h TD)";
		return affiche;
	}
	
	public String toString(int decalage) {
		String affiche = "";
		for (int i=0; i<decalage; i++) affiche += "  ";
		affiche += idECUE + " (" + credits + " credits";
		affiche += ", evaluation "+type;
		if (coloration) affiche += ", coloration DD";
		affiche += ", "+HCM+"h CM - "+HTD+"h TD)";
		return affiche;
	}
}
