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

La versione "base" del pattern è la seguente:

```java
public final class Singleton {

    private static Singleton INSTANCE;
    private String info = "Oggetto inizializzato";

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    public void setInfo (String info) {
        info = this.info;
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

Per rendere il Singleton sicuro in Java, si possono utilizzare a


La variante **Eager** 
