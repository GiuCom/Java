package cloud.compagno.designpatterns.strutturali.facade;

// Sottosistema Audio
public class SoundSystem {
    public void start() { System.out.println("🔊 Audio: Amplificatore pronto."); }
    public void setVolume(int level) { System.out.println("🔊 Audio: Volume fissato a " + level); }
}
