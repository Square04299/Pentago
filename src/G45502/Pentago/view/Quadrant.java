package G45502.Pentago.view;

import javafx.scene.layout.GridPane;

/**
 *
 * @author G45502
 */
public class Quadrant extends GridPane{
    private GridPane quadrant;

    public Quadrant() {
//        setVgap(10);
//        setHgap(10);
//        setCenterShape(true);
        System.out.println("    Quadrant");
        initialze();
    }

    private void initialze() {
        quadrant = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(new Marble(), j, i);
            }
        }
    }
    
    
}
