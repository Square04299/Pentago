package G45502.Pentago.model;

import G45502.Pentago.exception.GameException;
import java.util.List;

/**
 *
 * @author G45502
 */
public class Game implements Facade {
    
    private final Board board;
    private final List<Joueur> players;
    private Joueur currentPlayer;
    State gameState;

    public Game(List<Joueur> players) {
        this.board = new Board();
        this.players = players;
        this.currentPlayer = players.get(0); //0 will always be WHITE
        gameState = State.PLACE;
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
        if (gameState == State.PLACE) {
            board.addPiece(x, y, this.currentPlayer.getColor(), q);
        }else{
            throw new GameException("You are in the wrong State");
        }
        gameState = State.ROTATE;
    }

//    @Override
//    public void rotationQuadrant(int value) {
//
//    }

    @Override
    public boolean isOver() {
        return gameState == State.OVER;
    }
    
    @Override
    public void setState(State state){
        this.gameState = state;
    }

    @Override
    public Joueur getWinners() {
        if (isOver()) {
            return currentPlayer;
        }else{
            throw new GameException("There is no winner");
        }
    }

    State getState() {
        return gameState;
    }

}
