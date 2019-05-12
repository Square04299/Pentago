package G45502.Pentago.model;

import java.util.Observable;

/**
 *
 * @author G45502
 */
public abstract class Facade extends Observable {

    /**
     * Getter of quadrant
     *
     * @param value Which quadrant to pick
     * @return 2d array of the selected Quadrant
     */
    public abstract Quadrant getQuadrant(int value);

    /**
     * Set the color of the marble in the view when adding player to the list
     *
     * @return White of the list of player is empty, Black if at least 1 player
     * is in the list of Players
     */
    public abstract Marble setColor();

    /**
     * Will add a player to the list of all players
     *
     * @param player A player to add
     */
    public abstract void addPlayer(Player player);

    /**
     * Getter of the Current Player playing
     *
     * @return the player that is currently playing
     */
    public abstract Player getCurrentPlayer();

    /**
     * Change the current Player by knowing the color of it's marble if the
     * current player has a white marble, it will change it to black
     */
    public abstract void changeCurrentPlayer();

    /**
     * Place a white or black marble in a specific x, y and quadrant
     *
     * @param x the x axis
     * @param y the y axis
     * @param q the quadrant to add the marble
     */
    public abstract void placePiece(int x, int y, int q);

    /**
     * Will rotate the "value" quadrant to the right
     *
     * @param value Which quadrant to rotate
     */
    public abstract void rotationQuadrantRight(int value);

    /**
     * Will rotate the "value" quadrant to the left
     *
     * @param value Which quadrant to rotate
     */
    public abstract void rotationQuadrantLeft(int value);

    /**
     * Check if the state of the game is STATE.OVER
     *
     * @return true if STATE.OVER
     */
    public abstract boolean isOver();

    /**
     * Setter of the State
     *
     * @param state will change the state with this value
     */
    abstract void setState(State state);

    /**
     * Get the winner by looking if a marble has been placed in the x=0, y=0 and
     * quadrant(0)
     *
     * @return the currentPlayer, meaning the player that just played if the
     * condition are right he will be selected otherwise it will just ignore and
     * continue the logique of the game
     */
    public abstract Player getWinners();

    /**
     * Return the value of the marble at the quadrant, position x and y
     *
     * @param i Quadrant
     * @param j X axis
     * @param k Y axis
     * @return -1 if the color is null, 0 for black and 1 for white
     */
    public abstract int getColorMarble(int i, int j, int k);
}
