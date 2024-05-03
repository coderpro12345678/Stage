package objet;

import java.util.Objects;

public class Enseignant implements Comparable<Enseignant> {

    public final int IdEnseignant;
    public final String nom;
    public final String prenom;
    public final String adresseMail;
    public final int hashCode;

    public Enseignant(int IdEnseignant, String nom, String prenom, String adresseMail) {
        Objects.requireNonNull(nom);
        Objects.requireNonNull(prenom);
        Objects.requireNonNull(adresseMail);
        Objects.requireNonNull(IdEnseignant);
        this.IdEnseignant = IdEnseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.hashCode = Objects.hash(IdEnseignant, nom, prenom, adresseMail);
    }

    @Override
    public String toString() {
        String affiche = prenom + " " + nom.toUpperCase() + " " + adresseMail;
        return affiche;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public int compareTo(Enseignant e) {
        int diff = nom.compareTo(e.nom);
        if (diff == 0) diff = prenom.compareTo(e.prenom);
        if (diff == 0) diff = Integer.compare(IdEnseignant, e.IdEnseignant);
        if (diff == 0) diff = adresseMail.compareTo(e.adresseMail);
        return diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enseignant)) return false;
        Enseignant e = (Enseignant) o;
        return IdEnseignant == e.IdEnseignant && nom.equals(e.nom) && prenom.equals(e.prenom) &&
                adresseMail.equals(e.adresseMail);
    }
}

