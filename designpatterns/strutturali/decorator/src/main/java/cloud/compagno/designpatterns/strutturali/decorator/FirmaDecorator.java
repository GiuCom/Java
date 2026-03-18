package cloud.compagno.designpatterns.strutturali.decorator;

/**
 * Decoratore concreto che aggiunge una firma finale al messaggio.
 */
public class FirmaDecorator extends MessaggioDecorator {
    private final String firma;

    public FirmaDecorator(Messaggio messaggioDecorato, String firma) {
        super(messaggioDecorato);
        this.firma = firma;
    }

    @Override
    public String getContenuto() {
        return messaggioDecorato.getContenuto() + "\n-- " + firma;
    }
}
