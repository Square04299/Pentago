package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public interface Facade {
    
    public void addPlayer(Player player);
    
    Player getCurrentPlayer();
    
    void changeCurrentPlayer();

    public void placePiece(int x, int y, int q);

    void rotationQuadrantRight(int value);
    
    void rotationQuadrantLeft(int value);

    boolean isOver();
    
    void setState(State state);

    Player getWinners();
}
