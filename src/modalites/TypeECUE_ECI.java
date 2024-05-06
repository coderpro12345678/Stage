package modalites;

public class TypeECUE_ECI extends TypeECUE {

	public static final String ACRO = "ECI";
	private static final String LIB = "Evaluation continue intégrale";
	
	public TypeECUE_ECI() {
		super(ACRO, LIB, ReglesCalculManager.regleECI());
	}

	@Override
	public void modifierRegleCalculCCP(RegleCalculCCP regle) {}
}
