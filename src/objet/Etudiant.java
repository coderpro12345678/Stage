package objet;

import java.util.Objects;

public class Etudiant implements Comparable<Etudiant> {

	public final String nom;
	public final String prenom;
	public final String DateN;//ajout
	public final String adresseMail;//ajout
	public final int numeroEtudiant;
	public final int hashCode;
	
	public Etudiant(int numeroEtudiant, String nom, String prenom, String DateN, String adresseMail ) {
		Objects.requireNonNull(numeroEtudiant);
		Objects.requireNonNull(nom);
		Objects.requireNonNull(prenom);
		Objects.requireNonNull(DateN);
		Objects.requireNonNull(adresseMail);
		this.nom = nom;
		this.prenom = prenom;
		this.numeroEtudiant = numeroEtudiant;
		this.adresseMail=adresseMail;
		this.DateN = DateN;
		this.hashCode = Objects.hash(numeroEtudiant, nom, prenom, DateN, adresseMail);
	}
	
	@Override
	public String toString() {
		String affiche = numeroEtudiant+" - "+prenom+" "+nom.toUpperCase() + " " + DateN + " " + adresseMail;
		return affiche;
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public int compareTo(Etudiant e) {
		int diff = nom.compareTo(e.nom);
		if (diff == 0) diff = prenom.compareTo(e.prenom);
		if (diff == 0) diff = numeroEtudiant - e.numeroEtudiant;
		if (diff ==0) diff =  DateN.compareTo(e.DateN);
		if (diff == 0) diff = adresseMail.compareTo(e.adresseMail);
		return diff;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Etudiant)) return false;
		Etudiant e = (Etudiant) o;
		return numeroEtudiant == e.numeroEtudiant && nom.equals(e.nom) && prenom.equals(e.prenom) && 
				adresseMail.equals(e.adresseMail)  && DateN.equals(e.adresseMail) ;
	}
}