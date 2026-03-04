<h1 style="text-align: center;">Design Patterns</h1>
<h2 style="text-align: center;">Creazionali</h2>
<h1 style="text-align: center;">Singleton</h1>
<hr>

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br/>
<br/>


## 🚀 Introduzione
Il Singleton è un pattern creazionale che garantisce l'esistenza di una sola istanza relativa di una classe, fornendo un punto di accesso globale a tale istanza. Viene utilizzato per risorse condivise come logger, configurazioni o connessioni a database, evitando duplicazioni e garantendo coerenza.

## 🏭 Caratteristiche
Il pattern si basa su tre elementi chiave:
* un costruttore privato per impedire istanziazioni esterne;
* una variabile statica privata per memorizzare l'istanza unica;
* un metodo statico e pubblico per accedervi.

In UML, è rappresentato:

( foto UML )

La versione "base" del pattern denominata **Lazy Initialization (Non thread-safe)** crea l'istanza solo alla prima chiamata del metodo _getInstance_ risparmiando risorse se non utilizzata.

```java
public class Singleton {

    /* Dichiarazione di una variabile Singleton */
    private static Singleton INSTANCE = null;

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private Singleton() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static */
    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    // Setter & Getter
    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }
}
```

Test JUnit 5 per verificare che la classe Singleton mantenga un'unica istanza e conservi correttamente lo stato.

```java
public class SingletonTest {

    // Singleton
    @Test
    void testSingletonIdentity() {
        // Verifica che due chiamate restituiscano lo stesso riferimento di memoria
        Singleton instance1 = Singleton.getInstance();
        assertNotNull(instance1, "La prima istanza non è null");

        Singleton instance2 = Singleton.getInstance();
        assertNotNull(instance2, "La seconda istanza non è null");

        assertSame(instance1, instance2, "Le due istanze sono identiche (stesso riferimento)");
    }

    @Test
    void testSingletonStateConsistency() {
        Singleton instance1 = Singleton.getInstance();
        assertNotNull(instance1, "La prima istanza non è null");
        String testoPrimaDellaModifica =  instance1.getInfo();
        String nuovoMessaggio = "Modifica testo";
        instance1.setInfo(nuovoMessaggio);
        assertEquals(nuovoMessaggio, instance1.getInfo(), "Testo modificato nella prima istanza");


        Singleton instance2 = Singleton.getInstance();
        assertNotNull(instance2, "La seconda istanza non è null");

        assertEquals(nuovoMessaggio, instance2.getInfo(), "La modifica testo effettuata sulla prima istanza si riflette sulla seconda");
    }
}
```

Questa versione non è adatta a sistemi multithread perché non è **thread-safe**. In un ambiente con più thread, la mancanza di sincronizzazione può portare alla creazione di più istanze della classe, violando il principio cardine del pattern.

Alcuni motivi tecnici sono:
- **Race Condition:** Quando due o più thread chiamano contemporaneamente il metodo _getInstance()_ nel momento in cui l'istanza è ancora _null_, entrambi possono superare il controllo _if(INSTANCE == null)_ nello stesso istante. Di conseguenza, ogni thread procederà a creare la propria istanza separata.
- **Mancanza di atomicità:** L'operazione "controlla se è nullo e poi crea" (check-then-act) non è atomica. Senza un meccanismo di blocco, i thread possono intercalare le loro operazioni in modo imprevedibile.
- **Problemi di visibilità della memoria:** Senza l'uso di parole chiave come _synchronized_ o _volatile_, un thread potrebbe non "vedere" immediatamente l'istanza appena creata da un altro thread a causa delle ottimizzazioni della memoria della JVM, portandolo a crearne una nuova.

Per rendere il Singleton **thread-safe**, si possono utilizzare le seguenti varianti:

**Metodo Synchronized**<br>
Il modificatore synchronized viene utilizzato per risolvere il problema della concorrenza: senza di esso, due thread che accedono contemporaneamente al metodo potrebbero creare due istanze diverse.

```java
public class SingletonSynchronized {

    /* Dichiarazione di una variabile SingletonSynchronized */
    private static SingletonSynchronized INSTANCE = null;

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonSynchronized() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static e synchronized */
    public static synchronized SingletonSynchronized getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonSynchronized();
        }
        return INSTANCE;
    }

    // Setter & Getter
    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }
}
```

