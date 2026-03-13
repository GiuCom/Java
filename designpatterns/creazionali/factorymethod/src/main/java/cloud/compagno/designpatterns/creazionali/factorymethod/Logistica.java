package cloud.compagno.designpatterns.creazionali.factorymethod;

// Creator
public abstract class Logistica {
    // Il Factory Method
    public abstract Trasporto creaTrasporto();

    // Logica di business che usa il prodotto
    public String pianificaConsegna() {
        Trasporto t = creaTrasporto();
        return "Logistica: " + t.consegna();
    }
}