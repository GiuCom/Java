package cloud.compagno.designpatterns.crazionali.singleton;

public class Singleton {

    /* Dichiarazione di una variabile stringa */
    private final String stringaConnection;

    /* Costruttore privato o comunque non pubblico */
    protected Singleton() {
        stringaConnection = "jdbc:postgresql://localhost:5432/mydb";
    }

    /* Salvo l'istanza per usarla dopo */
    private static Singleton instance = null;

    /* Metodo statico */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getStringaConnection() {
        return stringaConnection;
    }
}
