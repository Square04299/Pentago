package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public interface Facade {
    void getCurrentPlayer();

    void placePiece();

    void rotationQuadrant(int value);

    Board setBoard();

    boolean isOver();

    Winners getWinners();
}
