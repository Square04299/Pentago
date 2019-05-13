package G45502.Pentago.model;

import G45502.Pentago.alert.EndGame;
import G45502.Pentago.alert.WrongStateAddMarble;
import G45502.Pentago.alert.WrongStateRotate;
import G45502.Pentago.exception.GameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * All method that will help the controleur manage the game
 *
 * @author G45502
 */
public class Game extends Facade {

    private final Board board;
    private final List<Player> players;
    private Player currentPlayer;
    private State gameState;
    private List<Move> move;
    private Move tempMove;
    private int turn;
    //Alerts
    private final WrongStateAddMarble wrongStateMarble;
    private final WrongStateRotate wrongStateRotate;
    private final EndGame endGame;

    /**
     * Builder of Game Creates a Board, Array of players, GameState and the
     * current player
     */
    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.gameState = State.PLACE;
        this.currentPlayer = null;
        this.wrongStateMarble = new WrongStateAddMarble();
        this.wrongStateRotate = new WrongStateRotate();
        this.endGame = new EndGame();
        this.move = new ArrayList<>();
        this.turn = 0;
    }

    /**
     * Getter of board
     *
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter of Move
     *
     * @return
     */
    public List<Move> getMove() {
        return move;
    }

    /**
     * Getter of quadrant
     *
     * @param value Which quadrant to pick
     * @return 2d array of the selected Quadrant
     */
    @Override
    public Quadrant getQuadrant(int value) {
        return board.getQuadrant(value);//.getQuadrant();
    }

    /**
     * Getter of Players
     *
     * @return List of all players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Getter State of the game
     *
     * @return State of the game (Place, Rotate, Over)
     */
    public State getGameState() {
        return gameState;
    }

    /**
     * Set the color of the marble in the view when adding player to the list
     *
     * @return White of the list of player is empty, Black if at least 1 player
     * is in the list of Players
     */
    @Override
    public Marble setColor() {
        if (players.isEmpty()) {
            return Marble.WHITE;
        } else {
            return Marble.BLACK;
        }
    }

    /**
     * Add specific player to the list of all players
     *
     * @throws GameException if the list of player exceeds 2
     * @param player player to add
     */
    @Override
    public void addPlayer(Player player) {
        Objects.requireNonNull(player);
        if (getPlayers().size() > 2) {
            throw new GameException("Too much player");
        }
        players.add(player);
        this.currentPlayer = players.get(0);//0 will always be WHITE
    }

    /**
     * Get the currentPlayer
     *
     * @return Current Player
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Will change the current player If the current player is White it will
     * change the currentPlayer to the player that has the black marble same
     * thing will happening in the opposite way
     */
    @Override
    public void changeCurrentPlayer() {
        if (!isOver()) {
            if (this.currentPlayer.isWhite()) {
                this.currentPlayer = this.currentPlayer.getPlayer(players, Marble.BLACK);
            } else {
                this.currentPlayer = this.currentPlayer.getPlayer(players, Marble.WHITE);
            }
            gameState = State.PLACE;
        }
    }

    /**
     * Place a marble at the x,y and quadrant position The marble placed will be
     * the one of the current player
     *
     * @param x x axis
     * @param y y axis
     * @param q Quadrant
     */
    @Override
    public void placePiece(int x, int y, int q) {
        if (gameState == State.OVER) {
            endGame.showAndWait();
        } else if (gameState == State.ROTATE) {
            wrongStateMarble.showAndWait();
            throw new GameException("You are in the wrong State " + gameState);
        } else {
            System.out.println("Grey Placed");
            board.addPiece(x, y, this.currentPlayer.getColor(), q);
            //currentPlayer.setTurn();
            this.tempMove = new Move(this.currentPlayer.getColor(), x, y, q);
            this.setState(State.ROTATE);
            setChanged();
            notifyObservers("A marble has been added to the board");
        }
    }

    /**
     * Will Rotate the "value" Quadrant to the right
     *
     * @param value
     */
    @Override
    public void rotationQuadrantRight(int value) {
        if (gameState == State.OVER) {
            endGame.showAndWait();
        } else if (gameState == State.PLACE) {
            wrongStateRotate.showAndWait();
            throw new GameException("You are in the wrong State " + gameState);
        } else {
            this.board.getQuadrant(value).rotateRight();
            tempMove.setRotation("Right");
            move.add(tempMove);
            tempMove = null;
            this.setState(State.PLACE);
            isOver();
            changeCurrentPlayer();
            setChanged();
            notifyObservers("One of the quadrant has rotated to the left");
        }
    }

    /**
     * Will Rotate the "value" Quadrant to the left
     *
     * @param value Which quadrant to rotate
     */
    @Override
    public void rotationQuadrantLeft(int value) {
        if (gameState == State.OVER) {
            endGame.showAndWait();
        } else if (gameState == State.PLACE) {
            wrongStateRotate.showAndWait();
            throw new GameException("You are in the wrong State " + gameState);
        } else {
            this.board.getQuadrant(value).rotateLeft();
            tempMove.setRotation("Left");
            move.add(tempMove);
            tempMove = null;
            this.setState(State.PLACE);
            isOver();
            changeCurrentPlayer();
            setChanged();
            notifyObservers("One of the quadrant has rotated to the left");
        }
    }

    /**
     * Check if the state of the game is STATE.OVER
     *
     * @return true if STATE.OVER
     */
    @Override
    public boolean isOver() {
        if (!this.getBoard().isFreePlaceOnBoard()
                || (this.getQuadrant(0).getPoint(0, 0) == Marble.BLACK
                || this.getQuadrant(0).getPoint(0, 0) == Marble.WHITE)) {
            this.setState(State.OVER);
        }
        return gameState == State.OVER;
    }

    /**
     * Setter of the State
     *
     * @param state will change the state with this value
     */
    @Override
    public void setState(State state) {
        this.gameState = state;
    }

    /**
     * Get the winner by looking if a marble has been placed in the x=0, y=0 and
     * quadrant(0)
     *
     * @return the currentPlayer, meaning the player that just played if the
     * condition are right he will be selected otherwise it will just ignore and
     * continue the logic of the game
     */
    @Override
    public Player getWinners() {
        if (isOver()
                || (board.getQuadrant(0).getPoint(0, 0) == Marble.BLACK
                || board.getQuadrant(0).getPoint(0, 0) == Marble.WHITE)) {
            if (board.getQuadrant(0).getPoint(0, 0) == Marble.WHITE) {
                return players.get(0);
            } else if (board.getQuadrant(0).getPoint(0, 0) == Marble.BLACK) {
                return players.get(1);
            }
        }
        return null;
    }

    /**
     * Return the value of the marble at the quadrant, position x and y
     *
     * @param i Quadrant
     * @param j X axis
     * @param k Y axis
     * @return -1 if the color is null, 0 for black and 1 for white
     */
    @Override
    public int getColorMarble(int i, int j, int k) {
        Marble marble = this.board.getQuadrant(i).getPoint(j, k);
        if (marble == Marble.EMPTY) {
            return -1;
        }
        return marble.getValue();
    }
}
