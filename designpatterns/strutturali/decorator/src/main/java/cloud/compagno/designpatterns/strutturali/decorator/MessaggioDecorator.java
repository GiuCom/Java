package cloud.compagno.designpatterns.strutturali.decorator;

/**
 * Decoratore astratto: incapsula un oggetto Messaggio
 * e consente ai decoratori concreti di delegare e arricchire il comportamento.
 */
public abstract class MessaggioDecorator implements Messaggio {
    protected final Messaggio messaggioDecorato;

    protected MessaggioDecorator(Messaggio messaggioDecorato) {
        this.messaggioDecorato = messaggioDecorato;
    }
}
