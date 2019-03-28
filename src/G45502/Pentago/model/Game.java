package G45502.Pentago.model;

import java.util.List;

/**
 *
 * @author G45502
 */
public class Game implements Facade {
    
    private final Board board;
    private final List<Joueur> players;
    private Joueur currentPlayer;

    public Game(List<Joueur> players) {
        this.board = new Board();
        this.players = players;
        this.currentPlayer = players.get(0); //0 will always be WHITE
    }
    
    @Override
    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
    
    public int[][] getQuadrant(int value){
        return board.getQuadrant(value).getQuadrant();
    }
    
    @Override
    public void changeCurrentPlayer() {
        if (this.currentPlayer.isWhite()) {
            this.currentPlayer = this.currentPlayer.getPlayer(players, Marble.BLACK);
        } else {
            this.currentPlayer = this.currentPlayer.getPlayer(players, Marble.WHITE);
        }
    }

    @Override
    public void placePiece(int x, int y, int q) {
        board.addPiece(x, y, this.currentPlayer.getColor(), q);
    }

//    @Override
//    public void rotationQuadrant(int value) {
//
//    }

    @Override
    public boolean isOver(State state) {
        return state == State.OVER;
    }

    @Override
    public Winners getWinners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
