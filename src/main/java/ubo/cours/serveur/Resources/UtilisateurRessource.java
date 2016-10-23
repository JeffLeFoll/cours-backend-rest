package ubo.cours.serveur.Resources;

import com.google.common.collect.Lists;
import net.codestory.http.annotations.*;
import net.codestory.http.errors.NotFoundException;
import net.codestory.http.payload.Payload;
import ubo.cours.serveur.model.Prix;
import ubo.cours.serveur.model.Utilisateur;
import ubo.cours.serveur.persistance.Depot;

import java.util.List;
import java.util.Optional;

@Prefix("/user")
public class UtilisateurRessource {

    @Post("/")
    @AllowOrigin("*")
    public void creer(Utilisateur utilisateur) {
        ensembleDeUtilisateurs.ajouterDonnee(utilisateur);
    }

    @Put("/:id")
    @AllowOrigin("*")
    public Payload maj(String id, Utilisateur utilisateur) {
        ensembleDeUtilisateurs.majDonnees(id, utilisateur);
        return new Payload(201);
    }

    @Get("")
    @AllowOrigin("*")
    public List<Utilisateur> tousLesUtilisateurs() {
        return NotFoundException.notFoundIfNull(ensembleDeUtilisateurs.getDonnees());
    }

    @Get("/:id")
    @AllowOrigin("*")
    public Utilisateur trouve(String id) {

        Optional<Utilisateur> utilisateur = ensembleDeUtilisateurs.getDonnee(id);

        return NotFoundException.notFoundIfNull(utilisateur.get());
    }

    private Depot<Utilisateur> ensembleDeUtilisateurs;

    public UtilisateurRessource() {
        List<Utilisateur> utilisateurs = Lists.newArrayList(
                new Utilisateur("1", "Solo", "Han", "ishotfirst@kesselrunin12.parsecs" ),
                new Utilisateur("2", "Wayne", "Bruce", "batman@gotham.hero" ),
                new Utilisateur("3", "Gordon", "James", "commisaire@gotham.police" ),
                new Utilisateur("4", "Nigma", "Edward", "riddler@gotham.vilain" )
        );

        ensembleDeUtilisateurs = new Depot<>();
        ensembleDeUtilisateurs.initialiserDepot(utilisateurs);
    }
}
