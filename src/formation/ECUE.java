package formation;

import java.util.Objects;

import exception.M3CException;
import modalites.RegleCalculCCP;
import modalites.TypeECUE;
//import objet.Enseignant;
import releves.ResultatELP;
import releves.Statut;

/**
 * ECUE = Element Constitutif d'une Unité d'Enseignement
 */
public class ECUE extends ELP {

	public final TypeECUE typeECUE;
	public final boolean coloration;
	public final int HCM;
	public final int HTD;
	private final int hashCode;
	
	public ECUE(String codeAPOGEE, String nom, int creditsECTS, TypeECUE type, boolean coloration, int hCM, int hTD) {
		super(codeAPOGEE, nom, creditsECTS);
		Objects.requireNonNull(type);
		Objects.requireNonNull(coloration);
		Objects.requireNonNull(hTD);
		Objects.requireNonNull(hCM);
		this.typeECUE = type;
		this.coloration = coloration;
		HCM = hCM;
		HTD = hTD;
		this.hashCode = Objects.hash(codeAPOGEE, nom, creditsECTS, type, coloration, hCM, hTD);
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	public void modifierRegleCalculCCP(RegleCalculCCP regle) throws M3CException {
		this.typeECUE.modifierRegleCalculCCP(regle);
	}

	@Override
	public ResultatELP calculerResultat(float resultatNumerique) {
		// TODO vérifier les cas avec notes seuil, et les cas où aucune note n'est retournée (DEF)
		// TODO vérifier les cas où la matière n'est pas capitalisée mais compensée (COMP)
		Statut st = Statut.NACQ;
		if (resultatNumerique >= 10f) st = Statut.ACQ;
		return new ResultatELP(codeAPOGEE, this, resultatNumerique, st);
	}
	
	@Override
	public String toString() {
		String affiche = codeAPOGEE + " - " + nom + " (" + creditsECTS + " credits";
		affiche += ", evaluation "+typeECUE;
		if (coloration) affiche += ", coloration DD";
		affiche += ", "+HCM+"h CM - "+HTD+"h TD)";
		return affiche;
	}
	
	public String toString(int decalage) {
		String affiche = "";
		for (int i=0; i<decalage; i++) affiche += "  ";
		affiche += codeAPOGEE + " - " + nom + " (" + creditsECTS + " credits";
		affiche += ", evaluation "+typeECUE;
		if (coloration) affiche += ", coloration DD";
		affiche += ", "+HCM+"h CM - "+HTD+"h TD)";
		return affiche;
	}
}