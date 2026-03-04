package cloud.compagno.designpatterns.crazionali.singleton;

// Bill Pugh Singleton
// garantisce il caricamento pigro (lazy loading) e la thread-safety senza sincronizzazioni costose
// Utilizza una inner static helper class

public class SingletonBillPugh {

    /* Dichiarazione di una variabile stringa */
    private String info;

    /* Costruttore privato o comunque non pubblico */
    private SingletonBillPugh() {
        info = "Oggetto inizializzato";
    }

    // Classe statica interna (Holder)
    // Non viene caricata finché non viene richiamata esplicitamente
    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    /* Metodo static */
    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Setter & Getter
    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }
}
