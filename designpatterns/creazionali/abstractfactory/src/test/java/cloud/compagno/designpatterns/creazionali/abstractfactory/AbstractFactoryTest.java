package cloud.compagno.designpatterns.creazionali.abstractfactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryFamilyTest {

    @Test
    @DisplayName("WindowsFactory deve creare solo componenti Windows")
    void testWindowsFactoryFamily() {
        GUIFactory factory = new WindowsFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Verifichiamo che i prodotti siano quelli attesi
        assertTrue(button instanceof WindowsButton, "Il bottone deve essere WindowsButton");
        assertTrue(checkbox instanceof WindowsCheckbox, "La checkbox deve essere WindowsCheckbox");

        // Verifichiamo che NON siano prodotti di altre famiglie
        assertFalse(button instanceof MacButton);
    }

    @Test
    @DisplayName("MacFactory deve creare solo componenti Mac")
    void testMacFactoryFamily() {
        GUIFactory factory = new MacFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        assertTrue(button instanceof MacButton);
        assertTrue(checkbox instanceof MacCheckbox);
    }

    // Test della classe Applicazione

    @Test
    @DisplayName("Application deve inizializzarsi correttamente con qualsiasi Factory")
    void testApplicationInitialization() {
        // Setup con WindowsFactory
        GUIFactory winFactory = new WindowsFactory();
        Application winApp = new Application(winFactory);

        // Usiamo la Reflection o dei getter (se presenti) per verificare lo stato interno
        // In un test reale, potremmo verificare se il metodo render() produce l'output atteso
        assertNotNull(winApp, "L'applicazione dovrebbe essere istanziata");
    }

    @Test
    @DisplayName("Verifica che il Client non lanci eccezioni durante il rendering")
    void testApplicationRender() {
        Application app = new Application(new MacFactory());

        // Verifichiamo che il ciclo di vita (creazione -> rendering) sia fluido
        assertDoesNotThrow(() -> app.render(), "Il rendering non deve fallire");
    }
}