Caratteristiche Principali
- **Lazy Initialization:** L'istanza non viene creata all'avvio dell'applicazione, ma solo la prima volta che viene effettivamente richiesta tramite il metodo _getInstance()_.
- **Thread Safety:** L'uso della parola chiave _synchronized_ nel metodo di accesso garantisce che un solo thread alla volta possa eseguire il blocco di codice, evitando che due thread creino contemporaneamente due istanze diverse (violando il pattern).
- **Overhead di Performance:** Poiché l'intero metodo è sincronizzato, ogni chiamata a _getInstance()_ deve acquisire un _lock_, anche dopo che l'istanza è già stata creata. Questo può diventare un colloquio di bottiglia in applicazioni ad alto traffico.
- **Semplicità:** È la soluzione più immediata da scrivere rispetto a varianti più complesse.

- Test JUnit 5 per verificare che la classe mantenga un'unica istanza e conservi correttamente lo stato durante l'esecuzione di diversi thread.

```java
void testSingletonSynchronizedMultithread() throws InterruptedException {

        // Numero di thread
        int threadCount = 1000;

        // Semplifica la gestione dell'esecuzione di task in background
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // Utilizziamo un Set thread-safe per memorizzare le istanze uniche trovate
        Set<Integer> instanceHashCodes = Collections.newSetFromMap(new ConcurrentHashMap<>());

        // Il latch serve a far partire i thread contemporaneamente
        CountDownLatch startLatch = new CountDownLatch(1);
        // Il latch di fine serve ad attendere che tutti i thread abbiano finito
        CountDownLatch finishLatch = new CountDownLatch(threadCount);

        // Ciclo di thread
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    startLatch.await(); // Attende il segnale di partenza
                    SingletonSynchronized instance = SingletonSynchronized.getInstance();
                    instanceHashCodes.add(System.identityHashCode(instance));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown();
                }
            });
        }

        startLatch.countDown(); // Segnale di partenza per tutti i thread
        finishLatch.await();    // Attende il completamento
        executor.shutdown();

        // Verifica che nel set ci sia esattamente 1 solo hashcode (una sola istanza)
        assertEquals(1, instanceHashCodes.size(),
                "Esiste una sola istanza anche con accesso concorrente");
    }
```

**Double-Checked Locking (DCL)**<br>
È un'evoluzione del **Metodo Synchronized**, progettato per ridurre l'overhead delle prestazioni eliminando la sincronizzazione, non necessaria una volta che l'istanza è stata creata.

```java
public class SingletonDCL {

    /* Dichiarazione di una variabile SingletonDCL */
    private static volatile SingletonDCL INSTANCE = null;

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonDCL() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static */
    public static SingletonDCL getInstance() {
        // Primo controllo (senza lock)
        if (INSTANCE == null) {
            synchronized (SingletonDCL.class) {
                // Secondo controllo (con lock)
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDCL();
                }
            }
        }
        return INSTANCE;
    }

    // Setter & Getter
    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }
}
```

La parola chiave **_volatile_** è indispensabile a causa di come la Java Virtual Machine (JVM) e le CPU moderne ottimizzano l'esecuzione del codice (Instruction Reordering).
Senza _volatile_, l'operazione _INSTANCE = new SingletonDCL();_ non è atomica. A livello di bytecode, viene divisa in tre passaggi:

- **Allocazione memoria:** Viene riservato lo spazio per l'oggetto.
- **Inizializzazione:** Viene eseguito il costruttore (impostando i campi).
- **Assegnazione:** Il riferimento _INSTANCE_ punta alla memoria allocata.

Il rischio è che la JVM può riordinare i passaggi 2 e 3. Se il thread A esegue il passaggio 3 (assegnazione) prima del passaggio 2 (costruttore):

- L'istanza non è più null, ma i suoi campi interni non sono ancora stati inizializzati.
- Il thread B arriva, esegue il primo controllo _if (instance == null)_, vede che non è _null_ e restituisce l'oggetto.
- Il thread B tenta di usare l'oggetto, ma trova valori incoerenti o nulli, causando crash improvvisi.

La keyword _volatile_ inibisce il riordinamento impedendo alla JVM di scambiare l'ordine tra la costruzione dell'oggetto e l'assegnazione del riferimento.
Inoltre, forza la CPU a scrivere il valore direttamente nella memoria principale (RAM), assicurando che ogni thread legga sempre il valore più aggiornato e non una copia "vecchia" salvata nella cache locale del core.

Caratteristiche Principali
- **Riduzione dei Lock:** Invece di sincronizzare l'intero metodo, si sincronizza solo il blocco di creazione dell'istanza. Una volta che l'istanza esiste, i thread non entrano più nel blocco _synchronized_.
- **Doppio Controllo:** Si verifica se l'istanza è nulla due volte: una fuori dal blocco _synchronized_ (per velocità) e una dentro (per sicurezza).
- **Parola chiave volatile:** È fondamentale. Senza _volatile_, a causa delle ottimizzazioni del compilatore o della cache della CPU, un thread potrebbe vedere un'istanza parzialmente inizializzata, causando crash imprevedibili.

