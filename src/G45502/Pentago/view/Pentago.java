package G45502.Pentago.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class Pentago extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Board board = new Board();
        stage.setTitle("Pentago");
        
        Scene primaryScene = new Scene(board, 600, 600);
        stage.setScene(primaryScene);
        stage.show();
    }
}
