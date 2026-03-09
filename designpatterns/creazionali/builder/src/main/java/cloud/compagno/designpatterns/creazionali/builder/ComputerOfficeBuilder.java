package cloud.compagno.designpatterns.creazionali.builder;

public class ComputerOfficeBuilder extends ComputerBuilder {
    public void buildCpu() { computer.setCpu("Intel i5"); }
    public void buildRam() { computer.setRam("16GB DDR5"); }
    public void buildGpu() { computer.setGpu("NVIDIA GeForce GT 1030"); }
}

