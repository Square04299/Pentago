package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class FxPentago extends Application implements Observer {

    private Scene scene;
    private FxBoard board;
    private Facade model;

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
        board = new FxBoard(model);
        stage.setTitle("Pentago");
        //stage.setResizable(false);
        //new
        SplitPane root = new SplitPane();
        root.setDividerPositions(0.3);
        AnchorPane rightPane = new AnchorPane();
        AnchorPane leftPane = new AnchorPane();
        leftPane.prefHeight(160);
        leftPane.prefWidth(100);
        leftPane.setStyle("-fx-background-color:#000000;");
        rightPane.prefHeight(160);
        rightPane.prefWidth(100);

        root.getItems().addAll(leftPane, rightPane);
        //leftPane.getChildren().addAll(); TO-DO
        rightPane.getChildren().add(board);

        scene = new Scene(root, 830, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        board.updateBoard(model);
    }
}
