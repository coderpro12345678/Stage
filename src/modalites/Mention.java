package modalites;

public enum Mention {
	I ("informatique"),
	G ("gestion");
	
	private String libelle;
	private Mention(String l) { libelle = l; }
	public String toString() { return libelle; } 
	
	public static Mention parseFromString(String mentionStr) {
		if (mentionStr.equals("informatique")) return Mention.I;
		if (mentionStr.equals("gestion")) return Mention.G;
		return Mention.I;
	}
}
