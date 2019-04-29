package G45502.Pentago.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author G45502
 */
public class FxMarble extends Circle {
    
    private int x;
    private int y;

    /**
     * Builder of marble
     * @param x X axis
     * @param y Y axis
     */
    public FxMarble(int x,int y) {
        super(30, Color.PINK);
        this.x = x;
        this.y = y;
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
     * Getter x
     * @return the x position of the marble
     */
    public int getX() {
        return x;
    }

    /**
     * Getter Y
     * @return the y position of the marble
     */
    public int getY() {
        return y;
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

    @Override
    public String toString() {
        return "FxMarble{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
