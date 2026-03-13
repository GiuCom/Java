package cloud.compagno.designpatterns.creazionali.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryMethodTest {
    @Test
    void testLogisticaTerra() {
        // PASSAGGIO 1: Istanzio la factory specifica per la terra
        Logistica logistica = new LogisticaTerra();

        // PASSAGGIO 2: Eseguo il metodo che internamente usa il Factory Method
        String risultato = logistica.pianificaConsegna();

        // PASSAGGIO 3: Verifico che il prodotto creato sia un Camion tramite il messaggio
        assertTrue(risultato.contains("via terra"));
    }

    @Test
    void testLogisticaMare() {
        Logistica logistica = new LogisticaMare();
        String risultato = logistica.pianificaConsegna();

        // Verifica che il Factory Method abbia istanziato una Nave
        assertTrue(risultato.contains("via mare"));
    }
}
