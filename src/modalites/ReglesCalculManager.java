package modalites;

import notation.CTCC;

public class ReglesCalculManager {
	public static RegleCalculCCP regle2CT1CC() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(CTCC tn) {
				return (2f*tn.getNoteCT().getNote()+tn.getNoteCC().getNote())/3f;
			}
		};
	}
	
	public static RegleCalculCCP regle2CT1CC_MAX() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(CTCC tn) {
				return Math.max(((2f*tn.getNoteCT().getNote()+tn.getNoteCC().getNote())/3f), tn.getNoteCT().getNote());
			}
		};
	}
	
	public static RegleCalculCCP regleCT() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(CTCC tn) {
				return tn.getNoteCT().getNote();
			}
		};
	}
	
	public static RegleCalculCCP regleECI() {
		return new RegleCalculCCP() {
			@Override
			public float calculer(CTCC tn) {
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
		if (attribute.equals("CT")){
			return regleCT();
		}
		return regleECI();
		
		//TODO etc.
	}
}
