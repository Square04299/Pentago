package G45502.Pentago.alert;

import javafx.scene.control.Alert;

/**
 *
 * @author G45502
 */
public class Help extends Alert {

    public Help() {
        super(AlertType.INFORMATION);
        this.setTitle("Game Help");
        this.setHeaderText(null);
        this.setContentText("Pentago is played on a 6 by 6 board, divided into "
                + "four 3 by 3 quadrants. There are two players, black and "
                + "white, who alternate turns. The goal of each player is to "
                + "get five stones of their color in a row, either "
                + "horizontally, vertically, or diagonally. Each turn, a player"
                + " places a stone in an empty space in some quadrant, then "
                + "chooses a possibly different quadrant to rotate 90 degrees "
                + "left or right. If both players get five in a row at the same "
                + "time, or the last move is played with no five in a row, "
                + "the game is a tie. If a player makes five a row by placing"
                + " a stone, there is no need to rotate a quadrant: the player"
                + " wins immediately.");
    }

}
