package G45502.Pentago.view;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author G45502
 */
public class FxQuadrant extends GridPane {

    private GridPane quadrant;
    private final int MAX_SIZE;

    /**
     * Builder of Quadrant
     */
    public FxQuadrant() {
        this.MAX_SIZE = 3;
        initialze();
    }

    private void initialze() {
        quadrant = new GridPane();
        setStyle();
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                quadrant.add(new FxMarble().getCircle(), j, i);
            }
        }
    }

    /**
     * Getter of quadrant
     *
     * @return
     */
    public GridPane getQuadrant() {
        return quadrant;
    }

    private void setStyle() {
        quadrant.setVgap(10);
        quadrant.setHgap(10);
        quadrant.setStyle("-fx-background-color:#ba3030; -fx-opacity:0.5;");

        for (int i = 0; i < MAX_SIZE; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            col.setMinWidth(10);
            col.setPrefWidth(100);
            col.setHalignment(HPos.CENTER);
            quadrant.getColumnConstraints().add(col);
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10);
            row.setPrefHeight(30);
            row.setValignment(VPos.CENTER);
            quadrant.getRowConstraints().add(row);
        }

    }
}
