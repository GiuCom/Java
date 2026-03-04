package cloud.compagno.designpatterns.crazionali.singleton;

public class SingletonDCL {

    /* Dichiarazione di una variabile SingletonDCL */
    private static SingletonDCL INSTANCE = null;

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonDCL() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static */
    public static SingletonDCL getInstance() {
        // Primo controllo (senza lock)
        if (INSTANCE == null) {
            synchronized (SingletonDCL.class) {
                // Secondo controllo (con lock)
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDCL();
                }
            }
        }
        return INSTANCE;
    }

    // Setter & Getter
    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }
}
