package cloud.compagno.designpatterns.creazionali.singleton.esempio;

public class DatabaseConnection {

    // 1. Variabile statica privata per memorizzare l'unica istanza.
    // La keyword 'volatile' assicura che le modifiche a questa variabile
    // siano immediatamente visibili a tutti i thread.
    private static volatile DatabaseConnection instance;

    // 2. Costruttore PRIVATO.
    // Questo è fondamentale: impedisce a qualsiasi altra classe di usare
    // l'operatore "new" per creare nuove istanze di questa classe.
    private DatabaseConnection() {
        System.out.println("Inizializzazione della connessione al database in corso...");
        // Qui andrebbe il codice reale per connettersi al DB
    }

    // 3. Metodo statico PUBBLICO per fornire l'accesso globale all'istanza.
    public static DatabaseConnection getInstance() {
        // Primo controllo (senza lock) per migliorare le prestazioni:
        // se l'istanza esiste già, saltiamo il blocco sincronizzato.
        if (instance == null) {

            // Sincronizziamo solo se l'istanza non esiste ancora,
            // per evitare che due thread la creino contemporaneamente.
            synchronized (DatabaseConnection.class) {

                // Secondo controllo (con lock): necessario nel caso in cui un altro thread
                // abbia creato l'istanza mentre questo thread aspettava il lock.
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Un metodo di esempio per simulare un'operazione dell'oggetto
    public void executeQuery(String query) {
        System.out.println("Esecuzione query: " + query);
    }
}
