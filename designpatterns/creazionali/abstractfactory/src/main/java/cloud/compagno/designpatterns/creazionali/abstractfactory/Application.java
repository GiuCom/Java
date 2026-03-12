package cloud.compagno.designpatterns.creazionali.abstractfactory;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    // Dependency Injection: la factory viene passata dall'esterno
    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.paint();
        checkbox.paint();
    }
}
