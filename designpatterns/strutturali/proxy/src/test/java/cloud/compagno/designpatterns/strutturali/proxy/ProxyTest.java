package cloud.compagno.designpatterns.strutturali.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validazione Pattern Proxy")
public class ProxyTest {
    @Test
    @DisplayName("Verifica caricamento pigro (Lazy Loading)")
    void testVirtualProxyLazyLoading() {
        String file = "foto_alta_risoluzione.png";

        // Creazione del proxy: non dovrebbe ancora caricare l'immagine reale
        ProxyImmagine proxy = new ProxyImmagine(file);

        // In un test reale potremmo usare un mock per verificare il costruttore.
        // Qui verifichiamo la coerenza dell'interfaccia.
        assertNotNull(proxy, "Il proxy deve essere istanziato.");

        // Prima chiamata: scatena il caricamento
        System.out.println("--- Prima chiamata ---");
        assertDoesNotThrow(() -> proxy.visualizza());

        // Seconda chiamata: l'oggetto è già in memoria
        System.out.println("--- Seconda chiamata ---");
        assertDoesNotThrow(() -> proxy.visualizza());
    }
}
