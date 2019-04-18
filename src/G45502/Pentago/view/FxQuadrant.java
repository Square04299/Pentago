package G45502.Pentago.view;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author G45502
 */
public class FxQuadrant extends GridPane {
    
    private final int MAX_SIZE;

    /**
     * Builder of Quadrant
     */
    public FxQuadrant() {
        super();
        this.MAX_SIZE = 3;
        initialze();
    }

    private void initialze() {
        setStyle();
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                this.add(new FxMarble(), j, i);
            }
        }
    }

    /**
     * Getter of quadrant
     *
     * @return
     */
    public GridPane getQuadrant() {
        return this;
    }
    
    public FxMarble getCircle(int x, int y){
        ObservableList<Node> node = this.getChildren();
        for (Node child : node) {
            if (this.getRowIndex(child) == x && this.getColumnIndex(child) == y) {
                return (FxMarble)child;
            }
        }
        return null;
    }
    
    public void addMarble(Color color){
        this.getChildren().get(REMAINING);
    }

    private void setStyle() {
        this.setVgap(10);
        this.setHgap(10);
        this.setStyle("-fx-background-color:#ba3030; -fx-opacity:0.5;");

        for (int i = 0; i < MAX_SIZE; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            col.setMinWidth(10);
            col.setPrefWidth(100);
            col.setHalignment(HPos.CENTER);
            
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10);
            row.setPrefHeight(30);
            row.setValignment(VPos.CENTER);
            
            this.getRowConstraints().add(row);
            this.getColumnConstraints().add(col);
        }
    }
}
