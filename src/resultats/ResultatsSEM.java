package resultats;

import java.util.ArrayList;
import java.util.HashMap;

import exception.EtudiantInconnuException;
import formation.BCC;
import formation.SEM;
import objet.Etudiant;
import objet.Promotion;

public class ResultatsSEM extends ResultatsELP {

	private final ResultatsVET parent;
	private final HashMap<Etudiant, HashMap<BCC, Float>> resultats_detailles; //résultats des bcc du semestre
	public final ArrayList<ResultatsBCC> liste_ResultatsBCC;
	
	public ResultatsSEM(ResultatsVET parent, SEM sem, Promotion promo) {
		super(sem, promo);
		this.parent = parent;
		this.resultats_detailles = new HashMap<Etudiant, HashMap<BCC, Float>>();
		this.liste_ResultatsBCC = new ArrayList<ResultatsBCC>();
		
		for (Etudiant etu : promo) {
			HashMap<BCC, Float> modules = new HashMap<BCC, Float>();
			for (BCC bcc : sem.listeBCC) modules.put(bcc, 0f);
			resultats_detailles.put(etu, modules);
		}
		for (BCC bcc : sem.listeBCC) liste_ResultatsBCC.add(new ResultatsBCC(this, bcc, promo));
	}

	public float calculerMoyenneEtudiant(Etudiant etu) throws EtudiantInconnuException {
		if (!resultats_detailles.containsKey(etu)) throw new EtudiantInconnuException();
		float moyenne = 0f;
		for (ResultatsBCC bloc : liste_ResultatsBCC) moyenne += bloc.credits()*bloc.resultats(etu);
		return moyenne/credits();
	}
	
	public void notifierParentChangementNotes(ResultatsBCC bloc, Etudiant etu) throws EtudiantInconnuException {
		// une note vient d'être modifiée
		// on peut recalculer la moyenne d'un étudiant dans cette UE
		// et propager l'information
		resultats_detailles.get(etu).replace((BCC) bloc.getELP(), bloc.resultats(etu));
		resultats.replace(etu, calculerMoyenneEtudiant(etu));
		parent.notifierParentChangementNotes(this, etu);
	}

	public ResultatsECUE getResultatsECUEByCodeAPOGEEId(String codeAPOGEE) {
		ResultatsECUE ecue_r = null;
		for (ResultatsBCC bloc : liste_ResultatsBCC) if ((ecue_r = bloc.getResultatsECUEByCodeAPOGEE(codeAPOGEE)) != null) return ecue_r;
		return null;
	}
	
	public ResultatsUE getResultatsUEByCodeAPOGEE(String codeAPOGEE) {
		ResultatsUE ue_r = null;
		for (ResultatsBCC bloc : liste_ResultatsBCC) if ((ue_r = bloc.getResultatsUEByCodeAPOGEE(codeAPOGEE)) != null) return ue_r;
		return null;
	}
	
	public ResultatsBCC getResultatsBCCByCodeAPOGEE(String codeAPOGEE) {
		for (ResultatsBCC bloc : liste_ResultatsBCC) if (bloc.getELP().codeAPOGEE.equals(codeAPOGEE)) return bloc;
		return null;
	}
}
