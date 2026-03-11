package cloud.compagno.designpatterns.creazionali.prototype;

// 2. Concrete Prototype
public class Cerchio extends Figura {
    public Cerchio() {
        nomeFigura = "Cerchio";
    }

    @Override
    public void disegna() {
        System.out.println("Disegno un Cerchio.");
    }
}

