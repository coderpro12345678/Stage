package objet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import modalites.Grade;
import modalites.Mention;

import java.util.Objects;
import java.util.TreeMap;

public class Promotion implements Iterable<Etudiant> {

	public final Grade niveau;
	public final Mention mention;
	public final String parcours;
	public final String nom;
	public final TreeMap<Integer, Etudiant> listeEtudiant;
	
	public Promotion(Grade niveau, Mention mention, String parcours, String nom) {
		Objects.requireNonNull(niveau);
		Objects.requireNonNull(mention);
		Objects.requireNonNull(nom);
		this.niveau = niveau;
		this.mention = mention;
		this.parcours = parcours;
		this.nom = nom;
		listeEtudiant = new TreeMap<Integer, Etudiant>();
	}
	
	public void ajouterEtudiant(Etudiant etu) {
		if (listeEtudiant.containsKey(etu.numeroEtudiant)) return;
		listeEtudiant.put(etu.numeroEtudiant, etu);
	}
	
	@Override
	public String toString() {
		String affiche = "";
		affiche += niveau+" "+mention;
		if (parcours != "") affiche += " "+parcours;
		affiche += " ("+nom+")";
		for (Entry<Integer, Etudiant> etu : listeEtudiant.entrySet()) affiche += "\n"+etu.getValue().toString();
		return affiche;
	}

	public Etudiant getEtudiantParId(int numEtu) {
		return listeEtudiant.get(numEtu);
	}

	@Override
	public Iterator<Etudiant> iterator() {
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>(listeEtudiant.values());
		return etudiants.iterator();
	}
}
