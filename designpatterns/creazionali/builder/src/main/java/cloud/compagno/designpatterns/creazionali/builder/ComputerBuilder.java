package cloud.compagno.designpatterns.creazionali.builder;

abstract class ComputerBuilder {
    protected Computer computer;

    public Computer getComputer() { return computer; }
    public void creaNuovoComputer() { computer = new Computer(); }

    public abstract void buildCpu();
    public abstract void buildRam();
    public abstract void buildGpu();
}
