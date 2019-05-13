package G45502.Pentago.alert;

import javafx.scene.control.Alert;

/**
 * Display that the game is over
 * @author G45502
 */
public class EndGame extends Alert {

    /**
     *
     */
    public EndGame() {
        super(AlertType.ERROR);
        this.setTitle("End of the Game");
        this.setHeaderText("Ooops, there was an error!");
        this.setContentText("The game as ended, you can't interact with the board");
    }
}
