package cloud.compagno.designpatterns.strutturali.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.jupiter.api.Test;

/**
 * Test JUnit 5 che verifica il comportamento del componente base
 * e della catena di decoratori.
 */
public class DecoratorTest {

    @Test
    void deveRestituireIlContenutoOriginaleSenzaDecorator() {
        // Arrange
        Messaggio messaggio = new MessaggioSemplice("Intervento completato");

        // Act
        String risultato = messaggio.getContenuto();

        // Assert
        assertEquals("Intervento completato", risultato);
    }

    @Test
    void deveAggiungerePrioritaEFirma() {
        // Arrange
        Messaggio messaggio = new FirmaDecorator(
                new PrioritaAltaDecorator(
                        new MessaggioSemplice("Intervento completato")
                ),
                "Giuseppe Compagno"
        );

        // Act
        String risultato = messaggio.getContenuto();

        // Assert
        assertEquals("[ALTA PRIORITÀ] Intervento completato\n-- Giuseppe Compagno", risultato);
    }

    @Test
    void deveApplicareLaCifraturaSulContenutoGiaDecorato() {
        // Arrange
        Messaggio messaggio = new CifraturaBase64Decorator(
                new FirmaDecorator(
                        new MessaggioSemplice("Ticket chiuso"),
                        "Help Desk"
                )
        );

        String atteso = Base64.getEncoder()
                .encodeToString("Ticket chiuso\n-- Help Desk".getBytes(StandardCharsets.UTF_8));

        // Act
        String risultato = messaggio.getContenuto();

        // Assert
        assertEquals(atteso, risultato);
    }
}