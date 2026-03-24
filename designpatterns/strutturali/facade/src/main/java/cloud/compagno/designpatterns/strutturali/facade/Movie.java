package cloud.compagno.designpatterns.strutturali.facade;

// Record per i dati del film - Immutabilità garantita
public record Movie(String title, int year, String quality) {
}
