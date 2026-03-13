package cloud.compagno.designpatterns.creazionali.factorymethod;

// Concrete Product A
public class Camion implements Trasporto {
    @Override
    public String consegna() {
        return "Consegna via terra in un box di cartone.";
    }
}
