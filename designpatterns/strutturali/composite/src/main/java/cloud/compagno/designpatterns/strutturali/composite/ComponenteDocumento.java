package cloud.compagno.designpatterns.strutturali.composite;

/**
 * Component: definisce l'interfaccia comune a foglie e compositi.
 * In questa variante "trasparente" espone anche add/remove, che le foglie
 * non supportano e quindi lasciano con l'implementazione di default.
 */
public interface ComponenteDocumento {

    String getNome();

    int getDimensioneInKB();

    /**
     * Restituisce una rappresentazione testuale gerarchica.
     */
    String descrivi(String indentazione);

    default void aggiungi(ComponenteDocumento componente) {
        throw new UnsupportedOperationException("Operazione non supportata per una foglia");
    }

    default void rimuovi(ComponenteDocumento componente) {
        throw new UnsupportedOperationException("Operazione non supportata per una foglia");
    }
}

