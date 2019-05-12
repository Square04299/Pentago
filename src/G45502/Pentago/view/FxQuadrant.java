package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
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
    private final int numberQuadrant;
    private Facade model;

    /**
     * Builder of Quadrant
     *
     * @param model Model of the game
     * @param id id of the quadrant
     */
    public FxQuadrant(Facade model, int id) {
        super();
        this.MAX_SIZE = 3;
        this.model = model;
        this.numberQuadrant = id;
        initialze();
    }

    private void initialze() {
        setStyle();
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                FxMarble marble = new FxMarble(j, i);
                this.add(marble, j, i);
                marble.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
                    FxMarble marbleClicked = (FxMarble) event.getSource();
//                        System.out.println("x " +marbleClicked.getX());
//                        System.out.println("y " +marbleClicked.getY());
//                        System.out.println("Q " +((FxQuadrant)marbleClicked.getParent()).getNumberQuadrant());
                    model.placePiece(marbleClicked.getX(), marbleClicked.getY(), ((FxQuadrant) marbleClicked.getParent()).getNumberQuadrant());
                });
            }
        }
    }

    public int getNumberQuadrant() {
        return numberQuadrant;
    }

    public Facade getModel() {
        return model;
    }

    public FxMarble getCircle(int x, int y) {
        ObservableList<Node> node = this.getChildren();
        for (Node child : node) {
            if (FxQuadrant.getRowIndex(child) == x && FxQuadrant.getColumnIndex(child) == y) {
                return (FxMarble) child;
            }
        }
        return null;
    }

    public void addMarble(Color color) {
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
