package cloud.compagno.designpatterns.creazionali.builder;

public class ComputerInnerStaticBuilder {
    // Campi final per garantire l'immutabilità
    private final String cpu;
    private final String ram;
    private final String gpu;

    // Costruttore private: può essere chiamato solo dal Builder
    private ComputerInnerStaticBuilder(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.gpu = builder.gpu;
    }

    // Metodi getter (niente setter per l'immutabilità)
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getGpu() { return gpu; }

    public void mostraConfigurazione() {
        System.out.println("PC con: " + cpu + ", " + ram + ", " + gpu);
    }

    // --- INNER STATIC BUILDER ---
    public static class Builder {
        private String cpu;
        private String ram;
        private String gpu;

        // Metodi fluenti che ritornano l'istanza del Builder stesso
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        // Metodo build finale che istanzia l'oggetto Computer
        public ComputerInnerStaticBuilder build() {
            return new ComputerInnerStaticBuilder(this);
        }
    }
}
