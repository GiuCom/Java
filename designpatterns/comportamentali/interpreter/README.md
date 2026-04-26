## [Design Patterns](../..)
### [Comportamentali](..)
# Interpreter

----

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br>
<br>

## 🚀 Introduzione
Il pattern **Interpreter** è un design pattern comportamentale che definisce una rappresentazione per la grammatica di un linguaggio e un interprete che utilizza tale rappresentazione per interpretare frasi nel linguaggio stesso.
<br>Il pattern mappa ogni regola grammaticale in una classe, permettendo di valutare espressioni complesse (strutturate come alberi sintattici) attraverso il meccanismo della ricorsione.

## 🏭 Caratteristiche
La caratteristica distintiva del pattern **Interpreter** è la sua capacità di trasformare una grammatica formale in una gerarchia di classi, permettendo di valutare espressioni complesse trattandole come un Albero Sintattico Astratto (AST).
<br>Le sue proprietà fondamentali sono:
1. **Struttura Ricorsiva (Composizione)**<br>
   Il pattern si basa pesantemente sul concetto di ricorsione. Le espressioni "Non-Terminali" (come la Somma) non calcolano direttamente un risultato, ma delegano il calcolo ai propri figli, i quali possono essere altre operazioni o valori atomici (Terminali).
2. **Mappatura 1:1 tra Grammatica e Codice**<br>
   Ogni regola della grammatica (es. <numero>, <somma>, <variabile>) corrisponde esattamente a una classe Java. Questo rende il pattern estremamente leggibile per chi conosce la grammatica del linguaggio che si sta implementando.
3. **Utilizzo del "Context" (Contesto)**<br>
   A differenza di altri pattern, l'Interpreter richiede quasi sempre un oggetto Context che attraversa l'intero albero durante la valutazione. Questo oggetto funge da memoria condivisa (per salvare i valori delle variabili o lo stato globale), permettendo di risolvere simboli che altrimenti non avrebbero valore.
4. **Estensibilità Grammaticale**<br>
   È conforme al principio Open/Closed: se vuoi aggiungere una nuova operazione (ad esempio la Moltiplicazione), non devi modificare le classi esistenti. Ti basta creare una nuova classe che implementa l'interfaccia Espressione.

<br>Il pattern si basa sulla scomposizione di un linguaggio in simboli terminali e non terminali:
1. **AbstractExpression (Interfaccia):**<br> Dichiara il metodo astratto interpreta(Context). Ogni nodo dell'albero sintattico deve implementare questa interfaccia.
2. **TerminalExpression (Espressione Terminale):**<br> Implementa l'interpretazione per i simboli elementari della grammatica (es. un numero o una variabile). È la "foglia" dell'albero.
3. **NonTerminalExpression (Espressione Non Terminale):**<br> Rappresenta le regole grammaticali composte (es. addizione, sottrazione). Contiene riferimenti ad altre AbstractExpression e combina i loro risultati.
4. **Context (Contesto):**<br> Contiene le informazioni globali all'interprete, come i valori delle variabili (spesso implementato tramite una Map).
5. **Client:**<br> Costruisce l'Albero Sintattico Astratto (AST) e invoca l'interpretazione sulla radice.

<br>In UML, è rappresentato:

<p align="center">
  <img alt="Interpreter schema UML" title="Interpreter schema UML" src="../../../Appunti/img/DesignPatterns_UML_Interpreter.png" style="width: 75%; height: 75%;"><br/>
</p>

-----

### ESEMPIO


**xxx.java** (xxxx) [Interfaccia]<br>

```java

```


Il pattern **Interpreter** 

**Pro (Vantaggi)**

**Contro (Svantaggi)**

**Quando usarlo**

----

## Test


```java

```
