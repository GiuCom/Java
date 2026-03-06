package cloud.compagno.designpatterns.creazionali.builder;

public class BuilderMain {
    // Client
    static void main() {
        ComputerDirector ingegnere = new ComputerDirector();
        ComputerBuilder gamingBuilder = new ComputerGamingBuilder();

        // L'ingegnere usa il manuale del PC da Gaming
        ingegnere.setBuilder(gamingBuilder);
        ingegnere.assembla();

        // Otteniamo il prodotto finale
        Computer mioPC = gamingBuilder.getComputer();
        mioPC.mostraConfigurazione();
    }
}
