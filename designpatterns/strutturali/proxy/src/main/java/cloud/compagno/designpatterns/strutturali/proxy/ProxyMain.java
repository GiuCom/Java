package cloud.compagno.designpatterns.strutturali.proxy;

/**
 * Classe Main di esempio per il pattern Proxy.
 * Dimostra il caricamento pigro (Lazy Loading) di un oggetto pesante.
 */
public class ProxyMain {
    static void main() {
        // Creiamo il Proxy invece dell'oggetto reale.
        // In questo momento, l'immagine "pesante" NON è ancora caricata in memoria.
        Immagine immagine = new ProxyImmagine("progetto_architettonico_4K.png");

        System.out.println("--- Stato: Proxy creato, oggetto reale non ancora istanziato ---");

        // Prima chiamata: il Proxy si accorge che l'oggetto reale manca,
        // lo crea (caricamento pesante) e poi delega la visualizzazione.
        System.out.println("\n[Esecuzione] Richiesta di visualizzazione n. 1:");
        immagine.visualizza();

        // Seconda chiamata: il Proxy ha già il riferimento all'oggetto reale,
        // quindi non esegue più il caricamento ma delega direttamente.
        System.out.println("\n[Esecuzione] Richiesta di visualizzazione n. 2:");
        immagine.visualizza();

        System.out.println("\n--- Operazione completata ---");
    }
}
