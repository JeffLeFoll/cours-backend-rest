package ubo.cours.serveur;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.codestory.http.WebServer;
import net.codestory.http.extensions.Extensions;
import net.codestory.http.misc.Env;
import ubo.cours.serveur.Resources.*;

public class Serveur {

    public static void main(String[] args) {
        new WebServer().configure(routes -> {
            routes.add(LivreRessource.class);
            routes.add(CDRessource.class);
            routes.add(FilmRessource.class);
            routes.add(UtilisateurRessource.class);
            routes.add(CommandeRessource.class);

            routes.setExtensions(extensionDateTime());
        }).start();
    }

    private static Extensions extensionDateTime() {
        return new Extensions() {
            @Override
            public ObjectMapper configureOrReplaceObjectMapper(ObjectMapper defaultObjectMapper, Env env) {

                defaultObjectMapper.registerModule(new JavaTimeModule());

                return defaultObjectMapper;
            }
        };
    }
}

