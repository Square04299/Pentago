package G45502.Pentago.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class FxPentago extends Application {

    /**
     * Will launch the game with the game and view created
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Show when the Gui stops
     *
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stopping GUI");
    }

    /**
     * Show when Gui starts
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Starting GUI");
    }

    /**
     * Start the Gui
     *
     * @param primaryStage Main scene
     */
    @Override
    public void start(Stage primaryStage) {
        FxBoard board = new FxBoard();
        primaryStage.setTitle("Pentago");
        Pane root = new Pane();
        root.getChildren().add(board.getBoard());

        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

    }

}
