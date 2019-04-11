package G45502.Pentago.main;

import G45502.Pentago.controleur.Controleur;
import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Game;
import G45502.Pentago.view.View;

/**
 *
 * @author G45502
 */
public class Pentago {

    /**
     * Start the view and Game
     * @param args
     */
    public static void main(String[] args) {
        Facade game = new Game();
        View view = new View(game);
        Controleur controleur = new Controleur(game, view);
        controleur.startGame();
    }
}
