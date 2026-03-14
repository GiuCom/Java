package cloud.compagno.designpatterns.strutturali.adapter;

/**
 * Classe legacy che non possiamo modificare.
 * Fornisce la temperatura in gradi Fahrenheit.
 */
public class VecchioTermometroFahrenheit {

    public double letturaInFahrenheit() {
        // Simula una lettura da un vecchio hardware
        return 86.0;
    }
}