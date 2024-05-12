package resultats;

import exception.M3CException;

public class Evaluation {

	private Note noteCT;
	private Note noteCC;
	
	public Note getNoteCT() throws M3CException {
		if (noteCT == null) throw new M3CException("Il manque une note de CT");
		return noteCT;
	}
	
	public void setNoteCT(Note noteCT) {
		this.noteCT = noteCT;
	}
	
	public Note getNoteCC() throws M3CException {
		if (noteCC == null) throw new M3CException("Il manque une note de CC");
		return noteCC;
	}
	
	public void setNoteCC(Note noteCC) {
		this.noteCC = noteCC;
	}
}
