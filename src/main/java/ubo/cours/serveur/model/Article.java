package ubo.cours.serveur.model;

public class Article {
    private String type;
    private String idArticle;
    private String qte;
    private Prix prixUnitaire;
    private Prix prixTotal;

    public Article() {
    }

    public Article(String type, String idArticle, String qte, Prix prixUnitaire, Prix prixTotal) {
        this.type = type;
        this.idArticle = idArticle;
        this.qte = qte;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    public Prix getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Prix prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Prix getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Prix prixTotal) {
        this.prixTotal = prixTotal;
    }
}

