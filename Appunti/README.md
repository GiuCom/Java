<link rel="stylesheet" href="css/styles.css">

# Java

<p align="center">
  <img title="Logo Java" alt="Logo Java" src="img/Java_Logo_256px.png" ><br/>
  <img title="Versione Java" alt="Versione Java" src="https://img.shields.io/badge/Java_version-25-blue" >
  <img title="Licenza MIT" alt="Licenza MIT" src="https://img.shields.io/badge/license-MIT-blue.svg" ><br/>
</p>

## 📚 Storia
<div class="text-justify">Java nasce all’inizio degli anni ’90 in un contesto di rapida evoluzione tecnologica, caratterizzato dalla diffusione di dispositivi elettronici sempre più complessi e dalla necessità di renderli programmabili in modo semplice, sicuro e indipendente dall’hardware.
Nel 1991 presso la Sun Microsystems, James Gosling, Patrick Naughton e Mike Sheridan guidarono un gruppo di lavoro noto come Green Team con l’obiettivo di sviluppare un linguaggio di programmazione ad alto livello destinato al controllo di dispositivi elettronici come elettrodomestici, smart card, robot e sistemi embedded.
Le richieste principali erano ambiziose: il linguaggio doveva essere portabile, cioè eseguibile su architetture hardware differenti, robusto, per ridurre al minimo gli errori a runtime, e semplice da compilare, poiché i produttori dei dispositivi non erano disposti a investire in strumenti di sviluppo complessi.</div>
<br/>
<p align="center">
  <img title="Java Green Team" alt="Java Green Team" src="img/Java_Green_Team.jpg" ><br/>
</p>
<br/>
<div class="text-justify">Nel 1992 nasce il linguaggio Oak (in italiano "quercia"), successivamente cambiato con il nome Java per problemi di diritto d’autore (il linguaggio di programmazione Oak esisteva già). Il progetto iniziale non ottenne grande successo commerciale.
Tuttavia, nel 1994, con la rapida diffusione di Internet, James Gosling, assieme a Patrick Naughton e Jonathan Payne colsero una nuova opportunità: utilizzare Java per creare applicazioni capaci di essere distribuite e avviate direttamente attraverso la rete.
Il 23 maggio 1995, durante la conferenza SunWorld, venne presentato il browser HotJava, in grado di scaricare ed eseguire piccoli programmi chiamati Applet, dimostrando per la prima volta il potenziale di Java come linguaggio portabile e orientato alla rete.</div>
<br/>
<p align="center">
  <img title="Sun World 1995" alt="Sun World 1995" src="img/Java_Sun_World_95.gif" ><br/>
</p>
<br/>
Le altre importanti tappe furono:

- 1996 - Venne rilasciato il Java Development Kit (JDK) versione 1.0
- 1998 – J2SE 1.2: Introduzione delle "Swing" per le interfacce grafiche e del "Collections Framework". Java viene diviso in tre edizioni: J2SE (Standard), J2EE (Enterprise) e J2ME (Micro).
- 2004 – Java 5 (Tiger): Una pietra miliare che introduce i Generics, le annotazioni, l'autoboxing e il ciclo "for-each".
- 2006 – Open Source: Sun Microsystems rilascia gran parte del codice sorgente di Java sotto licenza GNU GPL, portando alla creazione di OpenJDK.
- 2010 – Acquisizione da parte di Oracle: Oracle Corporation acquisisce Sun Microsystems e assume la gestione del linguaggio.
- 2014 – Java 8: Considerata la versione più rivoluzionaria dell'era moderna, introduce le Espressioni Lambda e le API Stream, portando elementi di programmazione funzionale in Java.
- 2017 – Java 9 e il nuovo ciclo: Viene introdotta la modularità (Progetto Jigsaw) e Oracle annuncia un nuovo ciclo di rilascio ogni 6 mesi per accelerare l'innovazione.
- 2021 – Java 17 (LTS): Viene rilasciata un'importante versione con supporto a lungo termine (Long-Term Support), consolidando funzionalità come i Records e il Pattern Matching.
- 2022 (Marzo) - Java 18 ha introdotto un Simple Web Server predefinito (per test rapidi senza installare server esterni) e ha reso UTF-8 il set di caratteri predefinito ovunque.
- 2022 (Novembre) - Java 19 (Settembre 2022): Una versione storica che ha introdotto in "preview" i Virtual Threads (Progetto Loom), progettati per gestire milioni di thread con pochissime risorse, superando i limiti dei thread classici del sistema operativo.
- 2023 - Java 21 (LTS) Ha reso i Virtual Threads una funzionalità stabile e definitiva. Ha introdotto inoltre:
  - Sequenced Collections: Nuove interfacce per gestire l'ordine degli elementi in modo uniforme (es. getFirst(), getLast()).
  - Record Patterns: Per deostruire i dati in modo rapido e leggibile.
  - Pattern Matching per switch: Finalizzato per permettere controlli complessi sui tipi direttamente nel comando
