package cloud.compagno.designpatterns.comportamentali.command;

public class Condizionatore {
    private int temperatura = 22;

    public void accendi() { System.out.println("Condizionatore ACCESO"); }
    public void spegni() { System.out.println("Condizionatore SPENTO"); }

    public void impostaTemperatura(int t) {
        this.temperatura = t;
        System.out.println("Temperatura impostata a: " + t + "°C");
    }

    public int getTemperatura() { return temperatura; }
}
