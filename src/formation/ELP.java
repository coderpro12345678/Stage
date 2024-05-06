package formation;

import java.util.Objects;

import releves.ResultatELP;

public abstract class ELP {

	public final String codeAPOGEE;
	public final String nom;
	public final int creditsECTS;
	
	public ELP(String codeAPOGEE, String nom, int creditsECTS) {
		Objects.requireNonNull(codeAPOGEE);
		Objects.requireNonNull(nom);
		Objects.requireNonNull(creditsECTS);
		this.codeAPOGEE = codeAPOGEE;
		this.nom = nom;
		this.creditsECTS = creditsECTS;
	}
	
	/**
	 * Un élément pédagogique va déterminer lui même si un étudiant valide ou non ce module
	 * Chaque ELP a ses propres regles (>10, note seuil, tous les bcc >10, etc.)
	 * @param resultatNumerique
	 * @return
	 */
	public abstract ResultatELP calculerResultat(float resultatNumerique);
	
	@Override
	public String toString() {
		return ""+codeAPOGEE+" - "+nom+" ("+creditsECTS+" credits)";
	}
}
