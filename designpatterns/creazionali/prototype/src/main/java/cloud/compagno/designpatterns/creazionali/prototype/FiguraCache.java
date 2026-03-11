package cloud.compagno.designpatterns.creazionali.prototype;

import java.util.Hashtable;
import java.util.Map;

public class FiguraCache {
    // Una mappa per conservare i prototipi "master"
    private static Map<String, Figura> figuraMap = new Hashtable<>();
    private static FiguraCache instance;

    private FiguraCache() {
        // Carichiamo i prototipi MASTER (che rimarranno intatti nella mappa)
        Cerchio masterCerchio = new Cerchio();
        masterCerchio.setCoordinate(0, 0); // Posizione iniziale (0,0)
        figuraMap.put("1", masterCerchio);

        Rettangolo masterRettangolo = new Rettangolo();
        masterRettangolo.setCoordinate(0, 0); // Posizione iniziale (0,0)
        figuraMap.put("2", masterRettangolo);
    }

    public static synchronized FiguraCache getInstance() {
        if (instance == null) instance = new FiguraCache();
        return instance;
    }

    // Metodo che restituisce il CLONE del prototipo richiesto
    public static Figura getFigura(String figuraId) {
        Figura cachedFigura = figuraMap.get(figuraId);

        if (cachedFigura == null) {
            return null;
        }

        // Restituiamo SEMPRE un clone, mai l'originale in cache
        Figura master = figuraMap.get(figuraId.toUpperCase());
        // Qui avviene la magia della Deep Copy delegata alla classe Shape
        return (master != null) ? (Figura) master.clone() : null;
    }

    // Metodo per caricare i prototipi iniziali (simula un DB o config pesante)
    public static void loadCache() {
        Cerchio cerchio = new Cerchio();
        cerchio.setId("1");
        figuraMap.put(cerchio.getId(), cerchio);

        Rettangolo rettangolo = new Rettangolo();
        rettangolo.setId("2");
        figuraMap.put(rettangolo.getId(), rettangolo);

        System.out.println("Cache caricata: Cerchio (ID:1) e Rettangolo (ID:2) pronti.");
    }
}
