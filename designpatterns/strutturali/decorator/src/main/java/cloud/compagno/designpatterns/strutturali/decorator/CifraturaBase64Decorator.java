package cloud.compagno.designpatterns.strutturali.decorator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Decoratore concreto che codifica il contenuto in Base64.
 */
public class CifraturaBase64Decorator extends MessaggioDecorator {

    public CifraturaBase64Decorator(Messaggio messaggioDecorato) {
        super(messaggioDecorato);
    }

    @Override
    public String getContenuto() {
        String testoOriginale = messaggioDecorato.getContenuto();
        return Base64.getEncoder().encodeToString(testoOriginale.getBytes(StandardCharsets.UTF_8));
    }
}
