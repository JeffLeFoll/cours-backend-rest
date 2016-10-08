package ubo.cours.serveur.Resources;

import com.google.common.collect.Lists;
import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Post;
import net.codestory.http.annotations.Prefix;
import net.codestory.http.annotations.Put;
import net.codestory.http.errors.NotFoundException;
import net.codestory.http.payload.Payload;
import ubo.cours.serveur.Depot;
import ubo.cours.serveur.model.Film;
import ubo.cours.serveur.model.Prix;

import java.util.List;
import java.util.Optional;

@Prefix("/film")
public class FilmRessource {

    @Post("/")
    public void creer(Film film) {
        ensembleDeFilms.ajouterDonnee(film);
    }

    @Put("/:id")
    public Payload maj(String id, Film film) {
        ensembleDeFilms.majDonnees(id, film);

        return new Payload(201);
    }

    @Get("")
    public List<Film> tousLesFilms() {
        return NotFoundException.notFoundIfNull(ensembleDeFilms.getDonnees());
    }

    @Get("/:id")
    public Film trouve(String id) {
        Optional<Film> film = ensembleDeFilms.getDonnee(id);

        return NotFoundException.notFoundIfNull(film.get());
    }

    private Depot<Film> ensembleDeFilms;

    public FilmRessource() {
        List<Film> films = Lists.newArrayList(
                new Film("1", "Film 1", "Acteur 1, Acteur 4", new Prix(38, "€"), "http://placehold.it/100x140", "action"),
                new Film("2", "Film 2", "Acteur 1, Acteur 2", new Prix(5, "€"), "http://placehold.it/100x140", "comedie"),
                new Film("3", "Film 3", "Acteur 2, Acteur 3", new Prix(18, "€"), "http://placehold.it/100x140", "drame"),
                new Film("4", "Film 4", "Acteur 3, Acteur 4", new Prix(22, "€"), "http://placehold.it/100x140", "comedie"),
                new Film("5", "Film 5", "Acteur 2, Acteur 1", new Prix(9, "€"), "http://placehold.it/100x140", "drame"),
                new Film("6", "Film 6", "Acteur 4, Acteur 2", new Prix(15, "€"), "http://placehold.it/100x140", "action")
        );

        ensembleDeFilms = new Depot<>();
        ensembleDeFilms.initialiserDepot(films);
    }
}

