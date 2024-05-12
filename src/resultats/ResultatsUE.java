package resultats;

import java.util.ArrayList;
import java.util.HashMap;

import exception.EtudiantInconnuException;
import formation.ECUE;
import formation.UE;
import objet.Etudiant;
import objet.Promotion;

public class ResultatsUE extends ResultatsELP {
	
	private final ResultatsBCC parent;
	private final HashMap<Etudiant, HashMap<ECUE, Float>> resultats_detailles; //résultats des ecue de l'ue
	public final ArrayList<ResultatsECUE> liste_ResultatsECUE;
	
	public ResultatsUE(ResultatsBCC parent, UE ue, Promotion promo) {
		super(ue, promo);
		this.parent = parent;
		this.resultats_detailles = new HashMap<Etudiant, HashMap<ECUE, Float>>();
		this.liste_ResultatsECUE = new ArrayList<ResultatsECUE>();
		
		for (Etudiant etu : promo) {
			HashMap<ECUE, Float> modules = new HashMap<ECUE, Float>();
			for (ECUE ecue : ue.listeECUE) modules.put(ecue, 0f);
			resultats_detailles.put(etu, modules);
		}
		for (ECUE ecue : ue.listeECUE) liste_ResultatsECUE.add(new ResultatsECUE(this, ecue, promo));
	}

	public float calculerMoyenneEtudiant(Etudiant etu) throws EtudiantInconnuException {
		if (!resultats_detailles.containsKey(etu)) throw new EtudiantInconnuException();
		float moyenne = 0f;
		for (ResultatsECUE bloc : liste_ResultatsECUE) moyenne += bloc.credits()*bloc.resultats(etu);
		return moyenne/credits();
	}

	public void notifierParentChangementNotes(ResultatsECUE bloc, Etudiant etu) throws EtudiantInconnuException {
		// une note vient d'être modifiée
		// on peut recalculer la moyenne d'un étudiant dans cette UE
		// et propager l'information
		resultats_detailles.get(etu).replace((ECUE) bloc.getELP(), bloc.resultats(etu));
		resultats.replace(etu, calculerMoyenneEtudiant(etu));
		parent.notifierParentChangementNotes(this, etu);
	}
	
	public ResultatsECUE getResultatsECUEByCodeAPOGEE(String codeAPOGEE) {
		for (ResultatsECUE bloc : liste_ResultatsECUE) if (bloc.getELP().codeAPOGEE.equals(codeAPOGEE)) return bloc;
		return null;
	}
}

