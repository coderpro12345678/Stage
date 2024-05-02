package objet;

public class Matiere {
	private String libelle;
	private String CodeMatiere;
	private int VoumeHorCM;
	private int VolumeHorTD;
	private String syllabus;
	public Matiere(String libelle, String codeMatiere, int voumeHorCM, int volumeHorTD, String syllabus) {
		
		this.libelle = libelle;
		CodeMatiere = codeMatiere;
		VoumeHorCM = voumeHorCM;
		VolumeHorTD = volumeHorTD;
		this.syllabus = syllabus;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the voumeHorCM
	 */
	public int getVoumeHorCM() {
		return VoumeHorCM;
	}
	/**
	 * @param voumeHorCM the voumeHorCM to set
	 */
	public void setVoumeHorCM(int voumeHorCM) {
		VoumeHorCM = voumeHorCM;
	}
	/**
	 * @return the volumeHorTD
	 */
	public int getVolumeHorTD() {
		return VolumeHorTD;
	}
	/**
	 * @param volumeHorTD the volumeHorTD to set
	 */
	public void setVolumeHorTD(int volumeHorTD) {
		VolumeHorTD = volumeHorTD;
	}
	/**
	 * @return the syllabus
	 */
	public String getSyllabus() {
		return syllabus;
	}
	/**
	 * @param syllabus the syllabus to set
	 */
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	/**
	 * @return the codeMatiere
	 */
	public String getCodeMatiere() {
		return CodeMatiere;
	}
	
}
