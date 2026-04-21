package cloud.compagno.designpatterns.comportamentali.chainofresponsibility;

public class ChainOfResponsibilityMain {
    static void main() {

        // 1. Inizializzazione dei componenti della catena
        SupportoBase supportoBase = new SupportoBase();
        SupportoAvanzato supportoAvanzato = new SupportoAvanzato();

        // 2. Configurazione della struttura della catena (Base -> Avanzato)
        supportoBase.setSuccessivo(supportoAvanzato);

        // 3. Creazione di diverse tipologie di richieste
        RichiestaSupporto richiestaSemplice = new RichiestaSupporto("Cambio password utente", 1);
        RichiestaSupporto richiestaCritica = new RichiestaSupporto("Ripristino database corrotto", 5);
        RichiestaSupporto richiestaInformativa = new RichiestaSupporto("Richiesta orari ufficio", 1);

        // 4. Invio delle richieste alla catena
        System.out.println("--- Inizio Elaborazione Richieste ---");

        System.out.println("\nEsecuzione Richiesta 1:");
        supportoBase.gestisci(richiestaSemplice);

        System.out.println("\nEsecuzione Richiesta 2:");
        supportoBase.gestisci(richiestaCritica);

        System.out.println("\nEsecuzione Richiesta 3:");
        supportoBase.gestisci(richiestaInformativa);

        System.out.println("\n--- Fine Elaborazione ---");
    }
}
