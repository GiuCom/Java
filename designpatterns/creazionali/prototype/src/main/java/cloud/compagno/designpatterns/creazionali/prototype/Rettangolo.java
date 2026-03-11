package cloud.compagno.designpatterns.creazionali.prototype;

// 2. Concrete Prototype
public class Rettangolo extends Figura {
    public Rettangolo() {
        nomeFigura = "Rettangolo";
    }

    @Override
    public void disegna() {
        System.out.println("Disegno un Rettangolo.");
    }
}