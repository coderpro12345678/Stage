package releves;

public enum Statut {

	ACQ ("Acquis"),
	NACQ ("Non acquis"),
	COMP ("Compensé"),
	DEF ("Défaillant");
	
	private String libelle;
	private Statut(String l) { libelle = l; }
	public String toString() { return libelle; } 
}
