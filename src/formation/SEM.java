package formation;

import java.util.ArrayList;
import java.util.Objects;


import releves.ResultatELP;
import releves.Statut;

public class SEM extends ELP {
	public final ArrayList<BCC> listeBCC;
	private final int hashCode;
	
	public SEM(String code, String nom, int credits, ArrayList<BCC> listeBCC) {
		this(code, nom, credits);
		Objects.requireNonNull(listeBCC);
		this.listeBCC.addAll(listeBCC);
	}
	
	public SEM(String codeAPOGEE, String nom, int creditsECTS) {
		super(codeAPOGEE, nom, creditsECTS);
		this.listeBCC = new ArrayList<BCC>();
		this.hashCode = Objects.hash(codeAPOGEE, nom, creditsECTS);
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}
	
	public void ajouterBCC(BCC bcc) {
		if (listeBCC.contains(bcc)) return; //On peut laisser ArrayList, le besoin d'un Set n'est pas justifié avec en moyenne 4 BCC par semestre...
		listeBCC.add(bcc);
	}
	
	public ECUE getECUEByCodeAPOGEE(String codeAPOGEE) {
		ECUE ecue = null;
		for (BCC bcc : listeBCC) if ((ecue = bcc.getECUEByCodeAPOGEE(codeAPOGEE)) != null) return ecue;
		return null;
	}
	
	public UE getUEByCodeAPOGEE(String codeAPOGEE) {
		UE ue = null;
		for (BCC bcc : listeBCC) if ((ue = bcc.getUEByCodeAPOGEE(codeAPOGEE)) != null) return ue;
		return null;
	}
	
	public BCC getBCCByCodeAPOGEE(String codeAPOGEE) {
		for (BCC bcc : listeBCC) if (bcc.codeAPOGEE.equals(codeAPOGEE)) return bcc;
		return null;
	}

	@Override
	public String toString() {
		String affiche = nom + " ("+creditsECTS+" credits)";
		for (BCC bcc : listeBCC) affiche += "\n"+bcc.toString();
		return affiche;
	}
	
	public String toString(int decalage) {
		String affiche = "";
		for (int i=0; i<decalage; i++) affiche += "  ";
		affiche += nom + " ("+creditsECTS+" credits)";
		for (BCC bcc : listeBCC) affiche += "\n"+bcc.toString(decalage+1);
		return affiche;
	}

	@Override
	public ResultatELP calculerResultat(float resultatNumerique) {
		// TODO vérifier les cas avec notes seuil, et les cas où aucune note n'est retournée (DEF)
		// TODO vérifier les cas où la matière n'est pas capitalisée mais compensée (COMP)
		Statut st = Statut.NACQ;
		if (resultatNumerique >= 10f) st = Statut.ACQ;
		return new ResultatELP(codeAPOGEE, this, resultatNumerique, st);
	}
}
