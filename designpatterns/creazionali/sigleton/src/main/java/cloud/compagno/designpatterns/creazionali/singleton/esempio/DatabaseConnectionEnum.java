package cloud.compagno.designpatterns.creazionali.singleton.esempio;

public enum DatabaseConnectionEnum {
    // L'unica istanza del Singleton
    INSTANCE;

    // I campi della classe (stato interno)
    private final String connectionUrl;

    // Il costruttore negli Enum è privato di default e viene eseguito
    // una sola volta al caricamento della classe.
    DatabaseConnectionEnum() {
        this.connectionUrl = "jdbc:mysql://localhost:3306/my_db";
        System.out.println("Enum Singleton: Connessione inizializzata!");
    }

    // Metodo di utilità
    public void executeQuery(String query) {
        System.out.println("Eseguo su " + connectionUrl + ": " + query);
    }
}
