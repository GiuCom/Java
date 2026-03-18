package cloud.compagno.designpatterns.strutturali.decorator;

/**
 * Classe dimostrativa che mostra la composizione dei decoratori.
 */
public class DecoratorMain {
    static void main() {
        Messaggio messaggio = new CifraturaBase64Decorator(
                new FirmaDecorator(
                        new PrioritaAltaDecorator(
                                new MessaggioSemplice("Intervento completato")
                        ),
                        "Giuseppe Compagno"
                )
        );

        System.out.println(messaggio.getContenuto());
    }
}
