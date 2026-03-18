package cloud.compagno.designpatterns.strutturali.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test JUnit 5 del pattern Composite.
 */
public class CompositeTest {

    @Test
    @DisplayName("Una cartella calcola ricorsivamente la somma delle dimensioni dei figli")
    void deveCalcolareLaDimensioneTotaleRicorsivamente() {
        CartellaDocumento radice = new CartellaDocumento("Radice");
        CartellaDocumento sottoCartella = new CartellaDocumento("SottoCartella");
        FileDocumento file1 = new FileDocumento("a.txt", 10);
        FileDocumento file2 = new FileDocumento("b.txt", 20);
        FileDocumento file3 = new FileDocumento("c.txt", 30);

        sottoCartella.aggiungi(file2);
        sottoCartella.aggiungi(file3);
        radice.aggiungi(file1);
        radice.aggiungi(sottoCartella);

        assertEquals(60, radice.getDimensioneInKB(),
                "La dimensione totale deve essere la somma del file foglia e della sottocartella");
    }

    @Test
    @DisplayName("Una foglia non può ricevere figli")
    void unaFogliaNonPuoRicevereFigli() {
        FileDocumento file = new FileDocumento("solitario.txt", 5);
        FileDocumento altro = new FileDocumento("altro.txt", 3);

        assertThrows(UnsupportedOperationException.class,
                () -> file.aggiungi(altro),
                "Una foglia deve rifiutare l'operazione di aggiunta");
    }

    @Test
    @DisplayName("La rappresentazione testuale mantiene la gerarchia e l'indentazione")
    void deveProdurreUnaDescrizioneGerarchica() {
        CartellaDocumento radice = new CartellaDocumento("Radice");
        CartellaDocumento immagini = new CartellaDocumento("Immagini");
        FileDocumento logo = new FileDocumento("logo.png", 12);

        immagini.aggiungi(logo);
        radice.aggiungi(immagini);

        String atteso = String.join(System.lineSeparator(),
                "+ Cartella: Radice (12 KB)",
                "  + Cartella: Immagini (12 KB)",
                "    - File: logo.png (12 KB)");

        assertEquals(atteso, radice.descrivi(""));
    }
}