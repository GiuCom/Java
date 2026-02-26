package cloud.compagno.designpatterns.crazionali.singleton;

// Bill Pugh Singleton
// garantisce il caricamento pigro (lazy loading) e la thread-safety senza sincronizzazioni costose
// Utilizza una inner static helper class

public class SingletonBillPugh {

    /* Dichiarazione di una variabile stringa */
    private String stringaConnection = "";

    // Costruttore privato per impedire istanziazioni esterne
    private SingletonBillPugh() {
        System.out.println("Inizializzazione Singleton...");
        stringaConnection = "jdbc:postgresql://localhost:5432/mydb";
    }

    // Classe interna statica che carica l'istanza solo alla prima chiamata
    private static class SingletonHolder {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getStringaConnection() {
        return stringaConnection;
    }
}
