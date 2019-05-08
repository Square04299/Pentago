package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Marble;
import G45502.Pentago.model.Player;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author G45502
 */
public class FxInfo extends VBox implements Observer {

    private Facade model;
    private String currentPlayerName;
    private Marble marbleColor;
    

    public FxInfo(Facade model) {
        super();
        System.out.println("Super");
        this.model = model;
        System.out.println("Model");
        //this.currentPlayerName = model.getCurrentPlayer().getName();
        System.out.println("Name");
        //this.marbleColor = model.getCurrentPlayer().getColor();
        System.out.println("Color");
        initialize();
    }

    private void initialize() {
        Text text = new Text(20, 20, "Current player");
        Text tPlayerName = new Text();
        Text text1 = new Text(20, 20, "Marble Color");
        Text tMarbleColor = new Text();
        System.out.println(marbleColor);
        this.getChildren().addAll(text,tPlayerName,text1,tMarbleColor);
    }

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        System.out.println("Update Fxinfo");
        System.out.println(arg);
    }

}
