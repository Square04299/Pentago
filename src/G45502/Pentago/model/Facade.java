package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public interface Facade {
    void getCurrentPlayer();

    boolean placePiece();

    void rotationQuadrant();

    Board setBoard();

    boolean isOver();

    Winners getWinners();
}
