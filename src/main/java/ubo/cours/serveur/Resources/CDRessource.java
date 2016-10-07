package ubo.cours.serveur.Resources;

import com.google.common.collect.Lists;
import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Post;
import net.codestory.http.annotations.Prefix;
import net.codestory.http.annotations.Put;
import net.codestory.http.errors.NotFoundException;
import net.codestory.http.payload.Payload;
import ubo.cours.serveur.model.CD;
import ubo.cours.serveur.model.Prix;

import java.util.List;
import java.util.Optional;

@Prefix("/cd")
public class CDRessource {

    @Post("/")
    public void creer(CD cd) {
        ensembleDeCDs.add(cd);
    }

    @Put("/:id")
    public Payload maj(String id, CD cd) {

        return new Payload(201);
    }

    @Get("/")
    public List<CD> tousLesCDs() {
        return NotFoundException.notFoundIfNull(ensembleDeCDs);
    }

    @Get("/:id")
    public CD trouve(String id) {
        Optional<CD> cd = ensembleDeCDs.stream()
                .filter(candidatLivre -> id.equals(candidatLivre.getId()))
                .findFirst();

        return NotFoundException.notFoundIfNull(cd.get());
    }

    private List<CD> ensembleDeCDs;

    public CDRessource() {
        ensembleDeCDs = Lists.newArrayList(
                new CD("1", "Titre 1", "Chanteur 1", new Prix(10, "€"), "http://placehold.it/100x140"),
                new CD("2", "Titre 2", "Chanteur 1", new Prix(5, "€"), "http://placehold.it/100x140"),
                new CD("3", "Titre 3", "Chanteur 2", new Prix(15, "€"), "http://placehold.it/100x140"),
                new CD("4", "Titre 4", "Chanteur 3", new Prix(12, "€"), "http://placehold.it/100x140"),
                new CD("5", "Titre 5", "Chanteur 2", new Prix(9, "€"), "http://placehold.it/100x140"),
                new CD("6", "Titre 6", "Chanteur 4", new Prix(25, "€"), "http://placehold.it/100x140")
        );
    }
}

