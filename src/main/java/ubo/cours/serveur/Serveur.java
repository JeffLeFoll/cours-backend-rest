package ubo.cours.serveur;

import net.codestory.http.WebServer;
import ubo.cours.serveur.Resources.CDRessource;
import ubo.cours.serveur.Resources.FilmRessource;
import ubo.cours.serveur.Resources.LivreRessource;

public class Serveur {

    public static void main(String[] args) {
        new WebServer().configure(routes -> {
            routes.add(LivreRessource.class);
            routes.add(CDRessource.class);
            routes.add(FilmRessource.class);
        }).start();
    }
}

