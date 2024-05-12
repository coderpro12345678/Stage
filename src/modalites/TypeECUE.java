package modalites;

import exception.M3CException;
import resultats.Evaluation;

public abstract class TypeECUE {
	
	public final String acronyme;
	public final String libelle;
	protected RegleCalculCCP regleCalculCCP;
	
	public TypeECUE(String a, String l, RegleCalculCCP regle) {
		acronyme = a;
		libelle = l;
		regleCalculCCP = regle;
	}
	
	public String toString() { return acronyme; } 
	
	public float calculerNote(Evaluation evaluation) throws M3CException {
		//TODO penser à mettre des exceptions dans le cas ou il manque un cc ou un ct pour une ecue CCP
		return regleCalculCCP.calculer(evaluation);
	}
	
	public abstract void modifierRegleCalculCCP(RegleCalculCCP regle) throws M3CException;
}