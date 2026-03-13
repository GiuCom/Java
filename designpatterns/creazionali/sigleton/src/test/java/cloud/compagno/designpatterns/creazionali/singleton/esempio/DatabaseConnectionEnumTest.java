package cloud.compagno.designpatterns.creazionali.singleton.esempio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionEnumTest {

    @Test
    void testEnumSingletonIdentity() {
        // Accediamo all'istanza direttamente tramite il nome della costante
        DatabaseConnectionEnum instance1 = DatabaseConnectionEnum.INSTANCE;
        DatabaseConnectionEnum instance2 = DatabaseConnectionEnum.INSTANCE;

        // Verifica identità referenziale
        assertSame(instance1, instance2, "L'Enum deve restituire sempre la stessa istanza");
    }

    @Test
    void testEnumBehavior() {
        // Possiamo chiamare i metodi normalmente
        DatabaseConnectionEnum.INSTANCE.executeQuery("SELECT * FROM ordini");
        assertNotNull(DatabaseConnectionEnum.INSTANCE);
    }

    @Test
    @DisplayName("Verifica che l'Enum Singleton sia Thread-Safe")
    void testSingletonMultithread() throws InterruptedException {
        int numeroThread = 50;
        ExecutorService service = Executors.newFixedThreadPool(numeroThread);

        // Usiamo un Set thread-safe per memorizzare le istanze ottenute dai vari thread
        Set<DatabaseConnectionEnum> istanzeOttenute = Collections.newSetFromMap(new ConcurrentHashMap<>());

        // Lanciamo 50 thread contemporaneamente
        for (int i = 0; i < numeroThread; i++) {
            service.execute(() -> {
                DatabaseConnectionEnum instance = DatabaseConnectionEnum.INSTANCE;
                istanzeOttenute.add(instance);
            });
        }

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);

        // Se il pattern funziona, il Set deve contenere esattamente 1 elemento
        assertEquals(1, istanzeOttenute.size(),
                "Il Set dovrebbe contenere solo una istanza, ma ne sono state trovate: " + istanzeOttenute.size());

        // Verifichiamo che l'elemento sia proprio la nostra istanza
        assertTrue(istanzeOttenute.contains(DatabaseConnectionEnum.INSTANCE));
    }
}
