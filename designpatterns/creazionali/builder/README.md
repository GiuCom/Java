## [Design Patterns](../..)
### [Creazionali](..)
# Builder

----

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br>
<br>

## 🚀 Introduzione
Il **Builder** è un design pattern creazionale che separa la costruzione di un oggetto complesso dalla sua rappresentazione. 

Questo disaccoppiamento consente al medesimo processo di costruzione di creare rappresentazioni diverse dello stesso oggetto.

A differenza di altri pattern creazionali che creano l'oggetto in un singolo passaggio (come il **Factory Method**), il Builder costruisce l'oggetto passo dopo passo sotto il controllo di un "direttore" o direttamente tramite un'interfaccia fluente (**fluent interface**).

## 🏭 Caratteristiche
Il pattern **Builder** nasce principalmente per risolvere l'anti-pattern del **Telescoping Constructor** (costruttore telescopico). Questo si verifica quando un oggetto richiede numerosi parametri di inizializzazione, molti dei quali opzionali.

Senza il Builder, siamo costretti a creare:

- Una moltitudine di costruttori in sovraccarico (**overloading**), uno per ogni possibile combinazione di parametri.
- Un singolo costruttore gigantesco in cui i parametri opzionali vengono passati come null o con valori di default, compromettendo la leggibilità e la sicurezza del tipo a compile-time.

L'implementazione classica del pattern prevede quattro attori principali:

- **Product:** La classe che definisce l'oggetto complesso da costruire. Solitamente include diverse parti e non ha un'interfaccia standardizzata se i prodotti generati dai vari builder differiscono significativamente.
- **Builder (Interfaccia/Classe Astratta):** Specifica i metodi astratti per creare le varie parti del **Product**.
- **ConcreteBuilder:** Implementa l'interfaccia **Builder**. Costruisce e assembla le parti del prodotto, mantenendone lo stato durante l'assemblaggio. Fornisce un metodo finale (es. `getResult()`) per restituire l'oggetto completato.
- **Director:** Una classe che riceve un riferimento a un oggetto **Builder** e invoca i suoi passi di costruzione in un ordine specifico. Il **Director** maschera la complessità dell'algoritmo di costruzione al Client.

In UML, è rappresentato:

<p align="center">
  <img alt="Builder schema UML" title="Builder schema UML" src="../../../Appunti/img/DesignPatterns_Builder_UML.png" style="width: 80%; height: 80%;"><br/>
</p>

-----

### ESEMPIO

Simuliamo l'assemblaggio di un Computer.<br> A seconda del Builder che utilizzeremo (es. Computer da ufficio vs. Computer da gaming), otterremo prodotti con caratteristiche radicalmente diverse, pur utilizzando le stesse istruzioni di assemblaggio.

Le classi che utilizzeremo sono:

- **Computer (Product):** L'oggetto complesso finale. Ha diverse parti (CPU, RAM, Storage, GPU).
- **ComputerBuilder (Builder):** Un'interfaccia che dichiara i passi di costruzione.
- **ComputerGamingBuilder, OfficeBuilder (Concrete Builders):** Forniscono le implementazioni specifiche per ogni passo di costruzione e mantengono lo stato del prodotto in via di assemblaggio.
- **ComputerDirector (Director):** Definisce l'ordine esatto in cui eseguire i passi di costruzione.

Un dettaglio architetturale cruciale del pattern è che il **Director** non restituisce mai il prodotto. Il Client istanzia il **Builder**, lo passa al **Director**, dice al **Director** di eseguire il lavoro, e infine estrae il prodotto finito dal **Builder**.
<br>Flusso di esecuzione:

1. Il Client sceglie il tipo specifico di costruzione instanziando **GamingBuilder**.
2. Il Client passa questo builder al **Director**.
3. Il Client invoca un metodo sul **Director** (es. `constructFullComputer()`).
4. Il **Director** chiama iterativamente i metodi `build...()` sul **Builder**.
5. Il Client chiama `getResult()` sul **Builder** per ottenere l'oggetto **Computer** appena assemblato.

Il codice sorgente:

- **Computer.java**<br>
Contiene le parti che verranno assemblate.
```java
public class Computer {
    private String cpu;
    private String ram;
    private String gpu;

    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setRam(String ram) { this.ram = ram; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getGpu() { return gpu; }
    
    public void mostraConfigurazione() {
        System.out.println("PC con: " + cpu + ", " + ram + ", " + gpu);
    }
}
```

- **ComputerBuilder.java**<br>
  Dichiara i metodi per costruire le parti del prodotto Computer.
```java
abstract class ComputerBuilder {
    protected Computer computer;

    public Computer getComputer() { return computer; }
    public void creaNuovoComputer() { computer = new Computer(); }

    public abstract void buildCpu();
    public abstract void buildRam();
    public abstract void buildGpu();
}
```

