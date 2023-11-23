package fr.it_akademy.motus.dasha.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Partie {
    private Long id;
    private LocalDateTime dateHeureDebut;
    private static Long compteur = 0L;
    private Mot mot;
    private List<Essai> essais = new ArrayList<>();

    public Partie() {
        id = ++compteur;
    }

    public Partie(LocalDateTime dateHeureDebut) {
        this();
        this.dateHeureDebut = dateHeureDebut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public static Long getCompteur() {
        return compteur;
    }

    public static void setCompteur(Long compteur) {
        Partie.compteur = compteur;
    }

    public Mot getMot() {
        return mot;
    }

    public void setMot(Mot mot) {
        this.mot = mot;
    }

    public List<Essai> getEssais() {
        return essais;
    }

    public void setEssais(List<Essai> essais) {
        this.essais = essais;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((dateHeureDebut == null) ? 0 : dateHeureDebut.hashCode());
        result = prime * result + ((mot == null) ? 0 : mot.hashCode());
        result = prime * result + ((essais == null) ? 0 : essais.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Partie other = (Partie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (dateHeureDebut == null) {
            if (other.dateHeureDebut != null)
                return false;
        } else if (!dateHeureDebut.equals(other.dateHeureDebut))
            return false;
        if (mot == null) {
            if (other.mot != null)
                return false;
        } else if (!mot.equals(other.mot))
            return false;
        if (essais == null) {
            if (other.essais != null)
                return false;
        } else if (!essais.equals(other.essais))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Partie [id=" + id + ", dateHeureDebut=" + dateHeureDebut + ", mot=" + mot + ", essais=" + essais + "]";
    }

}
