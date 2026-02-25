package cloud.compagno.designpatterns.crazionali.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonBillPughTest {
    @Test
    @DisplayName("Dovrebbe restituire sempre la stessa istanza")
    void testSingletonInstance() {
        SingletonBillPugh instance1 = SingletonBillPugh.getInstance();
        SingletonBillPugh instance2 = SingletonBillPugh.getInstance();

        // Verifica che i due riferimenti puntino allo stesso oggetto
        assertSame(instance1, instance2, "Le istanze dovrebbero essere identiche");

        // Verifica un'uguaglianza funzionale aggiuntiva
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    @Test
    @DisplayName("Dovrebbe restituire la stringa di connessione corretta")
    void testGetConnectionString() {
        String conn = SingletonBillPugh.getInstance().getConnectionString();
        assertNotNull(conn);
        assertTrue(conn.contains("localhost"));
    }
}
