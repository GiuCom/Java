package cloud.compagno.designpatterns.strutturali.bridge;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {

    @Test
    void testProduzioneAutomobile() {
        // Prepariamo la cattura dell'output per il test
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Creiamo un'automobile con due officine specifiche
        Veicolo auto = new Automobile(new Assemblaggio(), new Verniciatura());
        auto.produci();

        // Verifichiamo che il "ponte" abbia collegato correttamente le classi
        assertEquals("Automobile: (assemblato) (verniciato)", outContent.toString());
    }

    @Test
    void testProduzioneMoto() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Creiamo una moto con le stesse officine
        Veicolo moto = new Moto(new Assemblaggio(), new Verniciatura());
        moto.produci();

        assertEquals("Moto: (assemblato) (verniciato)", outContent.toString());
    }
}