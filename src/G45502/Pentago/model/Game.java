package G45502.Pentago.model;

import G45502.Pentago.exception.GameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author G45502
 */
public class Game implements Facade {

    private final Board board;
    private final List<Player> players;
    private Player currentPlayer;
    private State gameState;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.gameState = State.PLACE;
    }

    public Board getBoard() {
        return board;
    }

    public int[][] getQuadrant(int value) {
        return board.getQuadrant(value).getQuadrant();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public State getGameState() {
        return gameState;
    }
    
    public Marble setColor(){
        if (players.isEmpty()) {
            return Marble.WHITE;
        }else{
            return Marble.BLACK;
        }
    }
    
    @Override
    public void addPlayer(Player player) {
        if (getPlayers().size() < 2) {
            players.add(player);
        } else {
            throw new GameException("Too much player");
        }
        this.currentPlayer = players.get(0);//0 will always be WHITE
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
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
        } else {
            throw new GameException("You are in the wrong State");
        }
        gameState = State.ROTATE;
    }

    @Override
    public void rotationQuadrantRight(int value) {
        if (gameState == State.ROTATE) {
            this.board.getQuadrant(value).rotateRight();
        }
        gameState = State.PLACE;
    }

    @Override
    public void rotationQuadrantLeft(int value) {
        if (gameState == State.ROTATE) {
            this.board.getQuadrant(value).rotateLeft();
        }
        gameState = State.PLACE;
    }

    @Override
    public boolean isOver() {
        return gameState == State.OVER;
    }

    @Override
    public void setState(State state) {
        this.gameState = state;
    }

    @Override
    public Player getWinners() {
        if (isOver()) {
            return currentPlayer;
        } else {
            throw new GameException("There is no winner");
        }
    }
}
