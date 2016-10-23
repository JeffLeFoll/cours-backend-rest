package ubo.cours.serveur.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class Commande extends Entite {
    private String userId;
    private String adresseExpedition;
    private List<Article> articlesCommandes;
    private Prix montantCommande;
    private Instant dateCommande;

    public Commande() {
    }

    public Commande(String idCommande, String userId, String adresseExpedition, List<Article> articlesCommandes, Prix montantCommande, Instant dateCommande) {
        this.userId = userId;
        this.adresseExpedition = adresseExpedition;
        this.articlesCommandes = articlesCommandes;
        this.montantCommande = montantCommande;
        this.dateCommande = dateCommande;
        this.setId(idCommande);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdresseExpedition() {
        return adresseExpedition;
    }

    public void setAdresseExpedition(String adresseExpedition) {
        this.adresseExpedition = adresseExpedition;
    }

    public List<Article> getArticlesCommandes() {
        return articlesCommandes;
    }

    public void setArticlesCommandes(List<Article> articlesCommandes) {
        this.articlesCommandes = articlesCommandes;
    }

    public Prix getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(Prix montantCommande) {
        this.montantCommande = montantCommande;
    }


    public Instant getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Instant dateCommande) {
        this.dateCommande = dateCommande;
    }

}
