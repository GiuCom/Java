package cloud.compagno.designpatterns.comportamentali.interpreter;

public record Somma(Espressione sinistra, Espressione destra) implements Espressione {
    @Override
    public int interpreta(Contesto c) {
        return sinistra.interpreta(c) + destra.interpreta(c);
    }
}
