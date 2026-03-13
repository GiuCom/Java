package cloud.compagno.designpatterns.creazionali.factorymethod;

// Concrete Product B
public class Nave implements Trasporto {
    @Override
    public String consegna() {
        return "Consegna via mare in un container.";
    }
}
