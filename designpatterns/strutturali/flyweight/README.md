## [Design Patterns](../..)
### [Strutturali](..)
# Flyweight

----

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br>
<br>

## 🚀 Introduzione
Il **Flyweight** (Peso Leggero) è un design pattern strutturale il cui obiettivo primario è la minimizzazione dell'utilizzo di memoria mediante la condivisione del maggior numero possibile di dati con oggetti simili.
<br>In contesti applicativi dove è necessaria la creazione di un numero elevato di oggetti (nell'ordine delle migliaia o milioni), il consumo di RAM può diventare proibitivo. Il pattern **Flyweight** risolve il problema scindendo lo stato di un oggetto in due categorie:

- **Intrinsic state (Stato Intrinseco):** Informazioni costanti, indipendenti dal contesto e condivisibili tra contesti diversi (es. il codice di un carattere, il colore di una texture).
- **Extrinsic state (Stato Estrinseco):** Informazioni variabili che dipendono dal contesto e non possono essere condivise (es. le coordinate x,y di un oggetto sullo schermo).

## 🏭 Caratteristiche
L'architettura si basa su tre componenti fondamentali:

- **Flyweight Interface (Interfaccia):** Definisce i metodi che accettano lo stato estrinseco.
- **Concrete Flyweight:** Implementa l'interfaccia e memorizza lo stato intrinseco.
- **Flyweight Factory:** Gestisce il pool di oggetti condivisi, garantendo che ogni stato intrinseco univoco corrisponda a una sola istanza.
- **UnsharedFlyweight (facoltativo):** Rappresenta oggetti **flyweight** che non condividono lo stato con altri. Non è strettamente necessario, ma è utile per chiarire differenze tra oggetti condivisi e non.
- **Client (Forest/Client):** Utilizza la classe **Flyweight Factory** per creare e gestire oggetti, associando a ognuno i propri dati.

In UML, è rappresentato:

<p align="center">
  <img alt="Flyweight schema UML" title="Flyweight schema UML" src="../../../Appunti/img/DesignPatterns_UML_Flyweight.png" style="width: 75%; height: 75%;"><br/>
</p>

-----

### ESEMPIO
Si simula una foresta con migliaia di alberi. Ogni albero ha un tipo condiviso (intrinseco): specie, colore, texture (TreeType).
Ha anche uno stato estrinseco: coordinate (x, y) e potenzialmente altezza o dimensioni specifiche per quel posizionamento.
Un oggetto della classe **Flyweight Factory** gestisce il pool di TreeType, restituendo sempre lo stesso oggetto per una combinazione intrinseca identica.
<br>Questo approccio permette di creare foreste molto più grandi senza esaurire la memoria, perché i TreeType (intrinseci) vengono riutilizzati anziché duplicati per ogni albero.

**Flyweight.java** (Interfaccia)<br>
- **Responsabilità:** definire l’operazione condivisa tra gli oggetti **flyweight**. In questo esempio, un metodo `disegna` che accetta coordinate estrinseche.
- **Stato:** nessuno, è un contratto che gli oggetti **flyweight** concreti devono implementare.
- **Metodi principali:** `void disegna(int x, int y)`

```java
public interface Flyweight {
  void disegna(int x, int y);
}
```

**AlberoDefinizione.java** (ConcreteFlyweight)<br>
- **Responsabilità:** rappresentare lo stato intrinseco condiviso tra oggetti **Flyweight**. Contiene nome/specie, colore e texture.
- **Stato intrinseco:** `nome` (es. "Quercia"), `colore` (es. "Verde"), `texture` (es. "Ruvida")
- **Metodi principali:** 
  - `AlberoDefinizione(String nome, String colore, String texture)` 
  - `void disegna(int x, int y)`
- **Metodi di accesso:** 
  - getters per `nome`, `colore`, `texture` (se necessario)

```java
/**
 * ConcreteFlyweight che contiene lo stato intrinseco condiviso tra alberi.
 */
public class AlberoDefinizione implements Flyweight {
  private final String nome;
  private final String colore;
  private final String texture;

  public AlberoDefinizione(String nome, String colore, String texture) {
    this.nome = nome;
    this.colore = colore;
    this.texture = texture;
  }

  @Override
  public void disegna(int x, int y) {
    System.out.println("Disegno albero di tipo " + nome +
            " in posizione [" + x + ", " + y + "] colore=" + colore +
            " texture=" + texture);
  }

  public String getNome() {
    return nome;
  }

  public String getColore() {
    return colore;
  }

  public String getTexture() {
    return texture;
  }
}
```

**FlyweightFactory.java** (Flyweight Factory)<br>
- Responsabilità: fornire oggetti **Albero** condivisi in base a chiavi che rappresentano lo stato intrinseco. Gestisce un pool (mappa) ed evita duplicati.
- Stato: variabile `Map<String, AlberoDefinizione> pool`
- Metodi principali: 
    - `AlberoDefinizione getAlberoDefinizione(String nome, String colore, String texture)`
    - `int getPoolSize()`

```java
public class FlyweightFactory {
  private final Map<String, AlberoDefinizione> pool = new HashMap<>();

  public AlberoDefinizione getAlberoDefinizione(String nome, String colore, String texture) {
    String key = nome + "|" + colore + "|" + texture;
    AlberoDefinizione type = pool.get(key);
    if (type == null) {
      type = new AlberoDefinizione(nome, colore, texture);
      pool.put(key, type);
    }
    return type;
  }

  public int getPoolSize() {
    return pool.size();
  }
}
```

**Albero.java**<br>
Utilizziamo i Record
- **Responsabilità:** rappresenta un singolo albero con stato estrinseco (x, y) associato a un AlberoDefinizione (flyweight).
- **Stato:** 
  - `x`, `y` (estrinseco), 
  - `tipoDiAlbero` (AlberoDefinizione)
- **Metodi principali:** 
  - `Albero(int x, int y, AlberoDefinizione tipoDiAlbero)`, 
  - `void disegna()`, 
  - i getters creati in automatico dal Record


```java
public record Albero(int x, int y, AlberoDefinizione tipoDiAlbero) {

  public void disegna() {
    tipoDiAlbero.disegna(x, y);
  }
}
```

**Foresta.java** (Client)<br>
- **Responsabilità:** esempio di client che utilizza FlyweightFactory per creare e gestire una collezione di Tree, dimostrando la condivisione.
- **Stato:** factory: FlyweightFactory, trees: List
- **Metodi principali:** Foresta(FlyweightFactory factory), void plantTree(int x, int y, String name, String color, String texture), void draw(), List getTrees()

```java
public class Foresta {
  private final FlyweightFactory factory;
  private final List<Albero> alberi = new ArrayList<>();

  public Foresta(FlyweightFactory factory) {
    this.factory = factory;
  }

  public void inserisciAlbero(int x, int y, String nome, String colore, String texture) {
    AlberoDefinizione tipoDiAlbero = factory.getAlberoDefinizione(nome, colore, texture);
    alberi.add(new Albero(x, y, tipoDiAlbero));
  }

  public void disegna() {
    for (Albero a : alberi) {
      a.disegna();
    }
  }

  public List<Albero> getAlberi() {
    return alberi;
  }
}
```

**FlyweightMain.java** (Main)<br>
L’output di esecuzione sarà qualcosa tipo:
- Disegno albero di tipo Quercia in posizione [0, 0] colore=Verde texture=Ruvida
- Disegno albero di tipo Quercia in posizione [5, 10] colore=Verde texture=Ruvida
- Disegno albero di tipo Acero in posizione [3, 12] colore=Rosso texture=Liscia

```java
public class FlyweightMain {
  static void main() {
    FlyweightFactory factory = new FlyweightFactory();

    Foresta foresta = new Foresta(factory);
    // Pianta alberi con testo in italiano
    foresta.inserisciAlbero(0, 0, "Quercia", "Verde", "Ruvida");
    foresta.inserisciAlbero(5, 10, "Quercia", "Verde", "Ruvida"); // condiviso
    foresta.inserisciAlbero(3, 12, "Acero", "Rosso", "Liscia");

    foresta.disegna();
  }
}
```


----

## Test

```java

```
