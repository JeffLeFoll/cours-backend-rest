package ubo.cours.serveur.Resources;

import com.google.common.collect.Lists;
import net.codestory.http.annotations.*;
import net.codestory.http.errors.NotFoundException;
import net.codestory.http.payload.Payload;
import ubo.cours.serveur.persistance.Depot;
import ubo.cours.serveur.model.Film;
import ubo.cours.serveur.model.Prix;

import java.util.List;
import java.util.Optional;

@Prefix("/film")
public class FilmRessource {

    @Post("/")
    @AllowOrigin("*")
    public void creer(Film film) {
        ensembleDeFilms.ajouterDonnee(film);
    }

    @Put("/:id")
    @AllowOrigin("*")
    public Payload maj(String id, Film film) {
        ensembleDeFilms.majDonnees(id, film);

        return new Payload(201);
    }

    @Get("")
    @AllowOrigin("*")
    public List<Film> tousLesFilms() {
        return NotFoundException.notFoundIfNull(ensembleDeFilms.getDonnees());
    }

    @Get("/:id")
    @AllowOrigin("*")
    public Film trouve(String id) {
        Optional<Film> film = ensembleDeFilms.getDonnee(id);

        return NotFoundException.notFoundIfNull(film.get());
    }

    private Depot<Film> ensembleDeFilms;

    public FilmRessource() {
        List<Film> films = Lists.newArrayList(
                new Film("1", "Les évadés (1994)", "Tim Robbins, Morgan Freeman, Bob Gunton", new Prix(38, "€"), "https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1_SY1000_CR0,0,672,1000_AL_.jpg", "Crime, Drama", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."),
                new Film("2", "Le parrain (1972)", "Marlon Brando, Al Pacino, James Caan", new Prix(5, "€"), "https://images-na.ssl-images-amazon.com/images/M/MV5BNTUxOTdjMDMtMWY1MC00MjkxLTgxYTMtYTM1MjU5ZTJlNTZjXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,706,1000_AL_.jpg", "Crime, Drama", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."),
                new Film("3", "The Dark Knight (2008)", "Christian Bale, Heath Ledger, Aaron Eckhart, Morgan Freeman", new Prix(18, "€"), "https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg", "Action, Crime, Drama", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice."),
                new Film("4", "Pulp Fiction (1994)", " John Travolta, Uma Thurman, Samuel L. Jackson", new Prix(22, "€"), "https://images-na.ssl-images-amazon.com/images/M/MV5BMTkxMTA5OTAzMl5BMl5BanBnXkFtZTgwNjA5MDc3NjE@._V1_SY1000_CR0,0,673,1000_AL_.jpg", "crime, drama", "The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption."),
                new Film("5", "Le seigneur des anneaux: Le retour du roi (2003)", "Elijah Wood, Viggo Mortensen, Ian McKellen, Sean Bean", new Prix(9, "€"), "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE4MjA1NTAyMV5BMl5BanBnXkFtZTcwNzM1NDQyMQ@@._V1_.jpg", "Adventure, Drama, Fantasy", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."),
                new Film("6", "Le bon, la brute et le truand (1966)", " Clint Eastwood, Eli Wallach, Lee Van Cleef ", new Prix(15, "€"), "https://images-na.ssl-images-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1_SY1000_CR0,0,656,1000_AL_.jpg", "western ", "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.")
        );

        ensembleDeFilms = new Depot<>();
        ensembleDeFilms.initialiserDepot(films);
    }
}

