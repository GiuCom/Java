package cloud.compagno.designpatterns.comportamentali.command;

public record ComandoTemperatura(Condizionatore condizionatore, int nuovaTemp, int vecchiaTemp)
        implements Comando {

    @Override
    public void esegui() {
        condizionatore.impostaTemperatura(nuovaTemp);
    }

    @Override
    public void annulla() {
        condizionatore.impostaTemperatura(vecchiaTemp);
    }
}
