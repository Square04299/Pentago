package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Marble;
import java.util.ArrayList;
import java.util.List;
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
public class FxStat extends Stage implements Observer{
    
    private Facade model;
    private Pane pane;
    private GridPane grid;
    private List<Marble> parseLine;
    private int countRow;
    
    public FxStat(Facade model){
        this.pane = new Pane();
        this.grid = new GridPane();
        pane.getChildren().add(grid);
        this.model = model;
        this.parseLine = new ArrayList<>();
        this.countRow = 1;
        this.setTitle("Statistiques");
        
        //Set Close button
        Button exit = new Button("Close");
        exit.setOnAction((t) -> {
            this.close();
        });
        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        Text quadrant1 = new Text();
        quadrant1.setText("Quadrant 1");
        Text quadrant2 = new Text();
        quadrant2.setText("Quadrant 2");
        Text quadrant3 = new Text();
        quadrant3.setText("Quadrant 3");
        Text quadrant4 = new Text();
        quadrant4.setText("Quadrant 4");
        
        grid.addRow(0, quadrant1,quadrant2,quadrant3,quadrant4,exit);
        
        insert();
        this.setScene(new Scene(pane, 400, 300));
    }
    
    void insert(){
            countMarbleQuadrant(model.getQuadrant(0).getQuadrant());
            Text quadrant1 = new Text();
            quadrant1.setText(Integer.toString(parseLine.size()));
            
            countMarbleQuadrant(model.getQuadrant(1).getQuadrant());
            Text quadrant2 = new Text();
            quadrant2.setText(Integer.toString(parseLine.size()));
            
            countMarbleQuadrant(model.getQuadrant(2).getQuadrant());
            Text quadrant3 = new Text();
            quadrant3.setText(Integer.toString(parseLine.size()));
            
            countMarbleQuadrant(model.getQuadrant(3).getQuadrant());
            Text quadrant4 = new Text();
            quadrant4.setText(Integer.toString(parseLine.size()));
            
            grid.addRow(countRow, quadrant1, quadrant2, quadrant3, quadrant4);
            countRow++;
    }
        
    void countMarbleQuadrant(Marble tab[][]){
        parseLine.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                parseLine.add(tab[i][j]);
            }
        }
        removeEmptyMarble();
    }
    
    void removeEmptyMarble(){
        for (int i = 0; i < parseLine.size(); i++) {
            if (parseLine.get(i) == Marble.EMPTY) {
                parseLine.remove(i);
                i--;
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        System.out.println("Update Statistique");
        insert();
        System.out.println("Finished Update Statistique");
    }
    
}
