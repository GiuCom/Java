package cloud.compagno.designpatterns.comportamentali.chainofresponsibility;

public abstract class BaseGestore implements GestoreSupporto {
    protected GestoreSupporto successivo;

    @Override
    public void setSuccessivo(GestoreSupporto successivo) {
       this.successivo = successivo;
    }

    // Metodo di utilità per far scorrere la catena
    protected void passaAlSuccessivo(RichiestaSupporto richiesta) {
        if (successivo != null) {
            successivo.gestisci(richiesta);
        } else {
            System.out.println("Fine della catena: nessuna gestione possibile per " + richiesta.tipo());
        }
    }
}
