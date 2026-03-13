package cloud.compagno.designpatterns.creazionali.singleton;

public class SingletonSynchronized {

    /* Dichiarazione di una variabile SingletonSynchronized */
    private static SingletonSynchronized INSTANCE = null;

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonSynchronized() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static e synchronized */
    public static synchronized SingletonSynchronized getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonSynchronized();
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
