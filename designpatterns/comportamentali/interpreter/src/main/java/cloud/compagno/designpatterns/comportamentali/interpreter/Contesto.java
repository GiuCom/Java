package cloud.compagno.designpatterns.comportamentali.interpreter;

import java.util.HashMap;
import java.util.Map;

public record Contesto(Map<String, Integer> variabili) {
    public Contesto() { this(new HashMap<>()); }

    public void assegna(String var, int valore) { variabili.put(var, valore); }
    public int get(String var) { return variabili.getOrDefault(var, 0); }
}
