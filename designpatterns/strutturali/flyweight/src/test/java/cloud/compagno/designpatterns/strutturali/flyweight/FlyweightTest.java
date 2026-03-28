package cloud.compagno.designpatterns.strutturali.flyweight;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FlyweightTest {

    // ---------------------------------------
    // Test della classe FlyweightFactory.java
    // ---------------------------------------
    @Test
    void testCondivisioneTipiIntrinseci() {
        FlyweightFactory factory = new FlyweightFactory();
        Foresta foresta = new Foresta(factory);

        // Pianta alberi con tipi identici (stato intrinseco identico)
        foresta.inserisciAlbero(0, 0, "Quercia", "Verde", "Ruvida");
        foresta.inserisciAlbero(5, 10, "Quercia", "Verde", "Ruvida");
        // Pianta un albero con tipo differente
        foresta.inserisciAlbero(3, 12, "Acero", "Rosso", "Liscia");

        // Ci si aspetta due tipi intrinseci condivisi
        assertEquals(2, factory.getPoolSize(), "Il numero di TreeType creati nel pool dovrebbe essere 2");

        // Verifica che i primi due alberi condividano lo stesso TreeType
        Albero a1 = foresta.getAlberi().get(0);
        Albero a2 = foresta.getAlberi().get(1);
        assertSame(a1.tipoDiAlbero(), a2.tipoDiAlbero(), "I due alberi con lo stesso stato intrinseco dovrebbero condividere lo stesso TreeType");
    }

    // -----------------------------
    // Test della classe Albero.java
    // -----------------------------
    @Test
    void disegnoRiceveInformazioniIntrinseche() {
        AlberoDefinizione alberoDefinizione = new AlberoDefinizione("Quercia", "Verde", "Ruvida");
        Albero albero = new Albero(7, 9, alberoDefinizione);

        // Reindirizza l'output standard per catturare la stampa
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        albero.disegna();

        // Ripristina l'output originale
        System.setOut(originalOut);

        String printed = out.toString();
        assertTrue(printed.contains("Quercia"));
        assertTrue(printed.contains("Verde"));
        assertTrue(printed.contains("Ruvida"));
        // Controlla che la posizione sia presente
        assertTrue(printed.contains("[7, 9]"));
    }

    // ------------------------------
    // Test della classe Foresta.java
    // ------------------------------




}
