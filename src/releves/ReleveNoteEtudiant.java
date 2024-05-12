package releves;

import java.util.ArrayList;

import contexte.Contexte;
import exception.EtudiantInconnuException;
import formation.ELP;
import objet.Etudiant;
import resultats.ResultatsBCC;
import resultats.ResultatsECUE;
import resultats.ResultatsSEM;
import resultats.ResultatsUE;
import resultats.ResultatsVET;

public class ReleveNoteEtudiant {

	private final Etudiant etudiant;
	private final ArrayList<ResultatELP> resultats;
	
	public ReleveNoteEtudiant(Etudiant etudiant) throws EtudiantInconnuException {
		this.etudiant = etudiant;
		this.resultats = new ArrayList<ResultatELP>();
	
		ResultatsVET resultatsVET = Contexte.releveNotesGeneralAnneeEnCours;
		
		ELP elpActuel = resultatsVET.getELP(); // C'est l'element pédagogique qui va déterminer lui même si l'étudiant valide ou non
		float resultatNumerique = resultatsVET.calculerMoyenneEtudiant(etudiant); //TODO cas sans notes (DEF)
		resultats.add(elpActuel.calculerResultat(resultatNumerique));
		
		//SEM automne = ((VET) elpActuel).getSemestreAutomne();
		for (ResultatsSEM resultatsSEMA : resultatsVET.liste_ResultatsSEM) {
			elpActuel = resultatsSEMA.getELP();
			resultatNumerique = resultatsSEMA.calculerMoyenneEtudiant(etudiant); //TODO cas sans notes (DEF)
			resultats.add(elpActuel.calculerResultat(resultatNumerique));
			
			for (ResultatsBCC resultatsBCC : resultatsSEMA.liste_ResultatsBCC) {
				elpActuel = resultatsBCC.getELP();
				resultatNumerique = resultatsBCC.calculerMoyenneEtudiant(etudiant); //TODO cas sans notes (DEF)
				resultats.add(elpActuel.calculerResultat(resultatNumerique));
				
				for (ResultatsUE resultatsUE : resultatsBCC.liste_ResultatsUE) {
					elpActuel = resultatsUE.getELP();
					resultatNumerique = resultatsUE.calculerMoyenneEtudiant(etudiant); //TODO cas sans notes (DEF)
					resultats.add(elpActuel.calculerResultat(resultatNumerique));
				
					for (ResultatsECUE resultatsECUE : resultatsUE.liste_ResultatsECUE) {
						elpActuel = resultatsECUE.getELP();
						resultatNumerique = resultatsECUE.calculerMoyenneEtudiant(etudiant); //TODO cas sans notes (DEF)
						resultats.add(elpActuel.calculerResultat(resultatNumerique));
					}
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String affiche = etudiant.toString();
		for (ResultatELP res : resultats) affiche += "\n"+res.afficherResultat();
		return affiche;
	}
}

