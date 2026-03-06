package cloud.compagno.designpatterns.crazionali.singleton.esempio;

public class SingletonMain {
     static void main() {

        System.out.println("--- Test del pattern SingletonDCL ---");

        // ❌ TENTATIVO ERRATO:
        // Se decommenti la riga seguente, otterrai un errore di compilazione
        // perché il costruttore è privato.
        // DatabaseConnection dbError = new DatabaseConnection();

        // ✅ MODO CORRETTO:
        // Richiediamo l'istanza per la prima volta. Verrà creata.
        DatabaseConnection connessione1 = DatabaseConnection.getInstance();
        connessione1.executeQuery("SELECT * FROM utenti");

        System.out.println("---------------------------------");

        // Richiediamo l'istanza per la seconda volta.
        // NON verrà creata una nuova istanza, verrà restituita quella già esistente.
        DatabaseConnection connessione2 = DatabaseConnection.getInstance();
        connessione2.executeQuery("SELECT * FROM prodotti");

        System.out.println("---------------------------------");

        // Verifichiamo che le due variabili puntino esattamente alla stessa area di memoria
        if (connessione1 == connessione2) {
            System.out.println("Successo! connessione1 e connessione2 sono la stessa identica istanza.");
        } else {
            System.out.println("Errore: sono state create più istanze.");
        }

        System.out.println();

        System.out.println("--- Test Singleton Enum ---");

        // Accesso diretto tramite la costante INSTANCE
        DatabaseConnectionEnum db1 = DatabaseConnectionEnum.INSTANCE;
        db1.executeQuery("SELECT * FROM utenti");

        // Secondo accesso: noterai che il costruttore NON viene richiamato
        DatabaseConnectionEnum db2 = DatabaseConnectionEnum.INSTANCE;
        db2.executeQuery("UPDATE ordini SET stato = 'SPEDITO' WHERE id = 10");

        // Verifica identità
        if (db1 == db2) {
            System.out.println("\n[Successo] db1 e db2 puntano alla stessa istanza Enum.");
        }
    }
}
