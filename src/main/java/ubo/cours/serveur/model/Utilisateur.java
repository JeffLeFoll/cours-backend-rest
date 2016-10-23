package ubo.cours.serveur.model;

public class Utilisateur extends Entite {
    private String nom;
    private String prenom;
    private String email;

    public Utilisateur() {
    }

    public Utilisateur(String id, String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.setId(id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
