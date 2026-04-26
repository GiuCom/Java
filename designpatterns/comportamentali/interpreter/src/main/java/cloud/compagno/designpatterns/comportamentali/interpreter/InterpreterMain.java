package cloud.compagno.designpatterns.comportamentali.interpreter;

public class InterpreterMain {
    static void main() {
        // 1. Definizione del Contesto
        // Carichiamo i valori per le variabili 'x' e 'y'
        Contesto contesto = new Contesto();
        contesto.assegna("x", 5);
        contesto.assegna("y", 20);

        System.out.println("--- Interprete Grammaticale Moderno ---");
        System.out.println("Variabili definite: x=5, y=20");

        // 2. Costruzione dell'Albero Sintattico (AST)
        // Rappresenta l'espressione: y + (x + 10)

        // Sotto-albero: (x + 10)
        Espressione sottoEspressione = new Somma(
                new Variabile("x"),
                new Numero(10)
        );

        // Radice dell'albero: y + (sotto-albero)
        Espressione espressioneFinale = new Somma(
                new Variabile("y"),
                sottoEspressione
        );

        // 3. Esecuzione dell'Interpretazione
        // Il metodo interpreta attraversa l'albero ricorsivamente
        int risultato = espressioneFinale.interpreta(contesto);

        // 4. Output dei risultati
        System.out.println("\nCalcolo dell'espressione: y + (x + 10)");
        System.out.println("Risultato finale: " + risultato);

        // 5. Cambio dinamico del contesto
        System.out.println("\n--- Cambio valore di x a 10 ---");
        contesto.assegna("x", 10);
        risultato = espressioneFinale.interpreta(contesto);
        System.out.println("Nuovo risultato: " + risultato);
    }
}
