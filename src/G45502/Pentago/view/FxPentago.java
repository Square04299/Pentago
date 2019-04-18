package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class FxPentago extends Application implements Observer {

    private Scene scene;
    private FxBoard board;

    /**
     * Will launch the game with the game and view created
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        board = new FxBoard();
        stage.setTitle("Pentago");
        stage.setResizable(false);
        Pane root = new Pane();
        //root.setCenter(board);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().addAll(board, board.getText());
        
        scene = new Scene(root,600,600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update(Observable o, Object arg) {
        Facade game = (Facade) o;
        board.updateBoard(game);
    }
}
