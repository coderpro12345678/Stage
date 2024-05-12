package resultats;


import java.util.HashMap;

import exception.EtudiantInconnuException;
import exception.M3CException;
import formation.ECUE;

import java.util.Objects;

import objet.Etudiant;
import objet.Promotion;

public class ResultatsECUE extends ResultatsELP {
	
	private final ResultatsUE parent;
	private final HashMap<Etudiant, Evaluation> resultats_detailles;

	public ResultatsECUE(ResultatsUE parent, ECUE ecue, Promotion promo) {
		super(ecue, promo);
		this.parent = parent;
		resultats_detailles = new HashMap<Etudiant, Evaluation>();
		for (Etudiant etu : promo) {
			resultats_detailles.put(etu, new Evaluation());
		}
	}

	private void verifierPresenceEtudiant(Etudiant etu, Note note) throws EtudiantInconnuException {
		Objects.requireNonNull(etu);
		Objects.requireNonNull(note);
		if (!resultats_detailles.containsKey(etu)) throw new EtudiantInconnuException();
	}
	
	public void ajouterNoteCT(Etudiant etu, Note note) throws EtudiantInconnuException, M3CException {
		verifierPresenceEtudiant(etu, note);
		if (!note.type.equals(TypeNote.CT)) throw new M3CException("La note rentrée doit être de type CT ("+getELP().codeAPOGEE+"/"+etu.numeroEtudiant+")");
		resultats_detailles.get(etu).setNoteCT(note);
		notifierParentChangementNotes(etu);
	}
	
	public void ajouterNoteCC(Etudiant etu, Note note) throws EtudiantInconnuException, M3CException {
		verifierPresenceEtudiant(etu, note);
		if (!note.type.equals(TypeNote.CC)) throw new M3CException("La note rentrée doit être de type CC ("+getELP().codeAPOGEE+"/"+etu.numeroEtudiant+")");
		resultats_detailles.get(etu).setNoteCC(note);
		notifierParentChangementNotes(etu);
	}
	
	private void notifierParentChangementNotes(Etudiant etu) throws EtudiantInconnuException {
		// Une note vient d'être modifiée, on peut actualier la moyenne de l'étudiant concerné
		// et avertir le parent de la modification
		resultats.replace(etu, calculerMoyenneEtudiant(etu));
		parent.notifierParentChangementNotes(this, etu);
	}
	
	public float calculerMoyenneEtudiant(Etudiant etu) throws EtudiantInconnuException {
		if (!resultats_detailles.containsKey(etu)) throw new EtudiantInconnuException();
		try {
			return ((ECUE) getELP()).typeECUE.calculerNote(resultats_detailles.get(etu));
		} catch (M3CException e) {
			// TODO afficher un message d'erreur et continuer avec le traitement
			// TODO gérer les cas avec absence --> DEF
			//e.printStackTrace();
			System.err.println(this.toString()+"  "+etu.toString()+"  "+e.getMessage());
			return 0f;
		}
	}
}