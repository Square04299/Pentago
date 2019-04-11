package G45502.Pentago.controleur;

import G45502.Pentago.exception.UnavailablePlace;
import G45502.Pentago.model.Facade;
import G45502.Pentago.view.View;

/**
 *
 * @author G45502
 */
public class Controleur {

    private final Facade game;
    private final View view;

    /**
     * Builder of Controleur
     *
     * @param game controle the flow of the game
     * @param view show the player what is need to do
     */
    public Controleur(Facade game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Start the game
     */
    public void startGame() {
        game.addPlayer(view.askPlayer());
        game.addPlayer(view.askPlayer());
        while (!game.isOver()) {
            view.viewBoard();
            placePiece();
            view.askRotate();
            game.changeCurrentPlayer();
        }
        view.viewBoard();
        view.showWinner(game.getWinners());
    }

    /**
     * Validate the insertion of the piece
     */
    public void placePiece() {
        try {
            int x = view.askX();
            int y = view.askY();
            int q = view.askQuadrant();
            game.placePiece(x, y, q);
        } catch (UnavailablePlace ex) {
            view.placePieceError();
            placePiece();
        }
    }

}
