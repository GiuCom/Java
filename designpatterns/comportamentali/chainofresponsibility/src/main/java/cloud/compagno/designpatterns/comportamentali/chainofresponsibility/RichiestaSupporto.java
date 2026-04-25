package cloud.compagno.designpatterns.comportamentali.chainofresponsibility;

/**
 * Rappresenta una richiesta di assistenza.
 * @param tipo Descrizione del problema
 * @param priorita Valore numerico (1 = Bassa, 2+ = Alta)
 */

public record RichiestaSupporto(String tipo, int priorita) {
}
