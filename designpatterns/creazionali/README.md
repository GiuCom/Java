<h1 style="text-align: center;">Design Patterns</h1>
<h2 style="text-align: center;">Creazionali</h2>
<hr>

[![Static Badge](https://img.shields.io/badge/Java_version-25-blue)](https://openjdk.org/projects/jdk/25/)
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GiuCom/Design_Patterns/blob/main/LICENSE)<br/>
<br/>

## 🚀 Introduzione
<p style="text-align: justify;">
Nel paradigma della programmazione orientata agli oggetti (OOP), i **Design Pattern Creazionali** sono soluzioni architetturali che affrontano i meccanismi di creazione degli oggetti. Il loro scopo principale è rendere un sistema indipendente dalle modalità con cui i suoi oggetti vengono creati, composti e rappresentati.
Spesso, l'uso diretto dell'operatore new (hard-coding) rende il codice rigido e difficile da testare. I pattern creazionali risolvono questo problema incapsulando la conoscenza delle classi concrete e nascondendo i dettagli della creazione.
I pattern creazionali si dividono in due sottocategorie:

* **Object-creational patterns:** Gestiscono la creazione delegandola a un altro oggetto.
* **Class-creational patterns:** Gestiscono la creazione delegandola alle sottoclassi.
   
Essi hanno come obbiettivo:

* **Astrazione della classe concreta:** Il client conosce solo l'interfaccia, non la classe specifica. 
* **Isolamento delle complessità:** Nascondere i dettagli di inizializzazione di oggetti complessi.
* **Controllo delle istanze:** Gestire quante istanze vengono create (es. Singleton).
</p>

| **Pattern**              | **Focus Principale**        | **Differenza Chiave**                                                              |
|:-------------------------|:----------------------------|:-----------------------------------------------------------------------------------|
| Singleton                | Istanza univoca             | Non si occupa di "come" creare, ma di "quante" istanze possono esistere (una sola).|
| Factory Method           | Metodo singolo              | La creazione avviene tramite ereditarietà.                                         |
| Abstract Factory         | Famiglie di oggetti         | La creazione avviene tramite composizione di oggetti.                              |
| Builder                  | Processo di costruzione     | Si focalizza sulla complessità della creazione dell'oggetto.                       |
| Prototype                | Clonazione                  | Evita del tutto l'inizializzazione standard.                                       |

<p style="text-align: justify;">
L'adozione dei pattern creazionali è fondamentale per garantire la scalabilità e la manutenibilità del software. Sebbene introducano una maggiore astrazione e, inizialmente, una maggiore quantità di classi, il ritorno sull'investimento si manifesta nella facilità con cui il sistema può evolvere e integrare nuovi requisiti senza richiedere refactoring massivi del codice esistente.
</p>