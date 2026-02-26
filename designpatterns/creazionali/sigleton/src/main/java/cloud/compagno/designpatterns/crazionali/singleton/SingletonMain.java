package cloud.compagno.designpatterns.crazionali.singleton;

public class SingletonMain {

    static void main() {

        System.out.println("--- Inizio Programma ---");

        // Prima chiamata: scatena l'inizializzazione del Singleton
        System.out.println("Richiedo la prima istanza...");
        Singleton singleton1 = Singleton.getInstance();
        System.out.println("Singleton istanza n° 1.....(HashCode: " + singleton1.hashCode() + ")");
        System.out.println("Stringa di connessione: " + singleton1.getStringaConnection());

        // Seconda chiamata: non vedrai il messaggio di inizializzazione
        System.out.println("\nRichiedo la seconda istanza...");
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("Singleton istanza n° 2.....(HashCode: " + singleton2.hashCode() + ")");
        System.out.println("Stringa di connessione: " + singleton2.getStringaConnection());

        // Verifica finale via console
        System.out.println("\nVerifica se l'istanza è lo stessa...");
        if (singleton1 == singleton2) {
            System.out.println("SUCCESSO: Entrambe le variabili puntano alla stessa istanza (HashCode: " + singleton1.hashCode() + ")");
        } else {
            System.out.println("ERRORE: Le istanze sono diverse!");
        }


        // Prima chiamata: scatena l'inizializzazione del Singleton
        System.out.println("\nRichiedo la prima istanza...");
        SingletonBillPugh singletonBillPugh1 = SingletonBillPugh.getInstance();
        System.out.println("SingletonBillPugh istanza n° 1.....(HashCode: " + singletonBillPugh1.hashCode() + ")");
        System.out.println("Stringa di connessione: " + singletonBillPugh1.getStringaConnection());

        // Seconda chiamata: non vedrai il messaggio di inizializzazione
        System.out.println("\nRichiedo la seconda istanza...");
        SingletonBillPugh singletonBillPugh2 = SingletonBillPugh.getInstance();
        System.out.println("SingletonBillPugh istanza n° 2.....(HashCode: " + singletonBillPugh2.hashCode() + ")");
        System.out.println("Stringa di connessione: " + singletonBillPugh2.getStringaConnection());

        // Verifica finale via console
        System.out.println("\nVerifica se l'istanza è lo stessa...");
        if (singletonBillPugh1 == singletonBillPugh2) {
            System.out.println("SUCCESSO: Entrambe le variabili puntano alla stessa istanza (HashCode: " + singletonBillPugh1.hashCode() + ")");
        } else {
            System.out.println("ERRORE: Le istanze sono diverse!");
        }

        System.out.println("--- Fine Programma ---");
    }
}
