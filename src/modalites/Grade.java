package modalites;

public enum Grade {
	L3 ("Licence 3", 5),
	M1 ("Master 1", 1),
	M2 ("Master 2", 3);
	
	private String libelle;
	private int niveau;
	private Grade(String l, int n) { libelle = l; niveau = n; }
	public String toString() { return libelle; } 
	public int getNiveau() { return niveau; }
	
	public static Grade parseFromString(String gradeStr) {
		if (gradeStr.equals("L3")) return Grade.L3;
		if (gradeStr.equals("M1")) return Grade.M1;
		if (gradeStr.equals("M2")) return Grade.M2;
		return Grade.L3;
	}
}
