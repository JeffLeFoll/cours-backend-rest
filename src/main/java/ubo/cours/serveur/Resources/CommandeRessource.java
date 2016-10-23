package ubo.cours.serveur.Resources;

import com.google.common.collect.Lists;
import net.codestory.http.annotations.*;
import net.codestory.http.errors.NotFoundException;
import net.codestory.http.payload.Payload;
import ubo.cours.serveur.model.Article;
import ubo.cours.serveur.model.Commande;
import ubo.cours.serveur.model.Prix;
import ubo.cours.serveur.persistance.Depot;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Prefix("/commande")
public class CommandeRessource {
    @Post("/")
    @AllowOrigin("*")
    public void creer(Commande commande) {
        ensembleDeCommandes.ajouterDonnee(commande);
    }

    @Put("/:id")
    @AllowOrigin("*")
    public Payload maj(String id, Commande commande) {
        ensembleDeCommandes.majDonnees(id, commande);
        return new Payload(201);
    }

    @Get("")
    @AllowOrigin("*")
    public List<Commande> tousLesCommandes() {
        return NotFoundException.notFoundIfNull(ensembleDeCommandes.getDonnees());
    }

    @Get("/:id")
    @AllowOrigin("*")
    public Commande trouve(String id) {

        Optional<Commande> commande = ensembleDeCommandes.getDonnee(id);

        return NotFoundException.notFoundIfNull(commande.get());
    }

    private Depot<Commande> ensembleDeCommandes;

    public CommandeRessource() {
        List<Commande> commandes = Lists.newArrayList(
                new Commande("1", "1", "Mos Eisley Cantina, Mos Eisley - Tatooine", Lists.newArrayList(new Article("livre", "2", "1", new Prix(12, "€"), new Prix(12, "€")), new Article("film", "3", "1", new Prix(18, "€"), new Prix(18, "€"))), new Prix(30, "€"), Instant.parse("2016-09-13T14:34:33Z")),
                new Commande("2", "3", "GCPD, Gotham City", Lists.newArrayList(new Article("cd", "4", "2", new Prix(9, "€"), new Prix(18, "€")), new Article("film", "5", "1", new Prix(20, "€"), new Prix(20, "€"))), new Prix(38, "€"), Instant.parse("2016-09-29T20:22:00Z")),
                new Commande("3", "2", "Wayne Manor , Gotham City", Lists.newArrayList(new Article("livre", "6", "1", new Prix(9, "€"), new Prix(9, "€")), new Article("cd", "4", "1", new Prix(10, "€"), new Prix(10, "€"))), new Prix(19, "€"), Instant.parse("2016-10-27T02:12:13Z"))
        );

        ensembleDeCommandes = new Depot<>();
        ensembleDeCommandes.initialiserDepot(commandes);
    }
}
