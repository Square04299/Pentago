package G45502.Pentago.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author G45502
 */
public class FxMarble extends Circle {

    /**
     * Builder of marble
     */
    public FxMarble() {
        super(30, Color.PINK);
        setStyle();
    }

    /**
     * Getter of Marble
     *
     * @return Marble
     */
    public Circle getCircle() {
        return this;
    }

    /**
     * Change the color of a marble
     *
     * @param color Black or White
     */
    public void setColor(int color) {
        switch (color) {
            case 0:
                this.setFill(Color.BLACK);
                break;
            case 1:
                this.setFill(Color.WHITE);
                break;
            default:
                this.setFill(Color.PINK);
                break;
        }
        
    }

    private void setStyle() {
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(3);
        this.setStrokeType(StrokeType.INSIDE);
    }
}
