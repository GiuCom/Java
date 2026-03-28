package cloud.compagno.designpatterns.strutturali.facade;

// Sottosistema Luci
public class Lights {
    public void dim(int level) { System.out.printf("💡 Luci: Regolate al %d%%%n", level); }
    public void on() { System.out.println("💡 Luci: Accese (Piena intensità)"); }
}
