## [Design Patterns](../..)
### Strutturali

----

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br>
<br>

## 🚀 Introduzione
<p style="text-align: justify;">
I <b>Design Pattern Strutturali</b> si occupano della composizione di classi e oggetti. Il loro obiettivo principale è facilitare la progettazione del sistema identificando modi semplici per realizzare relazioni tra entità diverse.
Mentre i pattern creazionali gestiscono la nascita degli oggetti e quelli comportamentali la loro comunicazione, i pattern strutturali si focalizzano su come le classi e gli oggetti vengono <b>assemblati</b> per formare strutture più grandi e complesse, garantendo che tali strutture rimangano flessibili ed efficienti.
I pattern comportamentali si dividono in due sottocategorie:

* **Pattern Strutturali di Classe:** Usano l'ereditarietà per comporre interfacce o implementazioni (es. Adapter di classe).
* **Pattern Strutturali di Oggetti:** Usano la composizione di oggetti per realizzare nuove funzionalità a runtime.
   
Essi hanno come obbiettivo:

* **Compatibilità:** Far collaborare interfacce diverse.
* **Riduzione della complessità:** Fornire viste semplificate di sistemi complessi.
* **Estensibilità:** Aggiungere responsabilità agli oggetti senza alterare il codice originale.
</p>

| **Pattern**   | **Focus Principale** | **Differenza Chiave**                                              |
|:--------------|:---------------------|:-------------------------------------------------------------------|
| **Adapter**   | Compatibilità        | Cambia l'interfaccia di un oggetto esistente.                      |
| **Bridge**    | Architettura         | Separa l'astrazione dall'implementazione a priori.                 |
| **Composite** | Gerarchia            | Tratta oggetti singoli e gruppi nello stesso modo.                 |
| **Decorator** | Estensione           | Aggiunge responsabilità senza cambiare l'interfaccia.              |
| **Facade**    | Semplicità           | Fornisce una porta d'ingresso semplificata a un sistema complesso. |
| **Flyweight** | Efficienza           | Ottimizza la memoria condividendo lo stato comune.                 |
| **Proxy**     | Controllo            | Gestisce l'accesso all'oggetto reale (ne è un delegato).           |

<p style="text-align: justify;">
I pattern strutturali permettono di costruire sistemi software robusti ed eleganti, evitando il rischio di creare "monoliti" rigidi. Grazie a questi modelli, è possibile far evolvere componenti indipendenti e integrarli in architetture coerenti, riducendo drasticamente il debito tecnico legato a gerarchie di ereditarietà troppo profonde o interfacce incompatibili.
</p>