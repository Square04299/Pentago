package G45502.Pentago.alert;

import G45502.Pentago.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Pair;

/**
 *
 * @author G45502
 */
public class Historique extends Alert implements Observer {

    private Facade model;
    private GridPane grid;

    /**
     * Builder of diaolog box
     */
    public Historique() {
        super(AlertType.INFORMATION);
        this.grid = new GridPane();
        this.getDialogPane().setContent(grid);
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Historique");
        this.setHeaderText(null);

        // Set the button types.
        ButtonType exit = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(exit);

        // Create the username and password labels and fields.
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

        grid.addRow(0, color, x, y, quadrant, roation);

    }

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        System.out.println("Update Historique");
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

}
