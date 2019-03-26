package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public interface Facade {
    Joueur getCurrentPlayer();
    
    void changeCurrentPlayer();

    public void placePiece(int x, int y, int q);

    //void rotationQuadrant(int value); Later Implamentation

    Board setBoard();

    boolean isOver(State state);

    Winners getWinners();
}
