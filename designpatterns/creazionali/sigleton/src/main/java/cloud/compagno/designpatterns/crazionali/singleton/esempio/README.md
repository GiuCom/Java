## [Design Patterns](../../../../../../../../../../..)
### [Creazionali](../../../../../../../../../..)
# [Singleton](../../../../../../../../..)

----

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br>
<br>

# ESEMPIO

-----

Il design pattern **Singleton** è un pattern creazionale che ha un obiettivo molto preciso: garantire che di una determinata classe venga creata una e una sola istanza all'interno di tutta l'applicazione, fornendo un punto di accesso globale ad essa.

Ecco un esempio in Java che utilizza un approccio moderno e sicuro per i thread, SingletonDCL (Double-Checked Locking), perfetto per dimostrarne tutte le caratteristiche.

La classe SingletonDCL **DatabaseConnection**:

```java
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
```
Le caratteristiche chiave di questa classe sono:

- **Costruttore private:** L'unico modo per ottenere un oggetto **DatabaseConnection** è passare tramite il metodo `getInstance()`. Nessuno può utilizzare il comando `new DatabaseConnection()`.
- **Lazy Initialization (Inizializzazione ritardata):** L'oggetto viene creato solo nel momento in cui viene effettivamente richiesto per la prima volta. Se il metodo `getInstance()` non viene mai chiamato, l'oggetto non occuperà mai memoria.
- **Thread-Safety (Sicurezza multi-thread):** L'uso di `volatile` e del blocco `synchronized` garantisce che, anche se decine di thread provassero a richiedere l'istanza esattamente nello stesso millisecondo, ne verrebbe creata rigorosamente soltanto una.

La classe SingletonMain

```java
public class SingletonMain {
    static void main() {

        System.out.println("--- Test del pattern Singleton ---");

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
    }
}
```

Svolge il ruolo di client o "banco di prova". Il suo scopo non è implementare la logica del Singleton, ma dimostrare concretamente che il pattern funziona esattamente come previsto.

All'inizio del metodo `main`, troviamo una riga commentata:

```java
// DatabaseConnection dbError = new DatabaseConnection();
```

Questa è la prima prova del funzionamento del pattern **Singleton**. Se si provasse a togliere il commento, il compilatore Java bloccherebbe l'esecuzione restituendo un errore (solitamente **'DatabaseConnection() has private access'**). Questo dimostra che nessuno dall'esterno può forzare la creazione di una nuova istanza bypassando le regole che abbiamo stabilito.

Proseguendo nel codice del metodo `main`, vediamo i comandi

```
DatabaseConnection connessione1 = DatabaseConnection.getInstance();
connessione1.executeQuery("SELECT * FROM utenti");
```

Il client richiede la connessione per la prima volta. Dietro le quinte, la classe **DatabaseConnection** si accorge che l'istanza interna è ancora `null`. Pertanto, invoca il suo costruttore privato, stampa a video "**Inizializzazione della connessione...**", crea l'oggetto e lo salva in memoria, per poi restituirlo alla variabile `connessione1`.

```
DatabaseConnection connessione2 = DatabaseConnection.getInstance();
connessione2.executeQuery("SELECT * FROM prodotti");
```

Poco dopo, il client ha bisogno di fare un'altra operazione sul database e richiede nuovamente una connessione assegnandola alla variabile `connessione2`. Questa volta, il metodo `getInstance()` vedrà che l'istanza esiste già. Non eseguirà alcuna nuova inizializzazione, ma si limiterà a restituire l'oggetto precedentemente creato.

```
if (connessione1 == connessione2) {
        System.out.println("Successo! connessione1 e connessione2 sono la stessa identica istanza.");
}
```

Qui si completa il test. In Java, l'operatore **==** applicato agli oggetti non confronta il loro contenuto, ma confronta gli indirizzi di memoria.
Verificare che `connessione1 == connessione2` sia `true` ci dà la certezza matematica che entrambe le variabili stanno "puntando" esattamente allo stesso e unico frammento di memoria fisica in cui risiede l'oggetto **DatabaseConnection**. Non abbiamo due oggetti identici, abbiamo letteralmente lo stesso identico oggetto.

----

## Test

In questo test verificheremo tre aspetti fondamentali:

1. L'identità delle istanze (devono essere uguali).
2. Il comportamento in un ambiente multi-thread (nessuna "race condition").
3. La coerenza dello stato interno.


```java
class DatabaseConnectionTest {

    @Test
    @DisplayName("Verifica che più chiamate restituiscano la stessa istanza")
    void testSingletonInstanceIdentity() {
        // Richiediamo l'istanza due volte
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        // Verifichiamo che non siano nulli
        assertNotNull(instance1, "L'istanza 1 non dovrebbe essere null");
        assertNotNull(instance2, "L'istanza 2 non dovrebbe essere null");

        // assertSame controlla se i due riferimenti puntano allo STESSO oggetto (==)
        assertSame(instance1, instance2, "Le due istanze dovrebbero essere identiche (stesso riferimento)");
    }

    @Test
    @DisplayName("Verifica la robustezza del Singleton in un ambiente multi-thread")
    void testSingletonMultiThread() throws InterruptedException {
        // Creiamo due thread che cercano di ottenere l'istanza contemporaneamente
        final DatabaseConnection[] results = new DatabaseConnection[2];

        Thread t1 = new Thread(() -> results[0] = DatabaseConnection.getInstance());
        Thread t2 = new Thread(() -> results[1] = DatabaseConnection.getInstance());

        t1.start();
        t2.start();

        // Attendiamo che entrambi finiscano
        t1.join();
        t2.join();

        // Anche in condizioni di concorrenza, l'oggetto deve essere unico
        assertSame(results[0], results[1], "Thread diversi dovrebbero ricevere la stessa istanza");
    }
}
```

