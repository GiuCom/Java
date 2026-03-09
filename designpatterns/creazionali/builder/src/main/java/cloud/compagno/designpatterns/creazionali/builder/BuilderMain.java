package cloud.compagno.designpatterns.creazionali.builder;

public class BuilderMain {
    // Client
    static void main() {

        System.out.println("// -------------------------------");
        System.out.println("// Versione standard");
        System.out.println("// -------------------------------");
        ComputerDirector ingegnere = new ComputerDirector();
        ComputerBuilder gamingBuilder = new ComputerGamingBuilder();

        // L'ingegnere usa il manuale del PC da Gaming
        ingegnere.setBuilder(gamingBuilder);
        ingegnere.assembla();

        // Otteniamo il prodotto finale
        Computer mioPC = gamingBuilder.getComputer();
        mioPC.mostraConfigurazione();

        System.out.println();
        System.out.println("// -------------------------------");
        System.out.println("// Versione con InnerStaticBuilder");
        System.out.println("// -------------------------------");
        // Creazione di un PC da Gaming
        ComputerInnerStaticBuilder gamingPc = new ComputerInnerStaticBuilder.Builder()
                .cpu("Intel i9")
                .ram("32GB DDR5")
                .gpu("NVIDIA RTX 4090")
                .build();

        // Creazione di un PC da Ufficio
        ComputerInnerStaticBuilder officePc = new ComputerInnerStaticBuilder.Builder()
                .cpu("Intel i5")
                .ram("16GB DDR5")
                .gpu("NVIDIA GeForce GT 1030")
                .build();

        // Creazione di un PC Server omettendone la GPU (flessibilità del Builder)
        ComputerInnerStaticBuilder serverPc = new ComputerInnerStaticBuilder.Builder()
                .cpu("AMD EPYC")
                .ram("128GB ECC")
                .build();

        System.out.println("Configurazione Gaming:");
        gamingPc.mostraConfigurazione();

        System.out.println("\nConfigurazione Ufficio:");
        officePc.mostraConfigurazione();

        System.out.println("\nConfigurazione Server:");
        serverPc.mostraConfigurazione();
    }
}
