package cloud.compagno.designpatterns.creazionali.builder;

public class ComputerGamingBuilder extends ComputerBuilder {
    public void buildCpu() { computer.setCpu("Intel i9"); }
    public void buildRam() { computer.setRam("32GB DDR5"); }
    public void buildGpu() { computer.setGpu("NVIDIA RTX 4090"); }
}

