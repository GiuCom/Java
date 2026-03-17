package cloud.compagno.designpatterns.strutturali.bridge;

public abstract class Veicolo {
    // Il "Ponte": il veicolo non sa come viene lavorato, delega all'officina
    protected Officina officina1;
    protected Officina officina2;

    protected Veicolo(Officina off1, Officina off2) {
        this.officina1 = off1;
        this.officina2 = off2;
    }

    abstract public void produci();
}
