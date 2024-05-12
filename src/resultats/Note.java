package resultats;
import java.util.Objects;

import exception.NoteBorneException;

public class Note {

	private static final float MIN_VAL = 0f;
	private static final float MAX_VAL = 20f;
	private float valeur;
	public final TypeNote type;
	
	public Note(TypeNote tn) {
		Objects.requireNonNull(tn);
		type = tn;
	}
	
	public Note(float v, TypeNote tn) throws NoteBorneException {
		this(tn);
		modifierNote(v);
	}
	
	public void modifierNote(float v) throws NoteBorneException {
		Objects.requireNonNull(v);
		if (v < MIN_VAL || v > MAX_VAL) throw new NoteBorneException("La note doit être entre 0 et 20");
		valeur = v;
	}
	
	public float getNote() {
		return valeur;
	}
}