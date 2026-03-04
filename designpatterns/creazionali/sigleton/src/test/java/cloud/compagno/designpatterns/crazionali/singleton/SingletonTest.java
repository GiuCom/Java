package cloud.compagno.designpatterns.crazionali.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SingletonTest {

    // Singleton
    @Test
    void testSingletonIdentity() {
        // Verifica che due chiamate restituiscano lo stesso riferimento di memoria
        Singleton instance1 = Singleton.getInstance();
        assertNotNull(instance1, "La prima istanza non è null");

        Singleton instance2 = Singleton.getInstance();
        assertNotNull(instance2, "La seconda istanza non è null");

        assertSame(instance1, instance2, "Le due istanze sono identiche (stesso riferimento)");
    }

    @Test
    void testSingletonStateConsistency() {
        Singleton instance1 = Singleton.getInstance();
        assertNotNull(instance1, "La prima istanza non è null");
        String testoPrimaDellaModifica =  instance1.getInfo();
        String nuovoMessaggio = "Modifica testo";
        instance1.setInfo(nuovoMessaggio);
        assertEquals(nuovoMessaggio, instance1.getInfo(), "Testo modificato nella prima istanza");


        Singleton instance2 = Singleton.getInstance();
        assertNotNull(instance2, "La seconda istanza non è null");

        assertEquals(nuovoMessaggio, instance2.getInfo(), "La modifica testo effettuata sulla prima istanza si riflette sulla seconda");
    }

//
//    @Test
//    @DisplayName("Dovrebbe restituire sempre la stessa istanza")
//    void testSingletonInstance() {
//        SingletonBillPugh instance1 = SingletonBillPugh.getInstance();
//        SingletonBillPugh instance2 = SingletonBillPugh.getInstance();
//
//        // Verifica che i due riferimenti puntino allo stesso oggetto
//        assertSame(instance1, instance2, "Le istanze dovrebbero essere identiche");
//
//        // Verifica un'uguaglianza funzionale aggiuntiva
//        assertEquals(instance1.hashCode(), instance2.hashCode());
//    }
//
//    @Test
//    @DisplayName("Dovrebbe restituire la stringa di connessione corretta")
//    void testGetConnectionString() {
//        String conn = SingletonBillPugh.getInstance().getStringaConnection();
//        assertNotNull(conn);
//        assertTrue(conn.contains("localhost"));
//    }

}
