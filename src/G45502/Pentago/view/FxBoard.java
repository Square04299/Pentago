package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author G45502
 */
public class FxBoard extends GridPane{

    private final int MAX_SIZE_Quadrant;
    private final int MAX_SIZE_Marble;
    private Facade model;

    /**
     * Builder of board
     * @param model Game
     */
    public FxBoard(Facade model) {
        super();
        this.MAX_SIZE_Quadrant = 2;
        this.MAX_SIZE_Marble = 3;
        this.model = model;
        initialze();
    }

    private void initialze() {
        setStyle();
        for (int i = 0; i < MAX_SIZE_Quadrant; i++) {
            for (int j = 0; j < MAX_SIZE_Quadrant; j++) {
                this.add(new FxQuadrant(model,j+i+i), j, i);
            }
        }
    }

    private void setStyle() {
        this.setVgap(10);
        this.setHgap(10);
        this.setPrefSize(600, 600);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setStyle("-fx-background-color:#000000;");
        for (int i = 0; i < MAX_SIZE_Quadrant; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            col.setMinWidth(10);
            col.setPrefWidth(100);

            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10);
            row.setPrefHeight(30);

            this.getRowConstraints().add(row);
            this.getColumnConstraints().add(col);
        }
    }

    public void updateBoard(Facade game) {
        changeBoard(game);
    }

    private void changeBoard(Facade game) {
        for (int i = 0; i < MAX_SIZE_Quadrant; i++) {
            for (int j = 0; j < MAX_SIZE_Quadrant; j++) {
                for (int k = 0; k < MAX_SIZE_Marble; k++) {
                    for (int l = 0; l < MAX_SIZE_Marble; l++) {
                        int color = game.getColorMarble(j+i+i, k, l);
                        this.changeColor(i, j, l, k, color);
                    }
                }
            }
        }
    }
    
    private void changeColor(int quadrantX, int quadrantY, int x, int y, int color) {
        ObservableList<Node> node = this.getChildren();
        for (Node child : node) {
            if (FxBoard.getRowIndex(child) == quadrantX && FxBoard.getColumnIndex(child) == quadrantY) {
                ((FxQuadrant) child).getCircle(x, y).setColor(color);
            }
        }
    }
}
