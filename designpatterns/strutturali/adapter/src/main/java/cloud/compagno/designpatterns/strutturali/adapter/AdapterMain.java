package cloud.compagno.designpatterns.strutturali.adapter;

public class AdapterMain {
    static void main() {
        System.out.println("=== AVVIO SISTEMA MONITORAGGIO METEO ===");

        // 1. Abbiamo il componente legacy (che non parla Celsius)
        VecchioTermometroFahrenheit vecchioHardware = new VecchioTermometroFahrenheit();

        // 2. Creiamo l'Adattatore passandogli il vecchio hardware
        // Nota: Il tipo della variabile è l'interfaccia MODERNA (SensoreMeteo)
        SensoreMeteo sensoreModerno = new AdattatoreTermometro(vecchioHardware);

        // 3. Utilizziamo il sensore come se fosse nativamente Celsius
        // Il Client chiama 'getTemperaturaCelsius()' e non sa nulla di Fahrenheit
        double temperaturaCelsius = sensoreModerno.getTemperaturaCelsius();

        // 4. Visualizzazione del risultato
        System.out.println("Lettura dal vecchio termometro (Fahrenheit): 86.0 F");
        System.out.println("Conversione tramite Adattatore (Celsius): " + temperaturaCelsius + " C");

        // 5. Verifica logica
        if (temperaturaCelsius == 30.0) {
            System.out.println("RISULTATO: Il pattern Adapter ha funzionato correttamente!");
        } else {
            System.out.println("RISULTATO: Errore nella conversione.");
        }
    }
}
