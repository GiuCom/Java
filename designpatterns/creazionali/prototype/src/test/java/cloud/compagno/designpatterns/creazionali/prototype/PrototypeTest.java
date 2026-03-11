package cloud.compagno.designpatterns.creazionali.prototype;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTest {
    // --- TEST VERSIONE STANDARD (Clonazione Diretta) ---

    @Test
    @DisplayName("Test Prototype Standard: Il clone deve essere un oggetto distinto con stessi dati")
    void testStandardPrototype() {
        Cerchio cerchio = new Cerchio();
        cerchio.setId("10");

        Cerchio clonedCerchio = (Cerchio) cerchio.clone();

        // Verifica che NON siano lo stesso oggetto in memoria (Riferimento diverso)
        assertNotSame(cerchio, clonedCerchio, "L'originalee e il clone non devono condividere la stessa istanza");

        // Verifica che i dati siano stati copiati correttamente
        assertEquals(cerchio.getId(), clonedCerchio.getId(), "L'ID deve essere identico nel clone");
        assertEquals(cerchio.getNomeFigura(), clonedCerchio.getNomeFigura(), "Il tipo deve essere identico nel clone");
    }

    // --- TEST VERSIONE REGISTRY (FiguraCache) ---

    @BeforeAll
    static void setupRegistry() {
        // Carichiamo i prototipi master una sola volta per tutti i test del registry
        FiguraCache.loadCache();
    }

    @Test
    @DisplayName("Test Registry: Recupero di un clone dalla Cache")
    void testRegistryGetClone() {
        // Recuperiamo il prototipo con ID "1" (che è un Cerchio)
        Figura figura1 = FiguraCache.getFigura("1");
        Figura figura2 = FiguraCache.getFigura("1");

        assertNotNull(figura1, "Il registry dovrebbe restituire un oggetto");
        assertEquals("Cerchio", figura1.getNomeFigura());

        // Fondamentale: Ogni chiamata a getFigura deve restituire un NUOVO clone
        assertNotSame(figura1, figura2, "Ogni richiesta al registry deve produrre un'istanza di clone differente");
    }

    @Test
    @DisplayName("Test Registry: Modifica del clone non deve impattare i futuri cloni della cache")
    void testRegistryIndependence() {
        // 1. Prendo un clone e cambio il suo ID
        Figura primoClone = FiguraCache.getFigura("2"); // Rectangle
        primoClone.setId("ID-MODIFICATO");

        // 2. Chiedo un nuovo clone dello stesso prototipo ("2")
        Figura secondoClone = FiguraCache.getFigura("2");

        // 3. Verifico che il secondoo clone abbia ancora l'ID originalee ("2") e non quello modificato ("ID-MODIFICATO")
        assertNotEquals(primoClone.getId(), secondoClone.getId(), "La modifica di un clone non deve corrompere il prototipo nel Registry");
        assertEquals("2", secondoClone.getId(), "Il nuovo clone dal registry deve avere lo stato originalee");
    }

    // --- TEST VERSIONE STANDARD (Deep Copy) ---

    @Test
    @DisplayName("Verifica che la Deep Copy crei istanze separate per gli oggetti annidati")
    void testDeepCopyIdentity() {
        // 1. Setup: Creiamo un cerchio con una posizione specifica
        Cerchio originale = new Cerchio();
        originale.setId("ORIGINALE_1");
        originale.setCoordinate(10, 20);

        // 2. Esecuzione: Cloniamo l'oggetto
        Cerchio cloned = (Cerchio) originale.clone();

        // 3. Verifica Identità (I riferimenti devono essere diversi)
        assertNotSame(originale, cloned, "Il clonato e l'originale devono essere oggetti diversi");

        assertNotSame(originale.getCoordinate(), cloned.getCoordinate(),
                "ERRORE SHALLOW COPY: L'oggetto Position è condiviso tra originale e clonato!");
    }

    @Test
    @DisplayName("Verifica che la modifica del clonato non influenzi l'originale (Isolamento)")
    void testDeepCopyIsolation() {
        // 1. Setup
        Cerchio originale = new Cerchio();
        originale.setCoordinate(100, 100);

        // 2. Clonazione
        Cerchio cloned = (Cerchio) originale.clone();

        // 3. Modifica dello stato interno del CLONE
        // Accediamo all'oggetto Position del clonato e cambiamo i suoi campi
        cloned.getCoordinate().x = 999;
        cloned.getCoordinate().y = 999;

        // 4. Verifica Isolamento
        // L'originale DEVE mantenere i valori 100, 100
        assertEquals(100, originale.getCoordinate().x, "L'originale è stato corrotto dalla modifica al clonato!");
        assertEquals(100, originale.getCoordinate().y, "L'originale è stato corrotto dalla modifica al clonato!");

        // Il clone deve avere i nuovi valori
        assertEquals(999, cloned.getCoordinate().x);
        assertEquals(999, cloned.getCoordinate().y);
    }

    @Test
    @DisplayName("Verifica gestione Null nella Deep Copy")
    void testDeepCopyNoPosition() {
        Cerchio originale = new Cerchio();
        originale.setCoordinate(0, 0);
        originale.coordinate = null; // Simuliamo un oggetto senza posizione

        // La clonazione non deve lanciare NullPointerException
        assertDoesNotThrow(() -> {
            Cerchio clonato = (Cerchio) originale.clone();
            assertNull(clonato.getCoordinate());
        }, "Il metodo clone() deve gestire i campi nulli senza eccezioni");
    }
}
