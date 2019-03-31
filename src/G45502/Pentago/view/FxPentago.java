package G45502.Pentago.view;


import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class FxPentago{

    private final Stage stage;
    final private Scene scene;
    private final FxBoard board;
    
    /**
     * Start the Gui
     *
     * @param primaryStage Main scene
     */
    public FxPentago(Stage primaryStage) {
        this.stage = primaryStage;
        
        board = new FxBoard();
        primaryStage.setTitle("Pentago");
        primaryStage.setResizable(false);
        Pane root = new Pane();
        root.getChildren().addAll(board.getBoard(), board.getText());

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
