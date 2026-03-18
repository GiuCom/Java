package cloud.compagno.designpatterns.strutturali.composite;

/**
 * Leaf: rappresenta un elemento indivisibile della gerarchia.
 * Non contiene figli e fornisce direttamente il proprio comportamento.
 */
public class FileDocumento implements ComponenteDocumento {

    private final String nome;
    private final int dimensioneInKB;

    public FileDocumento(String nome, int dimensioneInKB) {
        this.nome = nome;
        this.dimensioneInKB = dimensioneInKB;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getDimensioneInKB() {
        return dimensioneInKB;
    }

    @Override
    public String descrivi(String indentazione) {
        return indentazione + "- File: " + nome + " (" + dimensioneInKB + " KB)";
    }
}

