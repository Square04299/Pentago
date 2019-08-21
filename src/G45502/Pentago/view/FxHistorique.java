package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author G45502
 */
public class FxHistorique extends Stage implements Observer{
    
    private Facade model;
    private Pane pane;
    private GridPane grid;

    public FxHistorique(Facade model) {
        this.pane = new Pane();
        this.grid = new GridPane();
        pane.getChildren().add(grid);
        this.model = model;
        this.setTitle("Historique");

        // Set the button types.
        //ButtonType exit = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        Button exit = new Button("Close");
        exit.setOnAction((t) -> {
            this.close();
        });
        //dialog.getDialogPane().getButtonTypes().addAll(exit);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        Text color = new Text();
        color.setText("Color");
        Text x = new Text();
        x.setText("X");
        Text y = new Text();
        y.setText("Y");
        Text quadrant = new Text();
        quadrant.setText("Quadrant");
        Text roation = new Text();
        roation.setText("Roation");

        grid.addRow(0, color, x, y, quadrant, roation, exit);
        
        insert();
        this.setScene(new Scene(pane, 300, 300));
    }
    
    void insert(){
        for (int i = 0; i < model.getMove().size(); i++) {
            Text color = new Text();
            color.setText(model.getMove().get(i).getMarble().toString());
            Text x = new Text();
            x.setText(Integer.toString(model.getMove().get(i).getX()));
            Text y = new Text();
            y.setText(Integer.toString(model.getMove().get(i).getY()));
            Text quadrant = new Text();
            quadrant.setText(Integer.toString(model.getMove().get(i).getQuadrant() + 1));
            Text rotation = new Text();
            rotation.setText(model.getMove().get(i).getRotation());

            grid.addRow(i + 1, color, x, y, quadrant, rotation);
        }
    }
    
    

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        System.out.println("Update Historique");
        insert();
        System.out.println("Finished Update Historique");
    }
    
}
