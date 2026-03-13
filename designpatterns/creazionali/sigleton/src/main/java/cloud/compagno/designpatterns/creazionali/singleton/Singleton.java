package cloud.compagno.designpatterns.creazionali.singleton;

public class Singleton {

    /* Dichiarazione di una variabile Singleton */
    private static Singleton INSTANCE = null;

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private Singleton() {
        info = "Oggetto inizializzato";
    }

    /* Metodo static */
    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
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
