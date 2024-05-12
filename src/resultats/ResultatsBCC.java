package resultats;

import java.util.ArrayList;
import java.util.HashMap;

import exception.EtudiantInconnuException;
import formation.BCC;
import formation.UE;
import objet.Etudiant;
import objet.Promotion;

public class ResultatsBCC extends ResultatsELP {
	
	private final ResultatsSEM parent;
	private final HashMap<Etudiant, HashMap<UE, Float>> resultats_detailles; //résultats des ue du bcc
	public final ArrayList<ResultatsUE> liste_ResultatsUE;
	
	public ResultatsBCC(ResultatsSEM parent, BCC bcc, Promotion promo) {
		super(bcc, promo);
		this.parent = parent;
		this.resultats_detailles = new HashMap<Etudiant, HashMap<UE, Float>>();
		this.liste_ResultatsUE = new ArrayList<ResultatsUE>();
		
		for (Etudiant etu : promo) {
			HashMap<UE, Float> modules = new HashMap<UE, Float>();
			for (UE ue : bcc.listeUE) modules.put(ue, 0f);
			resultats_detailles.put(etu, modules);
		}
		for (UE ue : bcc.listeUE) liste_ResultatsUE.add(new ResultatsUE(this, ue, promo));
	}

	public float calculerMoyenneEtudiant(Etudiant etu) throws EtudiantInconnuException {
		if (!resultats_detailles.containsKey(etu)) throw new EtudiantInconnuException();
		float moyenne = 0f;
		for (ResultatsUE bloc : liste_ResultatsUE) moyenne += bloc.credits()*bloc.resultats(etu);
		return moyenne/credits();
	}
	
	public void notifierParentChangementNotes(ResultatsUE bloc, Etudiant etu) throws EtudiantInconnuException {
		// une note vient d'être modifiée
		// on peut recalculer la moyenne d'un étudiant dans cette UE
		// et propager l'information
		resultats_detailles.get(etu).replace((UE) bloc.getELP(), bloc.resultats(etu));
		resultats.replace(etu, calculerMoyenneEtudiant(etu));
		parent.notifierParentChangementNotes(this, etu);
	}
	
	public ResultatsECUE getResultatsECUEByCodeAPOGEE(String codeAPOGEE) {
		ResultatsECUE ecue_r = null;
		for (ResultatsUE bloc : liste_ResultatsUE) if ((ecue_r = bloc.getResultatsECUEByCodeAPOGEE(codeAPOGEE)) != null) return ecue_r;
		return null;
	}
	
	public ResultatsUE getResultatsUEByCodeAPOGEE(String codeAPOGEE) {
		for (ResultatsUE bloc : liste_ResultatsUE) if (bloc.getELP().codeAPOGEE.equals(codeAPOGEE)) return bloc;
		return null;
	}
}
