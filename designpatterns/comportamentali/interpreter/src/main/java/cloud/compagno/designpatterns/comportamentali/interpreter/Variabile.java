package cloud.compagno.designpatterns.comportamentali.interpreter;

// Variabile (Terminale)
public record Variabile(String nome) implements Espressione {
    @Override public int interpreta(Contesto c) { return c.get(nome); }
}
