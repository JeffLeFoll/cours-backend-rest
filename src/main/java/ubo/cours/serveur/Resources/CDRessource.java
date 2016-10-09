package ubo.cours.serveur.Resources;

import com.google.common.collect.Lists;
import net.codestory.http.annotations.*;
import net.codestory.http.errors.NotFoundException;
import net.codestory.http.payload.Payload;
import ubo.cours.serveur.persistance.Depot;
import ubo.cours.serveur.model.CD;
import ubo.cours.serveur.model.Prix;

import java.util.List;
import java.util.Optional;

@Prefix("/cd")
public class CDRessource {

    @Post("/")
    @AllowOrigin("*")
    public void creer(CD cd) {
        ensembleDeCDs.ajouterDonnee(cd);
    }

    @Put("/:id")
    @AllowOrigin("*")
    public Payload maj(String id, CD cd) {
        ensembleDeCDs.majDonnees(id, cd);
        return new Payload(201);
    }

    @Get("")
    @AllowOrigin("*")
    public List<CD> tousLesCDs() {
        return NotFoundException.notFoundIfNull(ensembleDeCDs.getDonnees());
    }

    @Get("/:id")
    @AllowOrigin("*")
    public CD trouve(String id) {

        Optional<CD> cd = ensembleDeCDs.getDonnee(id);

        return NotFoundException.notFoundIfNull(cd.get());
    }

    private Depot<CD> ensembleDeCDs;

    public CDRessource() {
        List<CD> cds = Lists.newArrayList(
                new CD("1", "Titre 1", "Chanteur 1", new Prix(10, "€"), "http://placehold.it/100x140"),
                new CD("2", "Titre 2", "Chanteur 1", new Prix(5, "€"), "http://placehold.it/100x140"),
                new CD("3", "Titre 3", "Chanteur 2", new Prix(15, "€"), "http://placehold.it/100x140"),
                new CD("4", "Titre 4", "Chanteur 3", new Prix(12, "€"), "http://placehold.it/100x140"),
                new CD("5", "Titre 5", "Chanteur 2", new Prix(9, "€"), "http://placehold.it/100x140"),
                new CD("6", "Titre 6", "Chanteur 4", new Prix(25, "€"), "http://placehold.it/100x140")
        );

        ensembleDeCDs = new Depot<>();
        ensembleDeCDs.initialiserDepot(cds);
    }
}

