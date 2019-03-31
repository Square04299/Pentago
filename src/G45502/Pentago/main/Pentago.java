package G45502.Pentago.main;

import G45502.Pentago.controleur.Controleur;
import G45502.Pentago.model.Game;
import G45502.Pentago.view.FxPentago;
import G45502.Pentago.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class Pentago extends Application{
    
    /**
     * Will launch the game with the game and view created
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *  Start the view FxView and Game
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage){
        Game game = new Game();
        View view = new View(game);
        FxPentago fxView = new FxPentago(primaryStage);
        Controleur controleur = new Controleur(game, view, fxView);
        controleur.startGame();
    }
}
