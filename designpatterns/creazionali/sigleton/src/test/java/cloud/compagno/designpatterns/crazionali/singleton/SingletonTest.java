package cloud.compagno.designpatterns.crazionali.singleton;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        assertNotEquals(testoPrimaDellaModifica, instance1.getInfo(), "Testo modificato");
        assertEquals(nuovoMessaggio, instance1.getInfo(), "Testo modificato nella prima istanza");


        Singleton instance2 = Singleton.getInstance();
        assertNotNull(instance2, "La seconda istanza non è null");

        assertEquals(nuovoMessaggio, instance2.getInfo(), "La modifica testo effettuata sulla prima istanza si riflette sulla seconda");
    }

    // Singleton Eager
    @Test
    void testSingletonEagerInstanceIsSame() {
        // 1. Ottieni due riferimenti chiamando getInstance()
        SingletonEager instance1 = SingletonEager.getInstance();
        SingletonEager instance2 = SingletonEager.getInstance();

        // 2. Verifica che l'istanza non sia null
        assertNotNull(instance1, "L'istanza non dovrebbe essere null");

        // 3. Verifica che entrambi i riferimenti puntino allo STESSO oggetto
        assertSame(instance1, instance2, "Entrambi i riferimenti devono puntare alla stessa istanza");
    }

    // Singleton Synchronized
    @Test
    void testSingletonSynchronizedMultithread() throws InterruptedException {

        // Numero di thread
        int threadCount = 1000;

        // Semplifica la gestione dell'esecuzione di task in background
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // Utilizziamo un Set thread-safe per memorizzare le istanze uniche trovate
        Set<Integer> instanceHashCodes = Collections.newSetFromMap(new ConcurrentHashMap<>());

        // Il latch serve a far partire i thread contemporaneamente
        CountDownLatch startLatch = new CountDownLatch(1);
        // Il latch di fine serve ad attendere che tutti i thread abbiano finito
        CountDownLatch finishLatch = new CountDownLatch(threadCount);

        // Ciclo di thread
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    startLatch.await(); // Attende il segnale di partenza
                    SingletonSynchronized instance = SingletonSynchronized.getInstance();
                    instanceHashCodes.add(System.identityHashCode(instance));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown();
                }
            });
        }

        startLatch.countDown(); // Segnale di partenza per tutti i thread
        finishLatch.await();    // Attende il completamento
        executor.shutdown();

        // Verifica che nel set ci sia esattamente 1 solo hashcode (una sola istanza)
        assertEquals(1, instanceHashCodes.size(),
                "Esiste una sola istanza anche con accesso concorrente");
    }


    // Singleton DCL
    @Test
    public void testSingletonDCLMultithread() throws InterruptedException {
        int threadCount = 1000;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        Set<SingletonDCL> instances = Collections.newSetFromMap(new ConcurrentHashMap<>());

        // Sincronizzatore per far partire tutti i thread insieme
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            service.submit(() -> {
                try {
                    startLatch.await(); // Attende il via libera
                    instances.add(SingletonDCL.getInstance());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown();
                }
            });
        }

        startLatch.countDown(); // "Via!" ai thread
        finishLatch.await();    // Attende la fine di tutti i thread
        service.shutdown();

        assertEquals(1, instances.size(), "Il Singleton ha creato più di un'istanza!");
    }

    @Test
    void testSingletonEagerMultithread() throws InterruptedException {

        // Numero di thread
        int threadCount = 1000;

        // Semplifica la gestione dell'esecuzione di task in background
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // Utilizziamo un Set thread-safe per memorizzare le istanze uniche trovate
        Set<Integer> instanceHashCodes = Collections.newSetFromMap(new ConcurrentHashMap<>());

        // Il latch serve a far partire i thread contemporaneamente
        CountDownLatch startLatch = new CountDownLatch(1);
        // Il latch di fine serve ad attendere che tutti i thread abbiano finito
        CountDownLatch finishLatch = new CountDownLatch(threadCount);

        // Ciclo di thread
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    startLatch.await(); // Attende il segnale di partenza
                    SingletonEager instance = SingletonEager.getInstance();
                    instanceHashCodes.add(System.identityHashCode(instance));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown();
                }
            });
        }

        startLatch.countDown(); // Segnale di partenza per tutti i thread
        finishLatch.await();    // Attende il completamento
        executor.shutdown();

        // Verifica che nel set ci sia esattamente 1 solo hashcode (una sola istanza)
        assertEquals(1, instanceHashCodes.size(),
                "Esiste una sola istanza anche con accesso concorrente");
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
