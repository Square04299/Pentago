package G45502.Pentago.alert;

import javafx.scene.control.Alert;

/**
 *
 * @author G45502
 */
public class WrongStateRotate extends Alert {

    public WrongStateRotate() {
        super(AlertType.INFORMATION);
        this.setTitle("Wrong State");
        this.setHeaderText(null);
        this.setHeaderText("You are trying rotate a quadrant when you already did that");
        this.setContentText("The next player needs to add a marble to the board");
    }
}
