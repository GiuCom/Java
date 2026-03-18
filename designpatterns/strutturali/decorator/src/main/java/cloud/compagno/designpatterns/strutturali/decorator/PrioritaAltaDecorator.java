package cloud.compagno.designpatterns.strutturali.decorator;

/**
 * Decoratore concreto che aggiunge una marcatura di alta priorità.
 */
public class PrioritaAltaDecorator extends MessaggioDecorator {

    public PrioritaAltaDecorator(Messaggio messaggioDecorato) {
        super(messaggioDecorato);
    }

    @Override
    public String getContenuto() {
        return "[ALTA PRIORITÀ] " + messaggioDecorato.getContenuto();
    }
}
