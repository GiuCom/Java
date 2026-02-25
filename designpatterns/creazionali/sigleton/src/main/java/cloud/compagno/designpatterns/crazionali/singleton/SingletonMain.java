package cloud.compagno.designpatterns.crazionali.singleton;

public class SingletonMain {

    static void main() {
        System.out.println("--- Inizio Programma ---");

        // Prima chiamata: scatena l'inizializzazione del Singleton
        System.out.println("Richiedo la prima istanza...");
        SingletonBillPugh config1 = SingletonBillPugh.getInstance();
        System.out.println("Stringa di connessione: " + config1.getConnectionString());

        // Seconda chiamata: non vedrai il messaggio di inizializzazione
        System.out.println("\nRichiedo la seconda istanza...");
        SingletonBillPugh config2 = SingletonBillPugh.getInstance();

        // Verifica finale via console
        if (config1 == config2) {
            System.out.println("SUCCESSO: Entrambe le variabili puntano alla stessa istanza (HashCode: " + config1.hashCode() + ")");
        } else {
            System.out.println("ERRORE: Le istanze sono diverse!");
        }

        System.out.println("--- Fine Programma ---");
    }
}
