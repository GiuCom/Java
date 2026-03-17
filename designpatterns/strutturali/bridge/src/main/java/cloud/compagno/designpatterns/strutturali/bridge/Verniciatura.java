package cloud.compagno.designpatterns.strutturali.bridge;

// Implementazione per la verniciatura
public class Verniciatura implements Officina {
    @Override
    public void lavora() {
        System.out.print(" (verniciato)");
    }
}
