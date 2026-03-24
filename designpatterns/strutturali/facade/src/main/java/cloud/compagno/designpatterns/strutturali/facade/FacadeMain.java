package cloud.compagno.designpatterns.strutturali.facade;

/**
 * La classe Main rappresenta il 'Client' nel pattern Facade.
 * Dimostra come un'operazione complessa possa essere eseguita
 * senza conoscere i dettagli dei singoli sottosistemi.
 */
public class FacadeMain {
    static void main() {
        // 1. Inizializzazione dei componenti del sottosistema
        // In un'app reale, questi potrebbero essere iniettati tramite Dependency Injection
        var lights = new Lights();
        var projector = new Projector();
        var sound = new SoundSystem();
        var streaming = new StreamingService();

        // 2. Creazione della Facciata
        // Passiamo i riferimenti dei sottosistemi alla facciata
        HomeTheater homeTheater = new HomeTheater(lights, projector, sound, streaming);

        System.out.println("--- INIZIO SESSIONE UTENTE ---");

        // 3. Utilizzo semplificato
        // L'utente non sa che deve accendere il proiettore, abbassare le luci, ecc.
        // Chiama solo il metodo 'intuitivo' fornito dalla Facciata.
        homeTheater.watchMovie("Leon");

        System.out.println("... Due ore dopo ...\n");

        // 4. Spegnimento coordinato
        homeTheater.stopMovie();

        System.out.println("--- FINE SESSIONE UTENTE ---");
    }
}
