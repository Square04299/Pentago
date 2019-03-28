package G45502.Pentago.view;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author G45502
 */
public class Board extends GridPane {

    private GridPane board;
    private final int MAX_SIZE = 2;

    public Board() {
        initialze();
    }

    private void initialze() {
        board = new GridPane();
        setStyle();
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                board.add(new Quadrant().getQuadrant(), j, i);
            }
        }
    }

    public GridPane getBoard() {
        return board;
    }

    private void setStyle() {
        board.setVgap(10);
        board.setHgap(10);
        board.setPrefSize(600, 600);
        board.setStyle("-fx-background-color:#000000;");
        for (int i = 0; i < MAX_SIZE; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            col.setMinWidth(10);
            col.setPrefWidth(100);
            board.getColumnConstraints().add(col);
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10);
            row.setPrefHeight(30);
            board.getRowConstraints().add(row);
        }
    }
}
