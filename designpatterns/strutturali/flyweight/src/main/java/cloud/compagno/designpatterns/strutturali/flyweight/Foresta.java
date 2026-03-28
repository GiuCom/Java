package cloud.compagno.designpatterns.strutturali.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Foresta {
    private final FlyweightFactory factory;
    private final List<Albero> alberi = new ArrayList<>();

    public Foresta(FlyweightFactory factory) {
        this.factory = factory;
    }

    public void inserisciAlbero(int x, int y, String nome, String colore, String texture) {
        AlberoDefinizione tipoDiAlbero = factory.getAlberoDefinizione(nome, colore, texture);
        alberi.add(new Albero(x, y, tipoDiAlbero));
    }

    public void disegna() {
        for (Albero a : alberi) {
            a.disegna();
        }
    }

    public List<Albero> getAlberi() {
        return alberi;
    }
}
