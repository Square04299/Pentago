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

    public FxControleur(Facade model, FxPentago fxView) {
        this.model = model;
        this.fxView = fxView;
        model.addObserver(fxView);
    }

    public void startGame(){
        model.addPlayer(new Player("Player 1", Marble.WHITE));
        model.addPlayer(new Player("Player 2", Marble.BLACK));
        fxView.setPlayer();
    }
}
