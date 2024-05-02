package objet;

public class Etudiant {
	private String nom;
	private String prenom;
	private String DateN;
	private String adressemail;
	private int NumE;
	
	public Etudiant(String nom, String prenom, String dateN, String adressemail, int numE) {
		this.nom = nom;
		this.prenom = prenom;
		DateN = dateN;
		this.adressemail = adressemail;
		NumE = numE;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the dateN
	 */
	public String getDateN() {
		return DateN;
	}

	/**
	 * @return the adressemail
	 */
	public String getAdressemail() {
		return adressemail;
	}

	/**
	 * @return the numE
	 */
	public int getNumE() {
		return NumE;
	}
}
