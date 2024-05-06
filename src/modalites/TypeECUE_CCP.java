package modalites;

public class TypeECUE_CCP extends TypeECUE {

	public static final String ACRO = "CCP";
	private static final String LIB = "Contrôle continu partiel";
	
	public TypeECUE_CCP() {
		this(ReglesCalculManager.regle2CT1CC()); // regle par defaut
	}
	
	public TypeECUE_CCP(RegleCalculCCP regle) {
		super(ACRO, LIB, regle);
	}

	@Override
	public void modifierRegleCalculCCP(RegleCalculCCP regle) {
		regleCalculCCP = regle;
	}

	
}
