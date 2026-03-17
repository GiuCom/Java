package cloud.compagno.designpatterns.strutturali.bridge;


public class BridgeMain {
    static void main() {
        // 1. Creiamo le implementazioni (il "come" lavorare)
        Officina officinaAssemblaggio = new Assemblaggio();
        Officina officinaVerniciatura = new Verniciatura();

        // 2. Creiamo l'astrazione "Automobile" e iniettiamo le officine (il Ponte)
        // L'automobile non sa COSA fanno le officine, sa solo che può chiamarle.
        Veicolo miaAuto = new Automobile(officinaAssemblaggio, officinaVerniciatura);

        // 3. Eseguiamo il processo
        System.out.println("Inizio produzione auto:");
        miaAuto.produci();
        // Output: Automobile: (assemblato) (verniciato)

        System.out.println("\n---------------------------");

        // 4. Possiamo riutilizzare le STESSE officine per un'astrazione diversa (Moto)
        Veicolo miaMoto = new Moto(officinaAssemblaggio, officinaVerniciatura);

        System.out.println("Inizio produzione moto:");
        miaMoto.produci();
        // Output: Moto: (assemblato) (verniciato)
    }
}