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

    /**
     * Builder of the 1 move history
     *
     * @param marble color
     * @param x X axis
     * @param y Y axis
     * @param quadrant quadrant where the marble has been placed
     */
    public Move(Marble marble, int x, int y, int quadrant) {
        this.marble = marble;
        this.x = x;
        this.y = y;
        this.quadrant = quadrant;
        this.rotation = null;
    }

    /**
     * Getter of Marble
     *
     * @return Marble color
     */
    public Marble getMarble() {
        return marble;
    }

    /**
     * Getter of x
     *
     * @return x axis
     */
    public int getX() {
        return x;
    }

    /**
     * Getter of Y
     *
     * @return y axis
     */
    public int getY() {
        return y;
    }

    /**
     * Getter of Quadrant
     *
     * @return quadrant
     */
    public int getQuadrant() {
        return quadrant;
    }

    /**
     * Getter of rotation
     *
     * @return string with the word right or left
     */
    public String getRotation() {
        return rotation;
    }

    /**
     * Setter of the text for ratation
     *
     * @param rotation where to set the text too
     */
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }
}
