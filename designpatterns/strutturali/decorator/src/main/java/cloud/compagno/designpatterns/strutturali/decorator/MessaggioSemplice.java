package cloud.compagno.designpatterns.strutturali.decorator;

/**
 * ConcreteComponent: rappresenta il messaggio di base,
 * privo di responsabilità aggiuntive.
 */
public class MessaggioSemplice implements Messaggio {
    private final String contenuto;

    public MessaggioSemplice(String contenuto) {
        this.contenuto = contenuto;
    }

    @Override
    public String getContenuto() {
        return contenuto;
    }
}
