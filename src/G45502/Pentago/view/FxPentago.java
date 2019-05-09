package G45502.Pentago.view;

import G45502.Pentago.alert.Win;
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
public final class FxPentago implements Observer {

    private Scene scene;
    private FxBoard board;
    private Facade model;
    private FxInfo info;

    /**
     * Builder thats will start the stage and will add the model to it
     * @param model
     * @param stage 
     */
    public FxPentago(Facade model, Stage stage) {
        this.model = model;
        start(stage);
    }
    

    public void start(Stage stage) {
        board = new FxBoard(model);
        info = new FxInfo(model);
        model.addObserver(info);
        stage.setTitle("Pentago");
        //stage.setResizable(false);
        SplitPane root = new SplitPane();
        root.setDividerPositions(0.3);
        AnchorPane rightPane = new AnchorPane();
        AnchorPane leftPane = new AnchorPane();
        leftPane.prefHeight(160);
        leftPane.prefWidth(100);
        rightPane.prefHeight(160);
        rightPane.prefWidth(100);

        root.getItems().addAll(leftPane, rightPane);
        leftPane.getChildren().add(info);
        rightPane.getChildren().add(board);

        scene = new Scene(root, 830, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    public void setPlayer(){
        info.initData();
        info.playerData();
    }

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        System.out.println("Update FxView");
        System.out.println(arg);
        if (model.isOver()) {
            board.updateBoard(model);
            Win win = new Win(model);
            win.showAndWait();
        }
        board.updateBoard(model);
    }
}
