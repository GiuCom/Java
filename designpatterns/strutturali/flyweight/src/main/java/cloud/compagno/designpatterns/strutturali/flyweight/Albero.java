package cloud.compagno.designpatterns.strutturali.flyweight;

public record Albero(int x, int y, AlberoDefinizione tipoDiAlbero) {

    public void disegna() {
        tipoDiAlbero.disegna(x, y);
    }
}
