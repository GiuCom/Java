package cloud.compagno.designpatterns.comportamentali.command;

import java.util.Stack;

public class Telecomando {
    private final Stack<Comando> cronologia = new Stack<>();

    public void inviaPressione(Comando comando) {
        comando.esegui();
        cronologia.push(comando);
    }

    public void premiAnnulla() {
        if (!cronologia.isEmpty()) {
            cronologia.pop().annulla();
        } else {
            System.out.println("Cronologia vuota: nessuna operazione da annullare.");
        }
    }
}
