package cloud.compagno.designpatterns.crazionali.singleton;

public class SingletonEager {

    /* Dichiarazione di una variabile SingletonEager */
    private static final SingletonEager INSTANCE = new SingletonEager();

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonEager() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static */
    public static SingletonEager getInstance() {
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
