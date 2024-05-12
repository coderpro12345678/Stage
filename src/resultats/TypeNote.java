package resultats;
public enum TypeNote {

	CT ("Contrôle terminal", "CT"),
	CC ("Contrôle continu", "CC");
	
	private String libelle;
	private String acronyme;
	private TypeNote(String l, String a) { libelle = l; acronyme = a; }
	public String toString() { return libelle; }
	public String acronyme() { return acronyme; }
}
