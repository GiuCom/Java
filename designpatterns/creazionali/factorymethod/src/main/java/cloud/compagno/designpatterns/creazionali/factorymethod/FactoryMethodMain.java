package cloud.compagno.designpatterns.creazionali.factorymethod;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FactoryMethodMain {
    static void main() {
        System.out.println("--- Test Sistema Logistica ---");

        // 1. Vogliamo gestire una consegna via TERRA
        // Creiamo la factory specifica per la terra
        Logistica logisticaTerra = new LogisticaTerra();
        // Avviamo la pianificazione: internamente verrà creato un Camion
        System.out.println("Richiesta 1: " + logisticaTerra.pianificaConsegna());

        System.out.println("-------------------------------");

        // 2. Vogliamo gestire una consegna via MARE
        // Creiamo la factory specifica per il mare
        Logistica logisticaMare = new LogisticaMare();
        // Avviamo la pianificazione: internamente verrà creata una Nave
        System.out.println("Richiesta 2: " + logisticaMare.pianificaConsegna());

        System.out.println("-------------------------------");

        // 3. Esempio di Polimorfismo: il client non sa quale factory usa
        inviaPacco(new LogisticaTerra());
        inviaPacco(new LogisticaMare());
    }

    /**
     * Metodo helper che accetta la classe astratta Logistica.
     * Dimostra che il codice client è totalmente slegato dalle classi concrete.
     */
    public static void inviaPacco(Logistica logistica) {
        System.out.println("Esecuzione generica: " + logistica.pianificaConsegna());
    }
}
