package resultats;

import java.util.HashMap;

import exception.EtudiantInconnuException;
import formation.ELP;
import objet.Etudiant;
import objet.Promotion;

public abstract class ResultatsELP {

	private final ELP elp;
	protected final HashMap<Etudiant, Float> resultats; //résultats des etudiants dans cette ELP
	
	public ResultatsELP(ELP elp, Promotion promo) {
		this.elp = elp;
		this.resultats = new HashMap<Etudiant, Float>();
		for (Etudiant etu : promo) {
			resultats.put(etu, 0f);
		}
	}
	
	public abstract float calculerMoyenneEtudiant(Etudiant etudiant) throws EtudiantInconnuException;
	public float calculerMoyenneELP() throws EtudiantInconnuException {
		if (resultats.size() <= 0) return 0f;
		float moy = 0f;
		for (Etudiant etu : resultats.keySet()) moy += calculerMoyenneEtudiant(etu);
		return moy/resultats.size();
	}
	
	public Float resultats(Etudiant etu) throws EtudiantInconnuException {
		if (!resultats.containsKey(etu)) throw new EtudiantInconnuException();
		return resultats.get(etu);
	}
	
	public ELP getELP() {
		return elp;
	}
	
	public float credits() {
		return elp.creditsECTS;
	}
	
	@Override
	public String toString() {
		return getELP().codeAPOGEE;
	}
}
