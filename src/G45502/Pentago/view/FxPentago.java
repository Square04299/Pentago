package G45502.Pentago.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class FxPentago extends Application{

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stopping GUI");
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Starting GUI");
    }
    
        
    
    @Override
    public void start(Stage primaryStage){
        FxBoard board = new FxBoard();
        primaryStage.setTitle("Pentago");
        Pane root = new Pane();
        root.getChildren().add(board.getBoard());
        
        
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

    }
    
    
}
