package cloud.compagno.designpatterns.strutturali.bridge;

// Implementazione per l'assemblaggio
public class Assemblaggio implements Officina {
    @Override
    public void lavora() {
        System.out.print(" (assemblato)");
    }
}
