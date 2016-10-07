package ubo.cours.serveur.Resources;

import com.google.common.collect.Lists;
import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Post;
import net.codestory.http.annotations.Prefix;
import net.codestory.http.annotations.Put;
import net.codestory.http.errors.NotFoundException;
import net.codestory.http.payload.Payload;
import ubo.cours.serveur.model.Livre;
import ubo.cours.serveur.model.Prix;

import java.util.List;
import java.util.Optional;

@Prefix("/livre")
public class LivreRessource {

    @Post("/")
    public void creer(Livre livre) {
        ensembleDeLivres.add(livre);
    }

    @Put("/:id")
    public Payload maj(String id, Livre livre) {

        return new Payload(201);
    }

    @Get("/")
    public List<Livre> tousLesLivres() {
        return NotFoundException.notFoundIfNull(ensembleDeLivres);
    }

    @Get("/:id")
    public Livre trouve(String id) {
        Optional<Livre> livre = ensembleDeLivres.stream()
                .filter(candidatLivre -> id.equals(candidatLivre.getId()))
                .findFirst();

        return NotFoundException.notFoundIfNull(livre.get());
    }

    private List<Livre> ensembleDeLivres;

    public LivreRessource() {
        ensembleDeLivres = Lists.newArrayList(
                new Livre("1", "livre 1", "auteur 1", new Prix(10, "€"), "http://placehold.it/100x140", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In scelerisque luctus quam, eu luctus justo mollis nec. Sed eu leo a erat posuere posuere. In velit felis, cursus et lectus vitae, maximus feugiat ipsum. Pellentesque eget nisi interdum, elementum libero ac, venenatis lorem. Integer in finibus nisi. Suspendisse potenti. Morbi sit amet dui id lacus pulvinar placerat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque lacus nibh, eleifend quis nisl vitae, vestibulum interdum felis. Curabitur lacinia arcu mauris, sit amet volutpat eros vehicula non. Sed tincidunt nisi a tristique finibus"),
                new Livre("2", "livre 2", "auteur 1", new Prix(10, "€"), "http://placehold.it/100x140", "Nulla facilisi. Morbi interdum, ipsum ut euismod rhoncus, nibh dui fringilla nisi, a aliquet dui dui in augue. Nam sollicitudin finibus eros, id lobortis quam. Maecenas vitae iaculis dui. Quisque vitae est in arcu bibendum laoreet id sit amet risus. Morbi sed orci at nisi vestibulum sagittis. Proin eget porta dui, sit amet tempor nisi. In hac habitasse platea dictumst. Nulla facilisi. Donec fringilla magna volutpat, suscipit arcu in, efficitur nisi. Praesent in convallis est. Duis pulvinar, leo quis congue ullamcorper, tellus diam pulvinar neque, in condimentum quam ex quis erat."),
                new Livre("3", "livre 3", "auteur 2", new Prix(10, "€"), "http://placehold.it/100x140", "Mauris nec malesuada libero. Sed viverra rutrum purus. Curabitur id lectus congue, laoreet magna id, tincidunt augue. Nam eu diam malesuada, pharetra tellus quis, placerat leo. Nulla consequat a tortor molestie malesuada. Proin ligula nisi, ultricies at enim nec, vestibulum dignissim nisi. Vivamus quis tempor sapien. Nam nec leo lacinia nisl finibus posuere."),
                new Livre("4", "livre 4", "auteur 3", new Prix(10, "€"), "http://placehold.it/100x140", "Curabitur convallis ac risus id placerat. Integer malesuada lacus at tellus rhoncus, quis lobortis odio bibendum. Phasellus sollicitudin nec quam ac pellentesque. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam erat volutpat. Curabitur ornare neque massa, at tincidunt tortor maximus sed."),
                new Livre("5", "livre 5", "auteur 2", new Prix(10, "€"), "http://placehold.it/100x140", "Proin a rutrum quam. Vestibulum et commodo leo. Sed sit amet turpis eget lectus feugiat pellentesque non et ipsum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Cras tempor porta nisl. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Interdum et malesuada fames ac ante ipsum primis in faucibus."),
                new Livre("6", "livre 6", "auteur 4", new Prix(10, "€"), "http://placehold.it/100x140", "Sed pulvinar pretium neque sed auctor. Sed egestas sem non augue aliquam, vel rhoncus mauris blandit. Phasellus id ullamcorper neque. Mauris condimentum posuere tortor id euismod. Donec quis diam a magna euismod ultrices vitae vitae nunc. Pellentesque molestie, justo sit amet sagittis commodo, augue sem venenatis sem, nec hendrerit sapien risus sed leo.")
        );
    }
}
