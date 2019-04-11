package G45502.Pentago.view;

import G45502.Pentago.model.Player;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

/**
 *
 * @author G45502
 */
public class FxBoard extends GridPane {

    private GridPane board;
    private Text text;
    private final int MAX_SIZE;

    /**
     * Builder of board
     */
    public FxBoard() {
        this.MAX_SIZE = 2;
        initialze();
    }

    private void initialze() {
        board = new GridPane();
        setStyle();
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                board.add(new FxQuadrant().getQuadrant(), j, i);
            }
        }
        text = new Text(0, 620, "Player that is playing : ");
    }

    /**
     * Getter of Board
     *
     * @return board
     */
    public GridPane getBoard() {
        return board;
    }
    
    /**
     * Getter of Board
     *
     * @return board
     */
    public Text getText() {
        return text;
    }
    
    void setText(Player currentPlayer) {
        this.text.setText("Player that is playing : " + currentPlayer.getName());
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
            
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            row.setMinHeight(10);
            row.setPrefHeight(30);
            
            board.getRowConstraints().add(row);
            board.getColumnConstraints().add(col);
        }
    }
}
