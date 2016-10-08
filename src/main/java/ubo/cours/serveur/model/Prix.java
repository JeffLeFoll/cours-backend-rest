package ubo.cours.serveur.model;

public class Prix {

    private int valeur;
    private String devise;

    public Prix() {
    }

    public Prix(int valeur, String devise) {
        this.valeur = valeur;
        this.devise = devise;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }
}
