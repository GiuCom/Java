package cloud.compagno.designpatterns.comportamentali.chainofresponsibility;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ChainOfResponsibilityTest {
    private SupportoBase livelloBase;
    private SupportoAvanzato livelloAvanzato;

    @BeforeEach
    void inizializzazione() {
        livelloBase = new SupportoBase();
        livelloAvanzato = new SupportoAvanzato();

        // Costruzione della catena: Base -> Avanzato
        livelloBase.setSuccessivo(livelloAvanzato);
    }

    @Test
    void testRichiestaPrioritaBassa() {
        RichiestaSupporto richiesta = new RichiestaSupporto("Cambio Password", 1);
        // Verifica che il supporto base gestisca senza errori
        assertDoesNotThrow(() -> livelloBase.gestisci(richiesta));
    }

    @Test
    void testRichiestaPrioritaAlta() {
        RichiestaSupporto richiesta = new RichiestaSupporto("Database Offline", 5);
        // Verifica il passaggio della richiesta lungo la catena
        assertDoesNotThrow(() -> livelloBase.gestisci(richiesta));
    }
}
