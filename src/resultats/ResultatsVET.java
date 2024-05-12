package resultats;

import java.util.ArrayList;
import java.util.HashMap;

import exception.EtudiantInconnuException;
import formation.SEM;
import formation.VET;
import objet.Etudiant;
import objet.Promotion;

public class ResultatsVET extends ResultatsELP {

	private final VET vet;
	private final HashMap<Etudiant, HashMap<SEM, Float>> resultats_detailles; //résultats des semestres
	public final ArrayList<ResultatsSEM> liste_ResultatsSEM;
	private ResultatsSEM resultatsSEMAutomne = null;
	private ResultatsSEM resultatsSEMPrintemps = null;
	
	public ResultatsVET(VET vet, Promotion promo) {
		super(vet, promo);
		this.vet = vet;
		this.resultats_detailles = new HashMap<Etudiant, HashMap<SEM, Float>>();
		this.liste_ResultatsSEM = new ArrayList<ResultatsSEM>();
		reinitialisationReleves(promo);
	}
	
	public void reinitialisationReleves(Promotion promo) {
		this.resultats_detailles.clear();
		for (Etudiant etu : promo) {
			HashMap<SEM, Float> modules = new HashMap<SEM, Float>();
			modules.put(vet.getSemestreAutomne(), 0f);
			modules.put(vet.getSemestrePrintemps(), 0f);
			resultats_detailles.put(etu, modules);
		}
		resultatsSEMAutomne = new ResultatsSEM(this, vet.getSemestreAutomne(), promo);
		resultatsSEMPrintemps = new ResultatsSEM(this, vet.getSemestrePrintemps(), promo);
		liste_ResultatsSEM.add(resultatsSEMAutomne);
		liste_ResultatsSEM.add(resultatsSEMPrintemps);
	}
	
	public float calculerMoyenneEtudiant(Etudiant etu) throws EtudiantInconnuException {
		if (!resultats_detailles.containsKey(etu)) throw new EtudiantInconnuException();
		float moyenne = resultatsSEMAutomne.credits()*resultatsSEMAutomne.resultats(etu);
		moyenne += resultatsSEMPrintemps.credits()*resultatsSEMPrintemps.resultats(etu);
		return moyenne/credits();
	}

	public void notifierParentChangementNotes(ResultatsSEM bloc, Etudiant etu) throws EtudiantInconnuException {
		// une note vient d'être modifiée
		// on peut recalculer la moyenne d'un étudiant dans cette annee
		resultats_detailles.get(etu).replace((SEM) bloc.getELP(), bloc.resultats(etu));
		resultats.replace(etu, calculerMoyenneEtudiant(etu));
	}

	public ResultatsECUE getResultatsECUEByCodeAPOGEE(String codeAPOGEE) {
		ResultatsECUE bloc = resultatsSEMAutomne.getResultatsECUEByCodeAPOGEEId(codeAPOGEE);
		if (bloc == null) bloc = resultatsSEMPrintemps.getResultatsECUEByCodeAPOGEEId(codeAPOGEE);
		return bloc;
	}

	public ResultatsUE getResultatsUEByCodeAPOGEE(String codeAPOGEE) {
		ResultatsUE bloc = resultatsSEMAutomne.getResultatsUEByCodeAPOGEE(codeAPOGEE);
		if (bloc == null) bloc = resultatsSEMPrintemps.getResultatsUEByCodeAPOGEE(codeAPOGEE);
		return bloc;
	}
	
	public ResultatsBCC getResultatsBCCByCodeAPOGEE(String codeAPOGEE) {
		ResultatsBCC bloc = resultatsSEMAutomne.getResultatsBCCByCodeAPOGEE(codeAPOGEE);
		if (bloc == null) bloc = resultatsSEMPrintemps.getResultatsBCCByCodeAPOGEE(codeAPOGEE);
		return bloc;
	}
	
	public ResultatsSEM getResultatsSEMByCodeAPOGEE(String codeAPOGEE) {
		if (resultatsSEMAutomne.getELP().codeAPOGEE.equals(codeAPOGEE)) return resultatsSEMAutomne;
		if (resultatsSEMPrintemps.getELP().codeAPOGEE.equals(codeAPOGEE)) return resultatsSEMPrintemps;
		return null;
	}
}
