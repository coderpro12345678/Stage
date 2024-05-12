package modalites;

import exception.M3CException;
import resultats.Evaluation;

public class ReglesCalculManager {

	public static RegleCalculCCP regle2CT1CC() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(Evaluation tn) throws M3CException {
				return (2f*tn.getNoteCT().getNote()+tn.getNoteCC().getNote())/3f;
			}
		};
	}
	
	public static RegleCalculCCP regle2CT1CC_MAX() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(Evaluation tn) throws M3CException {
				return Math.max(((2f*tn.getNoteCT().getNote()+tn.getNoteCC().getNote())/3f), tn.getNoteCT().getNote());
			}
		};
	}
	
	public static RegleCalculCCP regleCT() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(Evaluation tn) throws M3CException {
				return tn.getNoteCT().getNote();
			}
		};
	}
	
	public static RegleCalculCCP regleECI() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(Evaluation tn) throws M3CException {
				return tn.getNoteCC().getNote();
			}
		};
	}

	public static RegleCalculCCP parseFromString(String attribute) {
		if (attribute.equals("2CT1CC")) {
			return regle2CT1CC();
		}
		
		if (attribute.equals("2CT1CC_MAX")) {
			return regle2CT1CC_MAX();
		}
		return regleECI();
		
		//TODO etc.
	}
}
