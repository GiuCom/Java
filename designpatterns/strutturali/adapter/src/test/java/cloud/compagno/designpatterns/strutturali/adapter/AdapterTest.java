package cloud.compagno.designpatterns.strutturali.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {
    @Test
    public void testConversioneTemperatura() {
        // PASSAGGIO 1: Creazione del componente incompatibile (Adaptee)
        // Immaginiamo che il vecchio termometro segni 86°F
        VecchioTermometroFahrenheit vecchioTermometro = new VecchioTermometroFahrenheit();

        // PASSAGGIO 2: Creazione dell'Adattatore (Adapter)
        // Passiamo il vecchio termometro all'adattatore
        SensoreMeteo adattatore = new AdattatoreTermometro(vecchioTermometro);

        // PASSAGGIO 3: Esecuzione del test (Il Client usa il Target)
        // Chiediamo la temperatura in Celsius. 86°F corrispondono a 30°C.
        double temperaturaOttenuta = adattatore.getTemperaturaCelsius();
        double temperaturaAttesa = 30.0;

        // PASSAGGIO 4: Verifica (Assertion)
        // Verifichiamo che il calcolo sia corretto (con una tolleranza minima)
        assertEquals(temperaturaAttesa, temperaturaOttenuta, 0.001,
                "L'adattatore dovrebbe convertire correttamente 86°F in 30°C");
    }
}
