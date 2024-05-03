package ecue;

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
	
	public float calculerNote(DuoNote dn) {
		return regleCalculCCP.calculer(dn);
	}
	
	public abstract void modifierRegleCalculCCP(RegleCalculCCP regle);
}
