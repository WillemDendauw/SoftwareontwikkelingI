package sorteren2017;

import java.util.Objects;

/**
 *
 * @author tiwi
 */
public class Boek implements Comparable<Boek>, Cloneable {

    private final String titel;
    private String auteur;

    public Boek(String titel, String auteur) {
        this.titel = titel;
        this.auteur = auteur;
    }

    @Override
    public int compareTo(Boek o) {
        return this.titel.compareTo(o.titel);
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitel() {
        return titel;
    }

    public String toString() {
        return titel + " (" + auteur + ") ";
    }

    @Override
    public Boek clone() {
        try {
            return (Boek) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.titel);
        hash = 47 * hash + Objects.hashCode(this.auteur);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Boek other = (Boek) obj;
        if (!Objects.equals(this.titel, other.titel)) {
            return false;
        }
        if (!Objects.equals(this.auteur, other.auteur)) {
            return false;
        }
        return true;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    // VERVANG DEZE COPYCONSTRUCTOR DOOR clone()
    public Boek(Boek ander) {
        this.titel = ander.titel;
        this.auteur = ander.auteur;
    }
}