Abbiamo utilizzato:

- **assertNotNull:** Per verificare che l'oggetto venga effettivamente creato
- **assertSame(obj1, obj2):** Questa è l'asserzione chiave. A differenza di `assertEquals`, che usa il metodo `.equals()`, `assertSame` usa l'operatore **==**. Verifica quindi l'identità referenziale: "Sono lo stesso pezzo di memoria?".
- **@DisplayName:** Novità di JUnit 5 che rende i report del test molto più leggibili, spiegando a parole cosa stiamo testando.
- **Test Multi-thread:** È il test più critico per un pattern **Singleton**. Se il codice `getInstance()` non fosse sincronizzato correttamente, questo test potrebbe fallire (anche se raramente, a causa del tempismo dei thread), producendo due oggetti diversi.

------

Vediamo la versione SingletonEnum con la classe **DatabaseConnectionEnum**
L'implementazione tramite `Enum` è considerata il **"Gold Standard"** in Java perché risolve nativamente problemi complessi come la serializzazione e gli attacchi tramite **Reflection**, il tutto con pochissime righe di codice.

```java
public enum DatabaseConnectionEnum {
    // L'unica istanza del Singleton
    INSTANCE;

    // I campi della classe (stato interno)
    private String connectionUrl;

    // Il costruttore negli Enum è privato di default e viene eseguito
    // una sola volta al caricamento della classe.
    void DatabaseConnection() {
        this.connectionUrl = "jdbc:mysql://localhost:3306/my_db";
        System.out.println("Enum Singleton: Connessione inizializzata!");
    }

    // Metodo di utilità
    public void executeQuery(String query) {
        System.out.println("Eseguo su " + connectionUrl + ": " + query);
    }
}
```

Le sue caratteristiche:

- **Semplicità:** Non servono `getInstance()`, `synchronized` o `volatile`. Java garantisce che l'istanza `INSTANCE` sia creata in modo **thread-safe**.
- **Protezione dalla Reflection:** Con una classe normale, un utente esperto potrebbe usare la **Reflection** per rendere pubblico il costruttore privato e creare una seconda istanza. Con `Enum`, il linguaggio Java lo impedisce categoricamente a livello di runtime.
- **Serializzazione Automatica:** Se salvi l'oggetto su disco e lo ricarichi, un **Singleton** classico potrebbe creare un "duplicato". `Enum` garantisce che l'istanza rimanga sempre la stessa.

----

## Test
Il test diventa ancora più lineare, poiché non dobbiamo più preoccuparci della creazione manuale.

```java
public class DatabaseConnectionEnumTest {

    @Test
    void testEnumSingletonIdentity() {
        // Accediamo all'istanza direttamente tramite il nome della costante
        DatabaseConnectionEnum instance1 = DatabaseConnectionEnum.INSTANCE;
        DatabaseConnectionEnum instance2 = DatabaseConnectionEnum.INSTANCE;

        // Verifica identità referenziale
        assertSame(instance1, instance2, "L'Enum deve restituire sempre la stessa istanza");
    }

    @Test
    void testEnumBehavior() {
        // Possiamo chiamare i metodi normalmente
        DatabaseConnectionEnum.INSTANCE.executeQuery("SELECT * FROM ordini");
        assertNotNull(DatabaseConnectionEnum.INSTANCE);
    }

    @Test
    @DisplayName("Verifica che l'Enum Singleton sia Thread-Safe")
    void testSingletonMultithread() throws InterruptedException {
        int numeroThread = 50;
        ExecutorService service = Executors.newFixedThreadPool(numeroThread);

        // Usiamo un Set thread-safe per memorizzare le istanze ottenute dai vari thread
        Set<DatabaseConnectionEnum> istanzeOttenute = Collections.newSetFromMap(new ConcurrentHashMap<>());

        // Lanciamo 50 thread contemporaneamente
        for (int i = 0; i < numeroThread; i++) {
            service.execute(() -> {
                DatabaseConnectionEnum instance = DatabaseConnectionEnum.INSTANCE;
                istanzeOttenute.add(instance);
            });
        }

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);

        // Se il pattern funziona, il Set deve contenere esattamente 1 elemento
        assertEquals(1, istanzeOttenute.size(),
                "Il Set dovrebbe contenere solo una istanza, ma ne sono state trovate: " + istanzeOttenute.size());

        // Verifichiamo che l'elemento sia proprio la nostra istanza
        assertTrue(istanzeOttenute.contains(DatabaseConnectionEnum.INSTANCE));
    }
}
```

Anziché utilizzare il camando `DatabaseConnection.getInstance()`, scriviamo `DatabaseConnection.INSTANCE.executeQuery("...");`

Per il test multi-threading, negli approcci classici (non-Enum), se la sincronizzazione è errata, due thread potrebbero creare due istanze diverse. Con `Enum`, questo è gestito nativamente dalla JVM durante il caricamento della classe.

- **ExecutorService:** Simula un carico reale di lavoro dove 50 thread "attaccano" il **Singleton** nello stesso istante.
- **ConcurrentHashMap:** Usiamo una collezione sicura per i thread per evitare errori durante il test stesso.
- **L'Asserzione `assertEquals(1, size)`:** È il cuore del test. Se la JVM fallisse nel garantire l'unicità dell'`Enum` (cosa praticamente impossibile), il `Set` conterrebbe più di un oggetto e il test fallirebbe.