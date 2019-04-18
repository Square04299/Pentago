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

    private final Facade game;
    private final FxPentago fxView;

    public FxControleur(Facade game, FxPentago fxView) {
        this.game = game;
        this.fxView = fxView;
        game.addObserver(fxView);
    }

    public void startGame(){
        game.addPlayer(new Player("Pass", Marble.WHITE));
        game.addPlayer(new Player("Chris", Marble.BLACK));
        while (!game.isOver()) {            
            game.placePiece(0, 0, 1);
            game.changeCurrentPlayer();
        }
    }
}
