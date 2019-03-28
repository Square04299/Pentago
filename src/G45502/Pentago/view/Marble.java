package G45502.Pentago.view;

import javafx.scene.shape.Circle;

/**
 *
 * @author G45502
 */
public class Marble extends Circle{
    private Circle circle;

    public Marble() {
        System.out.println("        Marble");
        initialze();
    }

    private void initialze() {
        circle = new Circle();
    }
    
    
}
