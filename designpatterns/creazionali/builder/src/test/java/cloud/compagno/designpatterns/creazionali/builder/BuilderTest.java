package cloud.compagno.designpatterns.creazionali.builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    private ComputerDirector ingegnere;

    @BeforeEach
    void setUp() {
        // Arrange: Inizializziamo il Director prima di ogni test
        ingegnere = new ComputerDirector();
    }

    @Test
    void testCostruzioneGamingPC() {
        // Arrange: Scegliamo il builder specifico
        ComputerBuilder gamingBuilder = new ComputerGamingBuilder();
        ingegnere.setBuilder(gamingBuilder);

        // Act: Eseguiamo l'assemblaggio
        ingegnere.assembla();
        Computer pcRisultante = gamingBuilder.getComputer();

        // Assert: Verifichiamo che i componenti siano quelli del GamingPCBuilder
        assertNotNull(pcRisultante, "Il computer non dovrebbe essere null");
        assertEquals("Intel i9", pcRisultante.getCpu(), "La CPU dovrebbe essere Intel i9");
        assertEquals("32GB DDR5", pcRisultante.getRam(), "La RAM dovrebbe essere 32GB DDR5");
        assertEquals("NVIDIA RTX 4090", pcRisultante.getGpu(), "La GPU dovrebbe essere RTX 4040");
    }

    @Test
    void testCambioBuilderInCorsa() {
        // Verifichiamo che l'ingegnere possa cambiare configurazione facilmente
        ComputerBuilder officeBuilder = new ComputerOfficeBuilder(); // Supponendo esista
        ingegnere.setBuilder(officeBuilder);
        ingegnere.assembla();

        Computer pcOffice = officeBuilder.getComputer();
        assertNotNull(pcOffice.getCpu());
    }
}
