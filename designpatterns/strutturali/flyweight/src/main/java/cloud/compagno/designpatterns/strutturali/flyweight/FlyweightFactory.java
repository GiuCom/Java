package cloud.compagno.designpatterns.strutturali.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private final Map<String, AlberoDefinizione> pool = new HashMap<>();

    public AlberoDefinizione getAlberoDefinizione(String nome, String colore, String texture) {
        String key = nome + "|" + colore + "|" + texture;
        AlberoDefinizione type = pool.get(key);
        if (type == null) {
            type = new AlberoDefinizione(nome, colore, texture);
            pool.put(key, type);
        }
        return type;
    }

    public int getPoolSize() {
        return pool.size();
    }
}
