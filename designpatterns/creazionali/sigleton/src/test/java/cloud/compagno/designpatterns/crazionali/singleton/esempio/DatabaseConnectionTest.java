package cloud.compagno.designpatterns.crazionali.singleton.esempio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class DatabaseConnectionTest {

    @Test
    @DisplayName("Verifica che più chiamate restituiscano la stessa istanza")
    void testSingletonInstanceIdentity() {
        // Richiediamo l'istanza due volte
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        // Verifichiamo che non siano nulli
        assertNotNull(instance1, "L'istanza 1 non dovrebbe essere null");
        assertNotNull(instance2, "L'istanza 2 non dovrebbe essere null");

        // assertSame controlla se i due riferimenti puntano allo STESSO oggetto (==)
        assertSame(instance1, instance2, "Le due istanze dovrebbero essere identiche (stesso riferimento)");
    }

    @Test
    @DisplayName("Verifica la robustezza del Singleton in un ambiente multi-thread")
    void testSingletonMultiThread() throws InterruptedException {
        // Creiamo due thread che cercano di ottenere l'istanza contemporaneamente
        final DatabaseConnection[] results = new DatabaseConnection[2];

        Thread t1 = new Thread(() -> results[0] = DatabaseConnection.getInstance());
        Thread t2 = new Thread(() -> results[1] = DatabaseConnection.getInstance());

        t1.start();
        t2.start();

        // Attendiamo che entrambi finiscano
        t1.join();
        t2.join();

        // Anche in condizioni di concorrenza, l'oggetto deve essere unico
        assertSame(results[0], results[1], "Thread diversi dovrebbero ricevere la stessa istanza");
    }
}