package cloud.compagno.designpatterns.strutturali.proxy;

public class ProxyImmagine implements Immagine {
    private final String nomeFile;
    private ImmagineReale immagineReale; // Riferimento all'oggetto reale

    public ProxyImmagine(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    @Override
    public void visualizza() {
        // Lazy Initialization: l'oggetto reale viene creato solo qui
        if (immagineReale == null) {
            immagineReale = new ImmagineReale(nomeFile);
        }
        immagineReale.visualizza();
    }
}
