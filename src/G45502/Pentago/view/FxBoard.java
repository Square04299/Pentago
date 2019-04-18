package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Player;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

/**
 *
 * @author G45502
 */
public class FxBoard extends GridPane{

    private Text text;
    private final int MAX_SIZE_Quadrant;
    private final int MAX_SIZE_Marble;

    /**
     * Builder of board
     */
    public FxBoard() {
        super();
        this.MAX_SIZE_Quadrant = 2;
        this.MAX_SIZE_Marble = 3;
        initialze();
    }

    private void initialze() {
        setStyle();
        for (int i = 0; i < MAX_SIZE_Quadrant; i++) {
            for (int j = 0; j < MAX_SIZE_Quadrant; j++) {
                this.add(new FxQuadrant().getQuadrant(), j, i);
            }
        }
        text = new Text(0, 620, "Player that is playing : ");
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
        this.setVgap(10);
        this.setHgap(10);
        this.setPrefSize(600, 600);
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
                        int color = game.getColorMarble(i+j, k, l);
                        this.changeColor(i, j, k, l, color);
                    }
                }
            }
        }
    }
    
    private void changeColor(int quadrantX, int quadrantY, int x, int y, int color) {
        ObservableList<Node> node = this.getChildren();
        for (Node child : node) {
            if (this.getRowIndex(child) == quadrantX && this.getColumnIndex(child) == quadrantY) {
                ((FxQuadrant) child).getCircle(x, y).setColor(color);
            }
        }
    }
}
