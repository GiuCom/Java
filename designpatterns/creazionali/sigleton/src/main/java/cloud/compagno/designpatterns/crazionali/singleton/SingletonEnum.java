package cloud.compagno.designpatterns.crazionali.singleton;

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

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        System.out.println(singleton.getInfo());
        singleton.setInfo("Giuseppe");
        System.out.println(singleton.getInfo());
    }
}
