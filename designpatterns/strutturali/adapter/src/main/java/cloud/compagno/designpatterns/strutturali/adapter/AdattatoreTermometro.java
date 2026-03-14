package cloud.compagno.designpatterns.strutturali.adapter;

/**
 * L'Adattatore implementa l'interfaccia moderna 'SensoreMeteo'.
 * All'interno contiene un riferimento al vecchio termometro.
 */
public class AdattatoreTermometro implements SensoreMeteo {
    private final VecchioTermometroFahrenheit vecchioTermometro;

    public AdattatoreTermometro(VecchioTermometroFahrenheit vecchioTermometro) {
        this.vecchioTermometro = vecchioTermometro;
    }

    @Override
    public double getTemperaturaCelsius() {
        // 1. Ottiene il dato nel vecchio formato
        double fahrenheit = vecchioTermometro.letturaInFahrenheit();

        // 2. Esegue la logica di conversione (Formula: (F - 32) * 5/9)
        double celsius = (fahrenheit - 32) * 5 / 9;

        // 3. Restituisce il dato convertito al sistema moderno
        return celsius;
    }
}
