package ecue;

public class TypeECUE_CT extends TypeECUE {

	public static final String ACRO = "CT";
	private static final String LIB = "Contrôle terminal";
	
	public TypeECUE_CT() {
		super(ACRO, LIB, ReglesCalculManager.regleCT());
	}

	@Override
	public void modifierRegleCalculCCP(RegleCalculCCP regle) {}
}
