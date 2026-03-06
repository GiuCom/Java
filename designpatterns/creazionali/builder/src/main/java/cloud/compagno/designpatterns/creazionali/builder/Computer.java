package cloud.compagno.designpatterns.creazionali.builder;

public class Computer {
    private String cpu;
    private String ram;
    private String gpu;

    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setRam(String ram) { this.ram = ram; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getGpu() { return gpu; }

    public void mostraConfigurazione() {
        System.out.println("PC con: " + cpu + ", " + ram + ", " + gpu);
    }
}
