package cloud.compagno.designpatterns.strutturali.bridge;

public class Automobile extends Veicolo {
    public Automobile(Officina off1, Officina off2) {
        super(off1, off2);
    }

    @Override
    public void produci() {
        System.out.print("Automobile:");
        officina1.lavora();
        officina2.lavora();
    }
}
