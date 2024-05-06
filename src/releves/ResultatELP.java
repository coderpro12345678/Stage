package releves;

import formation.ELP;

public class ResultatELP {

	public final String codeAPOGEE;
	public final ELP element;
	public final float resultat_numerique;
	public final Statut resultat;
	
	public ResultatELP(String codeAPOGEE, ELP element, float resultat_numerique, Statut resultat) {
		this.codeAPOGEE = codeAPOGEE;
		this.element = element;
		this.resultat_numerique = resultat_numerique;
		this.resultat = resultat;
	}

	public String afficherResultat() {
		return codeAPOGEE+" : "+resultat_numerique+"/20"+" ("+resultat.name()+")";
	}
}
