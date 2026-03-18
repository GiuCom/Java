package cloud.compagno.designpatterns.strutturali.bridge;

public class Moto extends Veicolo {
    public Moto(Officina off1, Officina off2) {
        super(off1, off2);
    }

    @Override
    public void produci() {
        System.out.print("Moto:");
        officina1.lavora();
        officina2.lavora();
    }
}
