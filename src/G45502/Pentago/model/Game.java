package G45502.Pentago.model;

import java.util.List;

/**
 *
 * @author G45502
 */
public class Game implements Facade {
    
    private Board board;
    private List<Joueur> players;
    private Joueur currentPlayer;

    public Game(List<Joueur> players) {
        this.board = new Board();
        this.players = players;
        this.currentPlayer = players.get(1);
    }
    
    @Override
    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }
    
    @Override
    public void changeCurrentPlayer() {
        if (this.currentPlayer.isWhite()) {
            this.currentPlayer.getPlayer(players, Marble.BLACK);
        } else {
            this.currentPlayer.getPlayer(players, Marble.WHITE);
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
    public Board setBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOver(State state) {
        return state == State.OVER;
    }

    @Override
    public Winners getWinners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
