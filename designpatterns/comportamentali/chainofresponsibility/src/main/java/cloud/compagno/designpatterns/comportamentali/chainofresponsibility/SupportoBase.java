package cloud.compagno.designpatterns.comportamentali.chainofresponsibility;

public final class SupportoBase extends BaseGestore {

    @Override
    public void gestisci(RichiestaSupporto richiesta) {
        if (richiesta.priorita() <= 1) {
            System.out.println("Supporto Base: Gestito -> " + richiesta.tipo());
        } else {
            System.out.println("Supporto Base: Inoltro...");
            passaAlSuccessivo(richiesta);
        }
    }
}
