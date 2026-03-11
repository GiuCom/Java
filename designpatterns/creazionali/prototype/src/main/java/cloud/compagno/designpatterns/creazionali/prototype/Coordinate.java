package cloud.compagno.designpatterns.creazionali.prototype;

// Deve essere a sua volta Cloneable per facilitare la Deep Copy
public class Coordinate implements Cloneable {
    public int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
