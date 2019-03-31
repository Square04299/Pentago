package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public enum State {

    /**
     * Will be able to place one marble on the board
     */
    PLACE,
    /**
     * Will be able to only rotate one Quadrant
     */
    ROTATE,
    /**
     * Tells when the game is over, meaning we have a winner or the cell 0,0 of
     * the quadrant 0 is full
     */
    OVER;
}
