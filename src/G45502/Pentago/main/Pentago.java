package G45502.Pentago.main;

import G45502.Pentago.controleur.Controleur;
import G45502.Pentago.model.Game;
import G45502.Pentago.view.View;

/**
 *
 * @author Square
 */
public class Pentago {
    
    /**
     * Will launch the game with the game and view created
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);
        Controleur controleur = new Controleur(game, view);
        controleur.startGame();

    }
}
