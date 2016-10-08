package ubo.cours.serveur;

import net.codestory.http.errors.NotFoundException;
import ubo.cours.serveur.model.Entite;
import ubo.cours.serveur.model.Livre;

import java.util.List;
import java.util.Optional;

public class Depot<T extends Entite> {
    private List<T> donneesDuDepot;

    public Depot() {
    }

    public void initialiserDepot(List<T> donnees) {
        donneesDuDepot = donnees;
    }

    public void majDonnees(String id, T nouvelleDonnee) {
        Optional<T> ancienneDonnee = donneesDuDepot.stream()
                .filter(element -> id.equals(element.getId()))
                .findFirst();

        T donneeARemplacer = ancienneDonnee.orElseThrow(() -> new NotFoundException());

        int index = donneesDuDepot.indexOf(donneeARemplacer);

        donneesDuDepot.remove(index);
        donneesDuDepot.add(index, nouvelleDonnee);
    }

    public List<T> getDonnees() {
        return donneesDuDepot;
    }

    public Optional<T> getDonnee(String id) {
        return donneesDuDepot.stream()
                .filter(element -> id.equals(element.getId()))
                .findFirst();
    }

    public void ajouterDonnee(T livre) {
        int id = donneesDuDepot.size() + 1;
        livre.setId(String.valueOf(id));
        donneesDuDepot.add(livre);
    }
}
