package objet;

import java.util.ArrayList;
import java.util.List;

public class UE extends Matiere{
	private List<ECUE> listeECUE;
	private List<Enseignant> enseignants;
	private int créditsECTS;//valeur calculé = coefficent pour calculer la moyenne génerale
	private boolean UEoptionelle;

	public UE(String libelle, String codeMatiere, int voumeHorCM, int volumeHorTD, String syllabus,
            List<ECUE> listeECUE, boolean uEoptionelle) {
      super(libelle, codeMatiere, voumeHorCM, volumeHorTD, syllabus);
      this.listeECUE = listeECUE;
      this.enseignants = new ArrayList<>(); 
      this.créditsECTS = 0; 
      for (ECUE ecue : listeECUE) {
          this.enseignants.add(ecue.getEnseignant()); 
          this.créditsECTS += ecue.getCréditsECTS(); 
      }
      this.UEoptionelle = uEoptionelle;
  }

}
