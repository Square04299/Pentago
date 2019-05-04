package G45502.Pentago.main;

import G45502.Pentago.controleur.Controleur;
import G45502.Pentago.controleur.FxControleur;
import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Game;
import G45502.Pentago.view.FxPentago;
import G45502.Pentago.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class Pentago extends Application {

    /**
     * Start the view and Game
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Facade game = new Game();
        //View view = new View(game);
        FxPentago fxView = new FxPentago(game,stage);
        //Controleur controleur = new Controleur(game, view);
        FxControleur fxcontroleur = new FxControleur(game, fxView);
        //controleur.startGame();
        fxcontroleur.startGame();
    }
}
