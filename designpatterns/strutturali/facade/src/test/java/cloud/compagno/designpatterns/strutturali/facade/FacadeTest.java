package cloud.compagno.designpatterns.strutturali.facade;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {
    private HomeTheater facade;

    @BeforeEach
    void init() {
        facade = new HomeTheater(
                new Lights(),
                new Projector(),
                new SoundSystem(),
                new StreamingService()
        );
    }

    @Test
    @DisplayName("Il processo watchMovie deve completarsi senza eccezioni")
    void testWatchMovieSuccess() {
        assertDoesNotThrow(() -> facade.watchMovie("Interstellar"),
                "La facciata dovrebbe coordinare i sottosistemi senza errori.");
    }

    @Test
    @DisplayName("Verifica gestione dei tipi tramite Facade")
    void testStreamingTypeHandling() {
        StreamingService service = new StreamingService();
        // Test del pattern matching interno al sottosistema
        assertDoesNotThrow(() -> service.startStream("Titolo Stringa"));
        assertThrows(IllegalArgumentException.class, () -> service.startStream(null));
    }
}
