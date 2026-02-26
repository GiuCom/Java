<h1 style="text-align: center;">Design Patterns</h1>
<h2 style="text-align: center;">Comportamentali</h2>
<hr>

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br/>
<br/>

## 🚀 Introduzione
<p style="text-align: justify;">
Mentre i pattern creazionali si occupano di come viene creato un oggetto e quelli strutturali di come gli oggetti sono composti, i <b>Design Pattern Comportamentali</b> si concentrano sugli algoritmi e sull'assegnazione di responsabilità tra gli oggetti. Questi pattern descrivono non solo i modelli di oggetti o classi, ma anche gli schemi di comunicazione tra di essi.
Il loro obiettivo primario è ridurre l'accoppiamento (coupling) tra gli oggetti, permettendo al contempo una gestione fluida e scalabile del flusso di controllo.
I pattern comportamentali si dividono in due sottocategorie:

* **Livello di Classe:** Usano l'ereditarietà per distribuire il comportamento tra le classi (es. Template Method).
* **Livello di Oggetto:** Usano la composizione e la delega per permettere a gruppi di oggetti di collaborare (es. Strategy, Observer).
   
Essi hanno come obbiettivo:

* **Flessibilità algoritmica:** Cambiare il comportamento di un sistema a runtime.
* **Disaccoppiameto Mittente-Ricevente:** Inviare richieste senza conoscere chi le gestirà.
* **Gestione dello Stato:** Reagire in modo diverso in base allo stato interno dell'oggetto.
</p>

| **Pattern**                 | **Focus Principale**             | **Differenza Chiave**                                                              |
|:----------------------------|:---------------------------------|:-----------------------------------------------------------------------------------|
| **Strategy**                | Algoritmi intercambiabili        | Il client sceglie attivamente quale "strategia" usare.                             |
| **State**                   | Comportamento basato sullo stato | Il comportamento cambia automaticamente al variare dello stato interno.            |
| **Observer**                | Notifica di eventi               | Gestisce la sincronizzazione tra un soggetto e molti dipendenti.                   |
| **Command**                 | Richiesta come oggetto           | Trasforma un'azione in un dato che può essere memorizzato o trasferito.            |
| **Template Method**         | Struttura dell'algoritmo         | Definisce i passi fissi in una superclasse, delegando i dettagli alle sottoclassi. |
| **Chain of Responsibility** | Delega della gestione            | Non c'è la garanzia che la richiesta venga gestita (passa lungo la catena).        |

<p style="text-align: justify;">
I pattern comportamentali sono essenziali per gestire la logica di business in modo dinamico. Mentre i pattern strutturali "disegnano" l'architettura, quelli comportamentali "animano" il software, rendendolo reattivo e facile da estendere senza dover riscrivere il flusso di controllo principale.
</p>