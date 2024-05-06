package resultats;


import java.util.HashMap;
import java.util.Map.Entry;

import exception.EtudiantInconnuException;
import formation.ECUE;

import java.util.Objects;

import notation.CTCC;
import notation.Note;
import objet.Etudiant;

public class Releve_ECUE extends ECUE {
	
	public final HashMap<Etudiant, CTCC> notes;

	public Releve_ECUE(ECUE ecue) {
		super(ecue);
		notes = new HashMap<Etudiant, CTCC>();
	}

	private void verifierEtuTriplet(Etudiant etu, Note n) {
		Objects.requireNonNull(etu);
		Objects.requireNonNull(n);
		if (!notes.containsKey(etu)) notes.put(etu, new CTCC());
	}
	
	public void ajouterNoteCT(Etudiant etu, Note n) {
		verifierEtuTriplet(etu, n);
		notes.get(etu).setNoteCT(n);
	}
	
	public void ajouterNoteCC(Etudiant etu, Note n) {
		verifierEtuTriplet(etu, n);
		notes.get(etu).setNoteCC(n);
	}
	
	public float calculerMoyenneEtudiant(Etudiant etu) throws EtudiantInconnuException {
		if (!notes.containsKey(etu)) throw new EtudiantInconnuException();
		return type.calculerNote(notes.get(etu));
	}
	
	public float calculerMoyenneECUE() {
		if (notes.size() <= 0) return 0f;
		float moy = 0f;
		for (Entry<Etudiant, CTCC> etuNote : notes.entrySet()) moy += type.calculerNote(etuNote.getValue());
		return moy/notes.size();
	}
}