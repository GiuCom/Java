package cloud.compagno.designpatterns.strutturali.composite;

/**
 * Client: costruisce una gerarchia e interagisce con essa in modo uniforme,
 * usando sempre il tipo ComponenteDocumento.
 */
public class CompositeMain {
    static void main() {
        CartellaDocumento radice = new CartellaDocumento("Progetto Architettura");
        CartellaDocumento capitolo1 = new CartellaDocumento("Capitolo 1");
        CartellaDocumento allegati = new CartellaDocumento("Allegati");

        ComponenteDocumento introduzione = new FileDocumento("introduzione.txt", 12);
        ComponenteDocumento analisi = new FileDocumento("analisi.pdf", 80);
        ComponenteDocumento diagramma = new FileDocumento("diagramma.png", 150);
        ComponenteDocumento verbale = new FileDocumento("verbale.docx", 25);

        capitolo1.aggiungi(introduzione);
        capitolo1.aggiungi(analisi);
        allegati.aggiungi(diagramma);
        allegati.aggiungi(verbale);

        radice.aggiungi(capitolo1);
        radice.aggiungi(allegati);

        System.out.println(radice.descrivi(""));
        System.out.println("Dimensione totale: " + radice.getDimensioneInKB() + " KB");
    }
}