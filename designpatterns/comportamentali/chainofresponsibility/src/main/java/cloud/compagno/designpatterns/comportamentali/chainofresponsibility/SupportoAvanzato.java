package cloud.compagno.designpatterns.comportamentali.chainofresponsibility;

public final class SupportoAvanzato extends BaseGestore {

    @Override
    public void gestisci(RichiestaSupporto richiesta) {
        if (richiesta.priorita() > 1) {
            System.out.println("Supporto Avanzato: Risolto -> " + richiesta.tipo());
        } else {
            passaAlSuccessivo(richiesta);
        }
    }
}
