package cloud.compagno.designpatterns.creazionali.builder;

public class ComputerDirector {
    private ComputerBuilder builder;

    void setBuilder(ComputerBuilder b) { builder = b; }

    public void assembla() {
        builder.creaNuovoComputer();
        builder.buildCpu();
        builder.buildRam();
        builder.buildGpu();
    }
}
