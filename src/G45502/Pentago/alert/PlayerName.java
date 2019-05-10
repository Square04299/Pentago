package G45502.Pentago.alert;

import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Marble;
import G45502.Pentago.model.Player;
import java.util.Optional;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * Alert to ask the player named Source :
 * https://code.makery.ch/blog/javafx-dialogs-official/
 *
 * @author G45502
 */
public class PlayerName {

    private Facade model;
    private boolean bPlayer1 = false;
    private boolean bPlayer2 = false;
    private Node loginButton;

    public PlayerName(Facade model) {
        this.model = model;

// Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Players");
        dialog.setHeaderText("Name of both player");

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Start Game", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType);

// Create the player1 and player2 labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField player1 = new TextField();
        player1.setPromptText("Player 1");
        TextField player2 = new TextField();
        player2.setPromptText("Player 2");

        grid.add(new Label("Player 1 : "), 0, 0);
        grid.add(player1, 1, 0);
        grid.add(new Label("Player 2 : "), 0, 1);
        grid.add(player2, 1, 1);

// Enable/Disable login button depending on whether a player1 was entered.
        loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
//Player 1 field
        player1.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                bPlayer1 = true;
                validation();
            }else{
                bPlayer1 = false;
            }
        });
//Player 2 field
        player2.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                bPlayer2 = true;
                validation();
            }else{
                bPlayer2 = false;
            }
        });
        
        dialog.getDialogPane().setContent(grid);

// Request focus on the player1 field by default.
        Platform.runLater(() -> player1.requestFocus());

// Convert the result to a player1-player2-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(player1.getText(), player2.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            model.addPlayer(new Player(usernamePassword.getKey(), Marble.WHITE));
            model.addPlayer(new Player(usernamePassword.getValue(), Marble.BLACK));
        });
    }
    
    void validation(){
        //Validation that the 2 field has been filled
        if (bPlayer1 && bPlayer2) {
            loginButton.setDisable(false);
        }
    }
}
