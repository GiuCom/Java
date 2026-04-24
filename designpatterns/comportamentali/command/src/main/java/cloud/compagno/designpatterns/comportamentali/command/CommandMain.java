package cloud.compagno.designpatterns.comportamentali.command;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CommandMain {
    static void main() {
        // 1. Inizializzazione del Ricevitore (Receiver)
        // Il condizionatore contiene la logica di business reale
        Condizionatore ariaCondizionata = new Condizionatore();

        // 2. Inizializzazione dell'Invocatore (Invoker)
        // Il telecomando gestisce l'invio dei comandi e la cronologia per l'undo
        Telecomando telecomando = new Telecomando();

        System.out.println("--- Inizio Operazioni Domotiche ---");
        System.out.println("Stato iniziale: " + ariaCondizionata.getTemperatura() + "°C");

        // 3. Creazione e invio del primo comando
        // Passiamo la temperatura corrente (22) come 'vecchiaTemp' per permettere il ripristino
        Comando impostaEstate = new ComandoTemperatura(
                ariaCondizionata,
                18,
                ariaCondizionata.getTemperatura()
        );

        System.out.println("\nEsecuzione: Impostazione modalità estate...");
        telecomando.inviaPressione(impostaEstate);

        // 4. Creazione e invio del secondo comando
        Comando impostaNotte = new ComandoTemperatura(
                ariaCondizionata,
                24,
                ariaCondizionata.getTemperatura()
        );

        System.out.println("\nEsecuzione: Impostazione modalità notte...");
        telecomando.inviaPressione(impostaNotte);

        // 5. Test della funzionalità Undo (Annulla)
        System.out.println("\n--- Test Funzione Annulla (Undo) ---");

        System.out.println("Annullamento ultimo comando (Notte -> Estate)...");
        telecomando.premiAnnulla();
        System.out.println("Temperatura attuale: " + ariaCondizionata.getTemperatura() + "°C");

        System.out.println("\nAnnullamento comando precedente (Estate -> Iniziale)...");
        telecomando.premiAnnulla();
        System.out.println("Temperatura attuale: " + ariaCondizionata.getTemperatura() + "°C");

        System.out.println("\nTentativo di annullamento extra...");
        telecomando.premiAnnulla(); // Questo testerà la modifica "isEmpty" appena fatta

        System.out.println("\n--- Fine Simulazione ---");
    }
}
