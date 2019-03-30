package G45502.Pentago.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author G45502
 */
public class FxMarble extends Circle{
    private Circle circle;

    public FxMarble() {
        initialze();
    }

    private void initialze() {
        circle = new Circle(25,Color.PINK);
        setStyle();
        
    }

    public Circle getCircle() {
        return circle;
    }
    
    public void setColor(Color color) {
        circle.setFill(color);        
    }

    private void setStyle() {
        circle.setStroke(Color.BLACK);
        circle.setStrokeType(StrokeType.INSIDE);

    }
    
}
