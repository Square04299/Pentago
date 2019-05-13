package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public class Move {
    
    private Marble marble;
    private int x;
    private int y;
    private int quadrant;
    private String rotation;

    public Move(Marble marble, int x, int y, int quadrant) {
        this.marble = marble;
        this.x = x;
        this.y = y;
        this.quadrant = quadrant;
        this.rotation = null;
    }

    public Marble getMarble() {
        return marble;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getQuadrant() {
        return quadrant;
    }
    
    public String getRotation(){
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    
    
}
