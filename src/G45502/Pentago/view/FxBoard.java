package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Player;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

/**
 *
 * @author G45502
 */
public class FxBoard extends GridPane implements Observer {

    private GridPane board;
    private Text text;
    private final int MAX_SIZE_Quadrant;
    private final int MAX_SIZE_Marble;

    /**
     * Builder of board
     */
    public FxBoard() {
        this.MAX_SIZE_Quadrant = 2;
        this.MAX_SIZE_Marble = 3;
        initialze();
    }

    private void initialze() {
        board = new GridPane();
        setStyle();
        for (int i = 0; i < MAX_SIZE_Quadrant; i++) {
            for (int j = 0; j < MAX_SIZE_Quadrant; j++) {
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
        for (int i = 0; i < MAX_SIZE_Quadrant; i++) {
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

    @Override
    public void update(Observable o, Object arg) {
        Facade game = (Facade) o;
        changeBoard(game);
    }

    private void changeBoard(Facade game) {
        int totalquadrant = MAX_SIZE_Quadrant * MAX_SIZE_Quadrant;
        for (int i = 0; i < totalquadrant; i++) {
            for (int j = 0; j < MAX_SIZE_Quadrant; j++) {
                for (int k = 0; k < MAX_SIZE_Marble; k++) {
                    int color = game.getColorMarble(i,j,k);
                    this.changeColor(i,j,k,color);
                }
            }
        }
    }

    //Add a marble to the GUI, here and in FxQuadrant
    private void changeColor(int quadrant, int x, int y, int color) {
        this.board.getChildren().get(quadrant).
    }
}
