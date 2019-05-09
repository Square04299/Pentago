package G45502.Pentago.controleur;

import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Marble;
import G45502.Pentago.model.Player;
import G45502.Pentago.view.FxPentago;

/**
 *
 * @author Square
 */
public class FxControleur {

    private final Facade model;
    private final FxPentago fxView;

    /**
     * Builder of the View and the game.
     * @param model logic of the game with the rules.
     * @param fxView Graphical view.
     */
    public FxControleur(Facade model, FxPentago fxView) {
        this.model = model;
        this.fxView = fxView;
        model.addObserver(fxView);
    }

    /**
     * Will start the view part of the game,
     * while adding 2 player to the pool of player.
     */
    public void startGame(){
        model.addPlayer(new Player("Player 1", Marble.WHITE));
        model.addPlayer(new Player("Player 2", Marble.BLACK));
        fxView.setPlayer();
    }
}
