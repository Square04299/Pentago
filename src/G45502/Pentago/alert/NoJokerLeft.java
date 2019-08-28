package G45502.Pentago.alert;

import javafx.scene.control.Alert;

/**
 *
 * @author G45502
 */
public class NoJokerLeft extends Alert {
    
    /**
     * Builder of diaolog box
     */
    public NoJokerLeft() {
        super(Alert.AlertType.INFORMATION);
        this.setTitle("Wrong State");
        this.setHeaderText(null);
        this.setHeaderText("Trying to add mArble with no joker");
        this.setContentText("You don't have any joker left");
    }
}
