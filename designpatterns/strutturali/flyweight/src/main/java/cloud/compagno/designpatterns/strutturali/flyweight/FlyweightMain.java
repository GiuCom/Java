package cloud.compagno.designpatterns.strutturali.flyweight;

public class FlyweightMain {
    static void main() {
        FlyweightFactory factory = new FlyweightFactory();

        Foresta foresta = new Foresta(factory);
        // Pianta alberi con testo in italiano
        foresta.inserisciAlbero(0, 0, "Quercia", "Verde", "Ruvida");
        foresta.inserisciAlbero(5, 10, "Quercia", "Verde", "Ruvida"); // condiviso
        foresta.inserisciAlbero(3, 12, "Acero", "Rosso", "Liscia");

        foresta.disegna();
    }
}
