package cloud.compagno.designpatterns.creazionali.builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    private ComputerDirector ingegnere;

    // -------------------------------
    // Versione base
    // -------------------------------

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

    // -------------------------------
    // Versione con InnerStaticBuilder
    // -------------------------------

    @Test
    public void testGamingComputerBuilder() {
        ComputerInnerStaticBuilder gamingPc = new ComputerInnerStaticBuilder.Builder()
                .cpu("Intel i9")
                .ram("32GB DDR5")
                .gpu("NVIDIA RTX 4090")
                .build();

        assertNotNull(gamingPc, "L'oggetto Computer non dovrebbe essere nullo");
        assertEquals("Intel i9", gamingPc.getCpu());
        assertEquals("32GB DDR5", gamingPc.getRam());
        assertEquals("NVIDIA RTX 4090", gamingPc.getGpu());
    }

    @Test
    public void testOfficeComputerBuilder() {
        ComputerInnerStaticBuilder officePc = new ComputerInnerStaticBuilder.Builder()
                .cpu("Intel i5")
                .ram("16GB DDR5")
                .gpu("NVIDIA GeForce GT 1030")
                .build();

        assertNotNull(officePc);
        assertEquals("Intel i5", officePc.getCpu());
        assertEquals("16GB DDR5", officePc.getRam());
        assertEquals("NVIDIA GeForce GT 1030", officePc.getGpu());
    }

    @Test
    public void testPartialComputerBuilder() {
        // Test per dimostrare la flessibilità nell'omettere parametri
        ComputerInnerStaticBuilder customPc = new ComputerInnerStaticBuilder.Builder()
                .cpu("AMD Ryzen 7")
                .build();

        assertNotNull(customPc);
        assertEquals("AMD Ryzen 7", customPc.getCpu());
        assertNull(customPc.getRam(), "La RAM non è stata impostata, dovrebbe essere null");
        assertNull(customPc.getGpu(), "La GPU non è stata impostata, dovrebbe essere null");
    }
}
