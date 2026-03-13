package cloud.compagno.designpatterns.creazionali.factorymethod;

// Concrete Creator B
public class LogisticaMare extends Logistica {
    @Override
    public Trasporto creaTrasporto() {
        return new Nave();
    }
}