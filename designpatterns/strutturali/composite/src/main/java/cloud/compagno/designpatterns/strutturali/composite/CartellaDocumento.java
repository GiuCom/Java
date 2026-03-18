package cloud.compagno.designpatterns.strutturali.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Composite: rappresenta un nodo composto che può contenere sia foglie
 * sia altri compositi. Implementa lo stesso contratto del componente base.
 */
public class CartellaDocumento implements ComponenteDocumento {

    private final String nome;
    private final List<ComponenteDocumento> figli = new ArrayList<>();

    public CartellaDocumento(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getDimensioneInKB() {
        int totale = 0;
        for (ComponenteDocumento figlio : figli) {
            totale += figlio.getDimensioneInKB();
        }
        return totale;
    }

    @Override
    public String descrivi(String indentazione) {
        StringBuilder builder = new StringBuilder();
        builder.append(indentazione)
                .append("+ Cartella: ")
                .append(nome)
                .append(" (")
                .append(getDimensioneInKB())
                .append(" KB)");

        for (ComponenteDocumento figlio : figli) {
            builder.append(System.lineSeparator())
                    .append(figlio.descrivi(indentazione + "  "));
        }
        return builder.toString();
    }

    @Override
    public void aggiungi(ComponenteDocumento componente) {
        figli.add(componente);
    }

    @Override
    public void rimuovi(ComponenteDocumento componente) {
        figli.remove(componente);
    }

    public List<ComponenteDocumento> getFigli() {
        return Collections.unmodifiableList(figli);
    }
}
