package cloud.compagno.designpatterns.strutturali.facade;

// Sottosistema Streaming con Pattern Matching
public class StreamingService {
    public void startStream(Object content) {
        // Java 25 Pattern Matching per switch con gestione null-safe
        switch (content) {
            case Movie m -> System.out.println("""
                    🎬 Streaming: Riproduzione in corso...
                       Film:    %s (%d)
                       Qualità: %s
                    """.formatted(m.title(), m.year(), m.quality()));
            case String s -> System.out.println("🎬 Streaming: Avvio rapido titolo: " + s);
            case null -> throw new IllegalArgumentException("Contenuto nullo!");
            default -> System.out.println("⚠️ Formato non supportato.");
        }
    }
}
