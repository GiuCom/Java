package cloud.compagno.designpatterns.strutturali.facade;

// Sottosistema Proiettore
public class Projector {
    public void powerOn() { System.out.println("🎥 Proiettore: Avvio sistema..."); }
    public void setInput(String source) { System.out.println("🎥 Proiettore: Input -> " + source); }
    public void off() { System.out.println("🎥 Proiettore: Spegnimento."); }
}
