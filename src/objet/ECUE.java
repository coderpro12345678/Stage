package objet;

public class ECUE extends Matiere {
	private Enseignant enseignant;
	private int créditsECTS;//valeur donnée = coefficient dans la moyenne de l'ue
	private TypeEvaluation eval;
	
	public ECUE(String libelle, String codeMatiere, int voumeHorCM, int volumeHorTD, String syllabus,
			Enseignant enseignant, int créditsECTS, TypeEvaluation eval) {
		super(libelle, codeMatiere, voumeHorCM, volumeHorTD, syllabus);
		this.enseignant = enseignant;
		this.créditsECTS = créditsECTS;
		this.eval = eval;
	}

	/**
	 * @return the enseignant
	 */
	public Enseignant getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant the enseignant to set
	 */
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	/**
	 * @return the créditsECTS
	 */
	public int getCréditsECTS() {
		return créditsECTS;
	}

	/**
	 * @param créditsECTS the créditsECTS to set
	 */
	public void setCréditsECTS(int créditsECTS) {
		this.créditsECTS = créditsECTS;
	}

	/**
	 * @return the eval
	 */
	public TypeEvaluation getEval() {
		return eval;
	}

	/**
	 * @param eval the eval to set
	 */
	public void setEval(TypeEvaluation eval) {
		this.eval = eval;
	}
	
}
