package fr.it_akademy.motus.dasha.business;

import java.time.LocalDateTime;

public class Essai {
    private Long id;
    private String contenu;
    private LocalDateTime dateHeureEnvoi;
    private static Long compteur = 0L;
    private Partie partie;

    public Essai() {
        id = ++compteur;
    }

    public Essai(String contenu, LocalDateTime dateHeureEnvoi) {
        this();
        this.contenu = contenu;
        this.dateHeureEnvoi = dateHeureEnvoi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDateHeureEnvoi() {
        return dateHeureEnvoi;
    }

    public void setDateHeureEnvoi(LocalDateTime dateHeureEnvoi) {
        this.dateHeureEnvoi = dateHeureEnvoi;
    }

    public static Long getCompteur() {
        return compteur;
    }

    public static void setCompteur(Long compteur) {
        Essai.compteur = compteur;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((contenu == null) ? 0 : contenu.hashCode());
        result = prime * result + ((dateHeureEnvoi == null) ? 0 : dateHeureEnvoi.hashCode());
        result = prime * result + ((partie == null) ? 0 : partie.hashCode());
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
        Essai other = (Essai) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (contenu == null) {
            if (other.contenu != null)
                return false;
        } else if (!contenu.equals(other.contenu))
            return false;
        if (dateHeureEnvoi == null) {
            if (other.dateHeureEnvoi != null)
                return false;
        } else if (!dateHeureEnvoi.equals(other.dateHeureEnvoi))
            return false;
        if (partie == null) {
            if (other.partie != null)
                return false;
        } else if (!partie.equals(other.partie))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Essai [id=" + id + ", contenu=" + contenu + ", dateHeureEnvoi=" + dateHeureEnvoi + ", partie=" + partie
                + "]";
    }

}
