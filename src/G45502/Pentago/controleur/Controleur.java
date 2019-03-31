package G45502.Pentago.controleur;

import G45502.Pentago.exception.GameException;
import G45502.Pentago.model.Game;
import G45502.Pentago.model.State;
import G45502.Pentago.view.View;

/**
 *
 * @author G45502
 */
public class Controleur {

    private final Game game;
    private final View view;

    /**
     * Builder of Controleur
     *
     * @param game
     * @param view
     */
    public Controleur(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Start the game
     */
    public void startGame() {
        while (game.getPlayers().size() < 2) {
            game.addPlayer(view.askPlayer());
        }
        while (!game.isOver()) {
            view.viewBoard();
            placePiece();
            view.askRotate();
            if (!game.getBoard().isFreePlaceOnBoard() || (game.getBoard().getQuadrant(0).getPoint(0, 0) == 0 || game.getBoard().getQuadrant(0).getPoint(0, 0) == 1)) {
                game.setState(State.OVER);
            }
            if (!game.isOver()) {
                game.changeCurrentPlayer();
            }
        }
        view.showWinner(game.getWinners());
    }

    /**
     * Validate the insertion of the piece
     */
    public void placePiece() {
        try {
            game.placePiece(view.askX(), view.askY(), view.askQuadrant());
        } catch (GameException ex) {
            view.placePieceError();
            placePiece();
        }
    }

}
