package ubo.cours.serveur.model;

public class Livre extends Entite {
    private String titre;
    private String auteur;
    private Prix prix;
    private String couverture;
    private String description;

    public Livre() {
    }

    public Livre(String id, String titre, String auteur, Prix prix, String couverture, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
        this.couverture = couverture;
        this.description = description;
        this.setId(id);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livre cd = (Livre) o;

        return getId().equals(cd.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
