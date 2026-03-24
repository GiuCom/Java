package cloud.compagno.designpatterns.strutturali.facade;

public class HomeTheater {
    private final Lights lights;
    private final Projector projector;
    private final SoundSystem sound;
    private final StreamingService streaming;

    public HomeTheater(Lights l, Projector p, SoundSystem s, StreamingService st) {
        this.lights = l;
        this.projector = p;
        this.sound = s;
        this.streaming = st;
    }

    /**
     * Semplifica un processo di 6 step in un'unica chiamata.
     */
    public void watchMovie(String title) {
        System.out.println("\n🍿 Preparazione serata cinema...");

        lights.dim(15);
        projector.powerOn();
        projector.setInput("Ultra-HD Stream");
        sound.start();
        sound.setVolume(20);

        // Creazione record immediata
        var movie = new Movie(title, 1994, "4K Dolby Vision");
        streaming.startStream(movie);

        System.out.println("✅ Tutto pronto. Buona visione!\n");
    }

    public void stopMovie() {
        System.out.println("\nCleaning up...");
        projector.off();
        lights.on();
    }
}
