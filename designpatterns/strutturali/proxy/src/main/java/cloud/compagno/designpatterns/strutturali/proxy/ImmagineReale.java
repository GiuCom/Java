package cloud.compagno.designpatterns.strutturali.proxy;

public class ImmagineReale implements Immagine {
    private final String nomeFile;

    public ImmagineReale(String nomeFile) {
        this.nomeFile = nomeFile;
        caricaDaDisco();
    }

    private void caricaDaDisco() {
        System.out.println("Operazione pesante: Caricamento di " + nomeFile + " dal disco...");
    }

    @Override
    public void visualizza() {
        System.out.println("Visualizzazione dell'immagine: " + nomeFile);
    }
}
