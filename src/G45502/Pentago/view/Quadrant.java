package G45502.Pentago.view;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

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
        initialze();
    }

    private void initialze() {
        quadrant = new GridPane();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                quadrant.add(new Circle(), j, i);
            }
        }
        //quadrant.getStylesheets().add("Quadrant.css");
    }
    
    
}
