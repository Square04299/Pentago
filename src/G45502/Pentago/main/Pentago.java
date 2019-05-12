package G45502.Pentago.main;

import G45502.Pentago.controleur.FxControleur;
import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Game;
import G45502.Pentago.view.FxPentago;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class Pentago extends Application {

    /**
     * Start the view and Game
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start the stage and add the game to the stage.
     *
     * @param stage Stage where the scene will be added to.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Facade game = new Game();
        FxPentago fxView = new FxPentago(game, stage);
        FxControleur fxcontroleur = new FxControleur(game, fxView);
        fxcontroleur.startGame();
    }
}
