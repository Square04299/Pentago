package G45502.Pentago.alert;

import javafx.scene.control.Alert;

/**
 * alert of the player try to place a second marble
 *
 * @author G45502
 */
public class WrongStateAddMarble extends Alert {

    /**
     * Builder of diaolog box
     */
    public WrongStateAddMarble() {
        super(AlertType.INFORMATION);
        this.setTitle("Wrong State");
        this.setHeaderText(null);
        this.setHeaderText("You are trying to add a second marble to the board");
        this.setContentText("Now you need to rotate the quadrant using "
                + "the 1,2,3,4 and the button on the left side");
    }
}