- **ComputerGamingBuilder.java**<br>
  Definisce come costruire un PC dedicato al Gaming.
```java
public class ComputerGamingBuilder extends ComputerBuilder {
    public void buildCpu() { computer.setCpu("Intel i9"); }
    public void buildRam() { computer.setRam("32GB DDR5"); }
    public void buildGpu() { computer.setGpu("NVIDIA RTX 4090"); }
}
```

- **ComputerOfficeBuilder.java**<br>
  Definisce come costruire un PC dedicato all'Office.
```java
public class ComputerOfficeBuilder extends ComputerBuilder {
    public void buildCpu() { computer.setCpu("Intel i5"); }
    public void buildRam() { computer.setRam("16GB DDR5"); }
    public void buildGpu() { computer.setGpu("NVIDIA GeForce GT 1030"); }
}
```

- **ComputerDirector.java**<br>
  Controlla l'ordine della costruzione. Non sa quali pezzi vengono usati, sa solo quando vanno montati.
```java
public class ComputerDirector {
    private ComputerBuilder builder;

    void setBuilder(ComputerBuilder b) { builder = b; }

    public void assembla() {
        builder.creaNuovoComputer();
        builder.buildCpu();
        builder.buildRam();
        builder.buildGpu();
    }
}
```

- **BuilderMain.java**<br>
  Il cliente non interagisce direttamente con i componenti del PC, ma delega tutto all'ingegnere (**ComputerDirector**).
```java
public class BuilderMain {
    // Client
    static void main() {
        ComputerDirector ingegnere = new ComputerDirector();
        ComputerBuilder gamingBuilder = new ComputerGamingBuilder();

        // L'ingegnere usa il manuale del PC da Gaming
        ingegnere.setBuilder(gamingBuilder);
        ingegnere.assembla();

        // Otteniamo il prodotto finale
        Computer mioPC = gamingBuilder.getComputer();
        mioPC.mostraConfigurazione();
    }
}
```

Caratteristiche:

- **Isolamento:** Se necessario produrre un nuovo tipo di computer (es. **ComputerServerBuilder**), basta creare una nuova classer senza toccare il codice della classe **ComputerBuilder** o della classe **Computer**.
- **Controllo:** La classe **ComputerDirector** garantisce che la RAM non venga montata prima della scheda madre (ordine logico).

----

## Test

In questo test verificheremo tre aspetti fondamentali:

1. **ComputerDirector** (l'Ingegnere) coordini correttamente il Builder
2. L'oggetto **Computer** risultante abbia i componenti attesi

```java
public class BuilderTest {

    private ComputerDirector ingegnere;

    @BeforeEach
    void setUp() {
        // Arrange: Inizializziamo il Director prima di ogni test
        ingegnere = new ComputerDirector();
    }

    @Test
    void testCostruzioneGamingPC() {
        // Arrange: Scegliamo il builder specifico
        ComputerBuilder gamingBuilder = new ComputerGamingBuilder();
        ingegnere.setBuilder(gamingBuilder);

        // Act: Eseguiamo l'assemblaggio
        ingegnere.assembla();
        Computer pcRisultante = gamingBuilder.getComputer();

        // Assert: Verifichiamo che i componenti siano quelli del GamingPCBuilder
        assertNotNull(pcRisultante, "Il computer non dovrebbe essere null");
        assertEquals("Intel i9", pcRisultante.getCpu(), "La CPU dovrebbe essere Intel i9");
        assertEquals("32GB DDR5", pcRisultante.getRam(), "La RAM dovrebbe essere 32GB DDR5");
        assertEquals("NVIDIA RTX 4090", pcRisultante.getGpu(), "La GPU dovrebbe essere RTX 4040");
    }

    @Test
    void testCambioBuilderInCorsa() {
        // Verifichiamo che l'ingegnere possa cambiare configurazione facilmente
        ComputerBuilder officeBuilder = new ComputerOfficeBuilder(); // Supponendo esista
        ingegnere.setBuilder(officeBuilder);
        ingegnere.assembla();

        Computer pcOffice = officeBuilder.getComputer();
        assertNotNull(pcOffice.getCpu());
    }
}
```

Abbiamo utilizzato:

- **@BeforeEach:** Per resettare lo stato dell'ingegnere, garantendo che ogni test sia isolato e indipendente.
- **assertEquals:** Per confrontare il valore atteso (es. "Intel i9") con quello effettivamente impostato nel prodotto finale.
- **Validazione della Struttura:** Il test conferma che la separazione tra la logica di costruzione (Ingegnere) e i dati (Builder) funzioni correttamente.

----


Nello sviluppo software moderno (specialmente in linguaggi come Java), è molto diffusa la variante descritta da **Joshua Bloch** nel libro _Effective Java_. Questa variante elimina la classe **Director** e utilizza una classe statica interna (**Inner Builder**) combinata con una **fluent interface** per concatenare le chiamate ai metodi di costruzione.

