package cloud.compagno.designpatterns.creazionali.singleton;

public enum SingletonEnum {

    INSTANCE;

    /* Dichiarazione di una variabile stringa */
    private String info = "Singleton Enum - avviato";

    public void setInfo (String info) {
        this.info = info;
    }

    public String getInfo () {
        return info;
    }

    static void main() {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        System.out.println(singleton.getInfo());
        singleton.setInfo("Giuseppe");
        System.out.println(singleton.getInfo());
    }
}
