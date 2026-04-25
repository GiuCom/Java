package cloud.compagno.designpatterns.comportamentali.command;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Pattern Command - Sistema Domotico")
public class CommandTest {
    private Condizionatore receiver;
    private Telecomando invoker;

    @BeforeEach
    void setUp() {
        receiver = new Condizionatore();
        invoker = new Telecomando();
    }

    @Test
    @DisplayName("Esecuzione comando temperatura")
    void testEsecuzioneComando() {
        int tempIniziale = receiver.getTemperatura();
        Comando imposta30 = new ComandoTemperatura(receiver, 30, tempIniziale);

        invoker.inviaPressione(imposta30);

        assertEquals(30, receiver.getTemperatura(), "La temperatura dovrebbe essere 30");
    }

    @Test
    @DisplayName("Annullamento (Undo) del comando")
    void testUndoComando() {
        int tempIniziale = receiver.getTemperatura(); // 22
        Comando imposta18 = new ComandoTemperatura(receiver, 18, tempIniziale);

        invoker.inviaPressione(imposta18);
        invoker.premiAnnulla();

        assertEquals(22, receiver.getTemperatura(), "Il sistema dovrebbe tornare a 22°C");
    }

    @Test
    @DisplayName("Test pressione tasto vuoto")
    void testPressioneTastoVuoto() {
        // Arrange: lo stato è già inizializzato con cronologia vuota nel setUp()

        // Act & Assert: verifichiamo che non venga lanciata alcuna eccezione
        // In JUnit 6 assertDoesNotThrow assicura che il codice sia robusto
        assertDoesNotThrow(() -> invoker.premiAnnulla(),
                "Il sistema non deve crashare se la cronologia è vuota");

        // Verifichiamo che la temperatura sia rimasta quella di default (22)
        assertEquals(22, receiver.getTemperatura(),
                "La temperatura non dovrebbe cambiare");
    }
}
