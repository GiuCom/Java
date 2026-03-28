package cloud.compagno.designpatterns.strutturali.flyweight;

public class AlberoDefinizione implements Flyweight {
    private final String nome;
    private final String colore;
    private final String texture;

    public AlberoDefinizione(String nome, String colore, String texture) {
        this.nome = nome;
        this.colore = colore;
        this.texture = texture;
    }

    @Override
    public void disegna(int x, int y) {
        System.out.println("Disegno albero di tipo " + nome +
                " in posizione [" + x + ", " + y + "] colore=" + colore +
                " texture=" + texture);
    }

    public String getNome() {
        return nome;
    }

    public String getColore() {
        return colore;
    }

    public String getTexture() {
        return texture;
    }
}
