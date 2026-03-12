package cloud.compagno.designpatterns.creazionali.abstractfactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AbstractFactoryMain {
    /**
     * Il metodo main funge da configuratore iniziale.
     * Decide quale Factory usare e la "inietta" nel Client.
     */
     static void main() {
        Application app;
        GUIFactory factory;

        // 1. Logica di configurazione (Simuliamo la lettura del SO)
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Sistema rilevato: " + osName);

        if (osName.contains("win")) {
            factory = new WindowsFactory();
        } else {
            // Default per altri sistemi (es. Mac o Linux)
            factory = new MacFactory();
        }

        // 2. Inizializzazione del Client (Application)
        // Il Client non sa QUALE factory sta usando, sa solo che implementa GUIFactory
        app = new Application(factory);

        // 3. Esecuzione del Client
        System.out.println("--- Avvio Interfaccia Grafica ---");
        app.render();
    }
}
