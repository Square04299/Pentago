package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class FxPentago implements Observer {

    private Scene scene;
    private FxBoard board;
    private Facade model;
    private FxInfo info;

    public FxPentago(Facade model, Stage stage) {
        this.model = model;
        start(stage);
    }
    

    public void start(Stage stage) {
        board = new FxBoard(model);
        //info = new FxInfo(model);
        stage.setTitle("Pentago");
        //stage.setResizable(false);
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
        //leftPane.getChildren().add(info);
        rightPane.getChildren().add(board);

        scene = new Scene(root, 830, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        System.out.println("Update FxView");
        System.out.println(arg);
        board.updateBoard(model);
    }
}
