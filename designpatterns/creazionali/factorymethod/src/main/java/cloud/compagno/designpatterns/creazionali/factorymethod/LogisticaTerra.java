package cloud.compagno.designpatterns.creazionali.factorymethod;

// Concrete Creator A
public class LogisticaTerra extends Logistica {
    @Override
    public Trasporto creaTrasporto() {
        return new Camion();
    }
}