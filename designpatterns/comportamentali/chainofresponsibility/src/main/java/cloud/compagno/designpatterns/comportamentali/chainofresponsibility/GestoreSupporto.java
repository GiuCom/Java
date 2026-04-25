package cloud.compagno.designpatterns.comportamentali.chainofresponsibility;

public interface GestoreSupporto {

    void gestisci(RichiestaSupporto richiesta);
    void setSuccessivo(GestoreSupporto successivo);

}
