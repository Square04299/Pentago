package G45502.Pentago.alert;

import G45502.Pentago.model.Facade;
import javafx.scene.control.Alert;

/**
 *
 * @author G45502
 */
public class Win extends Alert {

    private Facade model;

    public Win(Facade model) {
        super(Alert.AlertType.INFORMATION);
        //super(AlertType.CONFIRMATION);
        this.model = model;
        this.setTitle("ScoreBoard");
        this.setHeaderText("Player/Players that got 5 marble in a row");
        this.setContentText(model.getWinners().getName());

//        Optional<ButtonType> result = this.showAndWait();
//        if (result.get() == ButtonType.OK) {
//            Platform.exit();
//        } else {
//            Platform.exit();
//        }
    }
}
