package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public interface Facade{

    /**
     * Will add a player to the list of all players
     *
     * @param player A player to add
     */
    public void addPlayer(Player player);

    /**
     * Getter of the Current Player playing
     *
     * @return the player that is currently playing
     */
    Player getCurrentPlayer();

    /**
     * Change the current Player by knowing the color of it's marble if the
     * current player has a white marble, it will change it to black
     */
    void changeCurrentPlayer();

    /**
     * Place a white or black marble in a specific x, y and quadrant
     *
     * @param x the x axis
     * @param y the y axis
     * @param q the quadrant to add the marble
     */
    public void placePiece(int x, int y, int q);

    /**
     * Will rotate the "value" quadrant to the right
     *
     * @param value Which quadrant to rotate
     */
    void rotationQuadrantRight(int value);

    /**
     * Will rotate the "value" quadrant to the left
     *
     * @param value Which quadrant to rotate
     */
    void rotationQuadrantLeft(int value);

    /**
     * Check if the state of the game is STATE.OVER
     *
     * @return true if STATE.OVER
     */
    boolean isOver();

    /**
     * Setter of the State
     *
     * @param state will change the state with this value
     */
    void setState(State state);

    /**
     * Get the winner by looking if a marble has been placed in the x=0, y=0 and
     * quadrant(0)
     *
     * @return the currentPlayer, meaning the player that just played if the
     * condition are right he will be selected otherwise it will just ignore and
     * continue the logique of the game
     */
    Player getWinners();
}
