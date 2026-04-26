package cloud.compagno.designpatterns.comportamentali.interpreter;

// Numero (Terminale)
public record Numero(int valore) implements Espressione {
    @Override public int interpreta(Contesto c) { return valore; }
}