- 2024 - Java 22 & 23 hanno introdotto miglioramenti alla Foreign Function & Memory API (per comunicare meglio con librerie C/C++) e hanno semplificato l'apprendimento per i principianti con gli Implicitly Declared Classes (permettono di scrivere un programma senza dichiarare esplicitamente una classe public class Main)
- 2025 - Java 24 & 25 portano innovazioni come i Compact Object Headers (per ridurre l'uso della memoria) e potenziamenti specifici per applicazioni basate su Microservizi e AI.

## 🧑‍💻 Modalità di traduzione del codice
I linguaggi di programmazione compilati, come ad esempio C++, Rust, GO, utilizzano un compilatore per tradurre il codice sorgente in codice macchina, specifico per una piattaforma su cui si esegue la compilazione, ed eseguibile direttamente dal processore. Questo processo avviene prima dell'esecuzione del programma, rendendo il codice veloce ed efficiente. Gli svantaggio sono:

- Tempo di compilazione: Ogni modifica al codice richiede un processo di ricompilazione dell'intero programma (o di parti di esso) prima di poterlo testare.
- Mancanza di portabilità immediata: Il compilatore genera un file eseguibile specifico per un determinato processore e sistema operativo. Per eseguire lo stesso programma su una piattaforma differente (ad esempio, passare da Windows a Linux o da Intel ad ARM), è necessario ricompilare il codice sorgente per quel target specifico.
- Flessibilità ridotta a runtime: A differenza dei linguaggi interpretati, non è possibile modificare il codice "al volo" mentre il programma è in esecuzione; qualsiasi cambiamento richiede la chiusura del software, la modifica del sorgente e una nuova compilazione.

I linguaggi di programmazione, come ad esempio JavaScript, PHP, Ruby, Perl offrono una grande flessibilità e velocità di sviluppo, ma sacrificano le prestazioni.  
Interpretati. Il codice sorgente può essere eseguito, senza doverlo compilare, su qualsiasi sistema operativo (Windows, macOS, Linux) senza modifiche, a patto che sia installato l'interprete corretto per quella piattaforma. Inoltre, non essendoci una fase di compilazione separata, su può scrivere il codice ed eseguirlo istantaneamente testando velocemente l'eventuali modifiche.
Gli svantaggio sono:

- Minore velocità di esecuzione: Tradurre il codice in linguaggio macchina "al volo" durante l'esecuzione introduce un sovraccarico (overhead) che rende questi programmi più lenti rispetto a quelli pre-compilati.
- Dipendenza dall'interprete: Per far girare il software, l'utente finale deve avere l'interprete (come Python o Node.js) installato sul proprio computer; non basta un semplice file eseguibile autonomo.
- Mancanza di riservatezza del codice: Poiché viene distribuito il codice sorgente (o un formato molto simile), è molto più difficile proteggere la proprietà intellettuale o nascondere segreti industriali rispetto a un file binario compilato

Java è considerato un linguaggio ibrido, poiché combina i processi di compilazione e interpretazione per bilanciare portabilità e prestazioni. Il codice sorgente Java viene prima compilato in bytecode, mediante il comando javac, per generare un file .class, che viene poi interpretato dalla Java Virtual Machine traducendolo in istruzioni specifiche per il processore su cui sta girando.
Per non essere lento come i linguaggi interpretati, Java utilizza un componente chiamato JIT (Just-In-Time) Compiler all'interno della JVM. In particolare:

- Il JIT analizza il codice durante l'esecuzione,
- Individua le parti di codice eseguite più frequentemente (i cosiddetti "hotspot").
- Compila queste parti direttamente in codice macchina nativo, rendendole veloci quanto un programma scritto in C++.

In breve, Java viene compilato per diventare portabile e interpretato/compilato al volo per essere eseguito velocemente su qualsiasi dispositivo.
La JVM mediante un processo automatico eseguito in background, Garbage Collector (GC), gestisce la memoria dell'applicazione, liberando lo sviluppatore dal compito manuale (e rischioso) di deallocare gli oggetti non più necessari.
Il GC non elimina gli oggetti in base a un timer, ma in base alla loro utilità. Un oggetto viene considerato "spazzatura" quando non è più raggiungibile da nessuna parte attiva del programma (i cosiddetti GC Roots, come variabili locali nello stack o variabili statiche).

## 🧑‍💻 JRE & JDK
Il **JDK** (Java Development Kit) rappresenta l'ambiente di sviluppo integrale necessario per il ciclo di vita completo di un'applicazione Java. Esso fornisce il compilatore (javac), i tool di documentazione (javadoc), strumenti di archiviazione (jar) e utility di debugging e monitoraggio. Al suo interno, il JDK include il JRE (Java Runtime Environment), che costituisce l'ecosistema di esecuzione lato client.</br> 
Il **JRE** agisce come strato di astrazione tra l'applicazione e il sistema operativo, integrando le librerie di classi standard (Java Class Libraries) e la JVM (Java Virtual Machine).

## 🧑‍💻 JVM
La Java Virtual Machine (JVM), componente fondamentale del Java Runtime Environment (JRE), funge da traduttore universale, consente ai programmi scritti in linguaggio Java di essere eseguiti su qualsiasi piattaforma senza modifiche del codice sorgente, in quanto perché esiste una JVM specifica per ogni OS (Windows, Linux o Mac) che "capisce" quel codice.
</br>

Per comprendere la JVM facciamo un piccolo passo indietro e descriviamo cos'è una Virtual Machine (VM).
Una VM è un "computer dentro un altro computer". Più precisamente è un ambiente software che emula il comportamento di un computer fisico, creando CPU, memoria RAM, disco rigido e scheda di rete virtuali. L'elemento centrale è l'Hypervisor (o VMM - Virtual Machine Monitor), uno strato software che astrae le risorse hardware fisiche e le distribuisce in modo isolato alle diverse macchine virtuali
Le risorse hardware virtuali vengono "estrapolate" dalle risorse hardware fisiche del computer che ospita le VM.
Il computer che ospita il software è detto Host, mentre la macchina virtuale è definita Guest.
<br/>
<p align="center">
  <img title="Hypervisor" alt="Hypervisor" src="img/Hypervisor.png" ><br/>
</p>
<br/>
Agisce come un "vigile urbano" delle risorse informatiche, distribuendo potenza di calcolo (CPU), memoria (RAM) e archiviazione tra più sistemi operativi indipendenti che girano contemporaneamente sulla stessa macchina fisica
Esistono due categorie fondamentali di hypervisor, distinte dal modo in cui interagiscono con l'hardware:
- Tipo 1 (Bare Metal): Viene installato direttamente sull'hardware fisico del computer (senza un sistema operativo sottostante). È il tipo più efficiente e sicuro, ideale per i data center aziendali. 
  - Esempi: VMware ESXi, Microsoft Hyper-V, KVM, Xen
- Tipo 2 (Hosted): Viene installato come un'applicazione sopra un sistema operativo esistente (come Windows, macOS o Linux). È perfetto per usi individuali o di test sul proprio PC.
  - Esempi: Oracle VM VirtualBox, VMware Workstation, Parallels Desktop

La JVM è una "macchina virtuale di processo" o "applicativa", progettata specificamente per eseguire un singolo programma.
Non emula un intero computer, ma fornisce un ambiente di runtime che gestisce esclusivamente l'esecuzione del Bytecode Java. Gestisce autonomamente memoria (Garbage Collection) e thread garantendo la portabilità del codice.
<br/>
<p align="center">
  <img title="JVM Architettura" alt="JVM Architettura" src="img/JVM_Architettura.png" style="width: 65%; height: 65%;"><br/>
</p>
<br/>
Un file sorgente .java viene compilato mediante l'uso del comando javac che lo traduce in formato Bytecode creando un file .class

Saluto.java
```java
class Saluto { 
    static void main(String[] args) {
      String nome = "Giuseppe";
      System.out.println("Ciao " + nome + "!!");
  }
}
```
Con il comando

```console
javac Saluto.java
```

viene compilato il file sorgente Saluto.java e viene generato il file Bytecode Saluto.class
Il Bytecode non è codice macchina nativo (non può girare direttamente sul processore), ma è il formato universale che JVM è in grado di eseguire.
Con il comando ***java*** si inizializza la JVM che carica il bytecode della classe specificata e carica in memoria il metodo main() per eseguire l'applicazione.

```console
java Saluto  
```

La prima attività che effettua la JVM è l'utilizzo delle Class Loader:

- **Bootstrap Class Loader** (conosciuto anche come Primordial Class Loader) è il componente più fondamentale della JVM ed è il punto di partenza dell'intero processo di caricamento delle classi in Java. Non è una classe Java. È un pezzo di codice nativo integrato direttamente nel nucleo della JVM. Il suo compito è caricare le librerie software fondamentali necessarie al funzionamento stesso dell'ambiente Java (java.lang, java.net, java.util, java.io, etc..)<br/>
- **Platform Class Loader** (Extension Class Loader fino alla versione Java 8) Carica i moduli Java "di piattaforma" che non sono strettamente necessari per l'avvio del cuore della JVM (caricato dal Bootstrap), ma che fanno comunque parte delle specifiche Java SE (come java.sql, java.xml o java.desktop).
  Il Platform Class Loader segue rigorosamente il Delegation Model:
  1. Quando riceve una richiesta per caricare una classe, interroga prima il suo genitore: il Bootstrap Class Loader.
  2. Se il Bootstrap non trova la classe, il Platform Class Loader prova a caricarla dai propri moduli.
  3. Se fallisce anche lui, passa la palla al figlio: l'Application Class Loader.
  
  A differenza del Bootstrap loader (che restituisce null), il Platform Class Loader è un oggetto Java.<br/>
- **Application Class Loader** (conosciuto anche come System Class Loader) è l'ultimo anello della catena ed è quello con cui interagirai di più come sviluppatore. E' responsabile del caricamento delle classi scritte da te e delle librerie di terze parti (come file JAR esterni) incluse nel progetto.<br/>

  Seguendo il modello Delegation:
  L'Application Class Loader riceve la richiesta di caricare una classe (ad esempio, la tua classe Saluto). Chiede al Platform Class Loader di caricarla. Se nessuno dei genitori (Bootstrap o Platform) la trova, allora l'Application Class Loader tenta di caricarla dai percorsi del tuo progetto. Se non la trova nemmeno lui, viene lanciata la famosa eccezione ClassNotFoundException o NoClassDefFoundError.

Riassumendo:

	- Bootstrap: Cuore di Java (java.base).
	- Platform: Moduli opzionali di sistema (java.sql, java.xml).
	- Application: Il tuo codice e le tue dipendenze (Maven, Gradle, JAR esterni).

Il **Linking** è la seconda fase del ciclo di vita di una classe nella JVM (subito dopo il Loading). È il processo che prende il bytecode appena caricato e lo rende "pronto all'uso", integrandolo nell'ambiente di runtime.
Si divide in tre sotto-fasi fondamentali:

- **Verify** è la fase più importante per la sicurezza. La JVM controlla che il bytecode nel file .class sia valido e non violi le regole del linguaggio:
  * Controlla che non ci siano tentativi di accedere a zone di memoria vietate.
  * Verifica che i tipi di dati siano coerenti (es. non sommare un intero a un oggetto).
  * Assicura che il codice non causi l'overflow dello stack.
- **Prepare** in questa fase, la JVM alloca la memoria necessaria per i campi statici (le variabili static) della classe. Qui le variabili non vengono impostate ai valori indicati nel file sorgente, ma ai loro valori predefiniti (es. 0 per gli int, false per i boolean, null per gli oggetti).
- **Resolve** questa è la fase "di collegamento" vera e propria. La JVM sostituisce i riferimenti simbolici nel file con riferimenti diretti (indirizzi di memoria reali).
  Se la classe usa una variabile di un'altra classe chiamata Persona, nel bytecode c'è solo il nome "Persona". Durante la risoluzione, la JVM trova dove si trova effettivamente la classe Persona in memoria e crea un puntatore diretto a essa.

L'**Initialization** (Inizializzazione) è la fase finale del caricamento di una classe nella JVM. È il momento in cui il codice Java che hai scritto viene effettivamente eseguito per la prima volta.
Mentre nella fase precedente (Preparation) la JVM aveva solo preparato lo spazio in memoria riempiendolo con zeri o null, qui avvengono i veri assegnamenti.
La JVM genera internamente un metodo speciale chiamato <clinit> (Class Initialization). Questo metodo raccoglie:
- Tutti gli assegnamenti delle variabili statiche (es: static int x = 50;).
- Tutti i blocchi statici definiti con static { ... }
In questa fase:
- Le variabili static ricevono i valori definiti nel codice (il nostro x passa da 0 a 50).
- Vengono eseguiti i blocchi di codice all'interno dei blocchi static.
- Viene garantita l'esecuzione in ordine di apparizione nel file sorgente.
Prima di inizializzare una classe, la JVM si assicura che la sua Superclasse (la classe madre) sia già stata inizializzata. È un processo ricorsivo che risale fino a Object.
L'inizializzazione non avviene appena il programma parte, ma solo al primo utilizzo attivo della classe, ovvero quando:
- Viene creata un'istanza della classe (new Saluto()).
- Viene chiamato un metodo statico.
- Viene assegnata o usata una variabile statica (non final costante).
- Viene avviata la classe come punto di ingresso (main).

Riassumendo (con esempio una Biblioteca):

	- Il Loading porta il libro (la classe) in biblioteca, 
    - Il Linking controlla che le pagine siano scritte correttamente (Verification), 
      prepara lo scaffale dove appoggiarlo (Preparation) 
      e crea l'indice che collega i capitoli tra loro (Resolution). 
    - L'Initialization "Apre la biblioteca" prepara l'ambiente per eseguire il codice 
      statico partendo dal metodo main().

## 👥 Authors

- **Giuseppe Compagno** - [link](https://www.compagno.cloud)<br/>


## 🤝 Contributi

Disponibile a condividere con chiunque consigli o revisioni di codice per migliore il contenuto di questo repository<br/>


## 🙏 Ringraziamenti

Lista di chi ha contribuito:<br/>


## 📚 References

Claudio De Sio Cesari, "***Il nuovo Java***", 2020 - [link](https://www.nuovojava.it)<br/>
Franco Guidi Polanco, "***GOF's design patterns in Java***", 2002 - [link](http://eii.ucv.cl/pers/guidi/designpatterns.htm)<br/>
Rudolf Pecinovský, "***OOP – Learn Object-Oriented Thinking and Programming***", 2013 - [link](https://pub.bruckner.cz/titles/oop)<br/>


## ⚖️ Licenza

Questo progetto è coperto da **licenza MIT** - [link](../LICENSE)<br/>


## 📞 Contact

Per un supporto o aiuto:<br/>
- Crea un issue<br/>
- Invia un pull request<br/>
- Contattami via mail - [mail](mailto:info@compagno.cloud)<br/>


## 🔍 Version History

- 1.0.0: Fase iniziale<br/>


--- ❤️ by Giuseppe ♾️ ---
