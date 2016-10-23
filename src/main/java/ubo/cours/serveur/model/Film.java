package ubo.cours.serveur.model;

public class Film extends Entite {
    private String titre;
    private String acteurs;
    private Prix prix;
    private String jaquette;
    private String type;
    private String description;

    public Film() {
    }

    public Film(String id, String titre, String acteurs, Prix prix, String jaquette, String type, String description) {
        this.titre = titre;
        this.acteurs = acteurs;
        this.prix = prix;
        this.jaquette = jaquette;
        this.type = type;
        this.description = description;
        this.setId(id);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public String getJaquette() {
        return jaquette;
    }

    public void setJaquette(String jaquette) {
        this.jaquette = jaquette;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film cd = (Film) o;

        return getId().equals(cd.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
