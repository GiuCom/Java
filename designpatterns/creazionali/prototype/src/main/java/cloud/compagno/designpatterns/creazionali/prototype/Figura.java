package cloud.compagno.designpatterns.creazionali.prototype;

// 1. Prototype Interface
public abstract class Figura implements Cloneable{
    private String id;
    protected String nomeFigura;
    protected Coordinate coordinate; // Oggetto annidato

    abstract void disegna();

    public String getNomeFigura() { return nomeFigura; }

    public void setCoordinate(int x, int y) { this.coordinate = new Coordinate(x, y); }
    public Coordinate getCoordinate() { return coordinate; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public Object clone() {
        try {
            Figura clonato = (Figura) super.clone(); // Shallow copy iniziale

            // DEEP COPY: cloniamo esplicitamente l'oggetto annidato
            if (this.coordinate != null) {
                clonato.coordinate = (Coordinate) this.coordinate.clone();
            }
            return clonato;
        }  catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
