package cloud.compagno.designpatterns.creazionali.prototype;

// 3. Client
public class PrototypeMain {
    static void main() {
        // 1. Creazione delle istanze "Prototipo" (oggetti base)

        System.out.println("// -------------------------------------------");
        System.out.println("// Versione con l'utilizzo della classe Figura");
        System.out.println("// -------------------------------------------");

        Cerchio cerchio = new Cerchio();
        cerchio.setId("101");

        Rettangolo rettangolo = new Rettangolo();
        rettangolo.setId("202");

        // 2. Clonazione degli oggetti anziché usare 'new'
        // Questo è il cuore del pattern: chiediamo all'oggetto di duplicarsi
        Cerchio clonedCerchio = (Cerchio) cerchio.clone();
        Rettangolo clonedRettangolo = (Rettangolo) rettangolo.clone();

        // 3. Personalizzazione dei cloni
        // I cloni partono con lo stato dell'originale, ma sono oggetti distinti
        clonedCerchio.setId("102");

        // 4. Verifica dei risultati
        System.out.println("\nVerifica oggetti Cerchio clonati:");
        System.out.println("Originale (ID): " + cerchio.getId() + " | Tipo: " + cerchio.getNomeFigura());
        System.out.println("Clonato (ID): " + clonedCerchio.getId() + " | Tipo: " + clonedCerchio.getNomeFigura());

        System.out.println("\nEsecuzione metodi sui cloni:");
        clonedCerchio.disegna();
        clonedRettangolo.disegna();

        // Verifica identità di memoria
        System.out.println("\nVerifica identità oggetti Cerchio clonati:");
        System.out.println("Sono lo stesso oggetto in memoria? " + (cerchio == clonedCerchio ? "Sì" : "No"));

        System.out.println();
        System.out.println("// ------------------------------------------------");
        System.out.println("// Versione con l'utilizzo della classe FiguraCahce");
        System.out.println("// ------------------------------------------------");

        // 1. Inizializza la cache una sola volta
        FiguraCache.loadCache();

        // 2. Il client chiede una forma tramite ID
        // Nota: riceve un oggetto di tipo Figura (astratto)
        Figura clonedFigura1 = FiguraCache.getFigura("1");
        System.out.println("Forma ottenuta: " + clonedFigura1.getNomeFigura());

        Figura clonedFigura2 = FiguraCache.getFigura("2");
        System.out.println("Forma ottenuta: " + clonedFigura2.getNomeFigura());

        // 3. Modifica del clone senza toccare la cache
        clonedFigura1.setId("100-Nuovo");
        System.out.println("ID del clone modificato: " + clonedFigura1.getId());
        System.out.println("ID dell'originale in cache resta: " + FiguraCache.getFigura("1").getId());


        System.out.println();
        System.out.println("// ------------------------------------------------------------");
        System.out.println("// Versione con l'utilizzo della classe FiguraCahce e Deep Copy");
        System.out.println("// ------------------------------------------------------------");

        // 1. Otteniamo l'unica istanza del Registry (Singleton)
        // Al primo accesso, il Registry carica internamente i Prototipi Master

        System.out.println("--- Richiesta Primo Clone ---");
        Figura figura1 = FiguraCache.getFigura("1");
        figura1.setId("CLONE_01");

        // 2. Modifica dello stato profondo del primo clone
        // Cambiamo la posizione X dell'oggetto Position interno
        if (figura1.getCoordinate() == null) {
            figura1.setCoordinate(500, 500);
        }

        System.out.println("Figura 1 [ID]: " + figura1.getId());
        System.out.println("Figura 1 [Coordinate]: X=" + figura1.getCoordinate().x + ", Y=" + figura1.getCoordinate().y);

        System.out.println("\n--- Richiesta Secondo Clone ---");
        // 3. Richiediamo un nuovo clone dello stesso tipo ("CIRCLE")
        Figura figura2 = FiguraCache.getFigura("2");
        figura2.setId("CLONE_02");

        // 2. Modifica dello stato profondo del primo clone
        // Cambiamo la posizione X dell'oggetto Position interno
        if (figura2.getCoordinate() == null) {
            figura2.setCoordinate(100, 100);
        }

        // 4. VERIFICA DELLA DEEP COPY
        // Se la Deep Copy funziona, shape2 deve avere la posizione originale (0,0)
        // e non quella modificata da shape1 (500,500).
        System.out.println("Figura 2 [ID]: " + figura2.getId());
        System.out.println("Figura 2 [Coordinate]: X=" + figura2.getCoordinate().x + ", Y=" + figura2.getCoordinate().y);

        // 5. Confronto dei riferimenti di memoria
        System.out.println("\n--- Analisi Indipendenza ---");
        System.out.println("Gli oggetti Shape sono diversi? " + (figura1 != figura2));
        System.out.println("Gli oggetti Position interni sono diversi? " + (figura1.getCoordinate() != figura2.getCoordinate()));

        if (figura1.getCoordinate() != figura2.getCoordinate()) {
            System.out.println("RISULTATO: Deep Copy riuscita. I cloni sono totalmente isolati.");
        } else {
            System.out.println("RISULTATO: Shallow Copy rilevata. Attenzione ai riferimenti condivisi!");
        }
    }
}