Test JUnit 5 per verificare che la classe mantenga un'unica istanza e conservi correttamente lo stato durante l'esecuzione di diversi thread.

```java
@Test
public void testSingletonDCLMultithread() throws InterruptedException {
    // Parte iniziale di codice uguale al test del Metodo Synchronized

    // Ciclo di thread
    for (int i = 0; i < threadCount; i++) {
        executor.submit(() -> {
            try {
                startLatch.await(); // Attende il segnale di partenza
                SingletonDCL instance = SingletonDCL.getInstance();
                instanceHashCodes.add(System.identityHashCode(instance));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                finishLatch.countDown();
            }
        });
    }

    // Parte finale del codice uguale al test del Metodo Synchronized
}
```


**Eager Initialization (inizializzazione anticipata)**<br>
L'istanza viene creata al caricamento della classe, indipendentemente dall'uso.

```java
public class SingletonEager {

    /* Dichiarazione di una variabile SingletonEager */
    private static final SingletonEager INSTANCE = new SingletonEager();

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonEager() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static */
    public static SingletonEager getInstance() {
        return INSTANCE;
    }

    // Setter & Getter
    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }
}
```

Caratteristiche Principali
- **Istanza Statica Finale:** L'oggetto viene dichiarato come _static final_, assicurando che sia creato una sola volta dal **ClassLoader**.
- **Costruttore Privato:** Impedisce la creazione di nuove istanze dall'esterno tramite l'operatore _new_.
- **Thread-Safety Nativa:** È intrinsecamente sicuro per il multithreading senza bisogno di blocchi _synchronized_, poiché la JVM gestisce l'inizializzazione statica in modo atomico.

Test JUnit 5 per verificare che la classe mantenga un'unica istanza e conservi correttamente lo stato durante l'esecuzione di diversi thread.

```java
@Test
void testSingletonEagerMultithread() throws InterruptedException {
    // Parte iniziale di codice uguale al test del Metodo Synchronized

    // Ciclo di thread
    for (int i = 0; i < threadCount; i++) {
        executor.submit(() -> {
            try {
                startLatch.await(); // Attende il segnale di partenza
                SingletonEager instance = SingletonEager.getInstance();
                instanceHashCodes.add(System.identityHashCode(instance));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                finishLatch.countDown();
            }
        });
    }
    
    // Parte finale del codice uguale al test del Metodo Synchronized
}
```


**Bill Pugh Singleton**<br>
È considerato l'approccio più elegante ed efficiente in Java. Sfrutta le garanzie fornite dalle specifiche della Java Virtual Machine (JVM) riguardo al caricamento delle classi per gestire la thread-safety senza l'uso esplicito di _synchronized_.

```java
public class SingletonBillPugh {

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonBillPugh() {
        info = "Oggetto inizializzato";
    }

    // Classe statica interna (Holder)
    // Non viene caricata finché non viene richiamata esplicitamente
    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    /* Metodo static */
    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Setter & Getter
    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }
}
```

Caratteristiche Principali
- **Lazy Initialization:** L'istanza non viene creata quando viene caricata la classe principale (_SingletonBillPugh_), ma solo al primo richiamo del metodo _getInstance()_.
- **Thread Safety Nativa:** La JVM garantisce che il caricamento di una classe sia un'operazione thread-safe. Poiché l'istanza è una costante _static_ della classe interna, la sua creazione è atomica e protetta dalla JVM stessa. 
- **Performance Massime:** Non essendoci blocchi _synchronized_ o keyword _volatile_, l'accesso all'istanza è veloce quanto un normale accesso a una variabile statica.
- **Resistenza ai riordinamenti:** Risolve intrinsecamente il problema degli oggetti parzialmente costruiti senza bisogno di configurazioni extra.

Test JUnit 5 per verificare che la classe mantenga un'unica istanza e conservi correttamente lo stato durante l'esecuzione di diversi thread.

```java
@Test
void testSingletonBillPughMultithread() throws InterruptedException {
    // Parte iniziale di codice uguale al test del Metodo Synchronized

    // Ciclo di thread
    for (int i = 0; i < threadCount; i++) {
        executor.submit(() -> {
            try {
                startLatch.await(); // Attende il segnale di partenza
                SingletonBillPugh instance = SingletonBillPugh.getInstance();
                instanceHashCodes.add(System.identityHashCode(instance));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                finishLatch.countDown();
            }
        });
    }

    // Parte finale del codice uguale al test del Metodo Synchronized
}
```


