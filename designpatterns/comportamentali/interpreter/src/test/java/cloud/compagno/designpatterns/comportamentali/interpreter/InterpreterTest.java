package cloud.compagno.designpatterns.comportamentali.interpreter;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Pattern Interpreter - Calcolatrice Grammaticale")
public class InterpreterTest {
    @Test
    @DisplayName("Interpretazione somma con variabile")
    void testSomma() {
        Contesto contesto = new Contesto();
        contesto.assegna("x", 5);

        // Costruzione AST: x + 10
        Espressione espressione = new Somma(new Variabile("x"), new Numero(10));

        int risultato = espressione.interpreta(contesto);

        assertEquals(15, risultato, "5 + 10 dovrebbe fare 15");
    }

    @Test
    @DisplayName("Test variabile inesistente (valore default)")
    void testVariabileVuota() {
        Contesto contesto = new Contesto(); // x non definita
        Espressione v = new Variabile("x");

        assertEquals(0, v.interpreta(contesto), "Una variabile non definita deve restituire 0");
    }
}
