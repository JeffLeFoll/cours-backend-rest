package ubo.cours.serveur.model;

public class CD extends Entite {
    private String titre;
    private String chanteur;
    private Prix prix;
    private String jaquette;

    public CD() {
    }

    public CD(String id, String titre, String chanteur, Prix prix, String jaquette) {
        this.titre = titre;
        this.chanteur = chanteur;
        this.prix = prix;
        this.jaquette = jaquette;
        this.setId(id);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getChanteur() {
        return chanteur;
    }

    public void setChanteur(String chanteur) {
        this.chanteur = chanteur;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CD cd = (CD) o;

        return getId().equals(cd.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
