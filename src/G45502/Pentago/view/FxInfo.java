package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author G45502
 */
public class FxInfo extends VBox implements Observer {

    private Facade model;
    private String currentPlayerName, marbleColor;
    private Text tPlayerName, tMarbleColor;
    private ToggleGroup group;
    private RadioButton one, two, three, four;
    private Button left, right;
    

    public FxInfo(Facade model) {
        super(10);
        this.model = model;
        initialize();
    }

    private void initialize() {
        Text text = new Text(20, 20, "Current player");
        tPlayerName = new Text();
        Text text1 = new Text(20, 20, "Marble Color");
        tMarbleColor = new Text();
        group = new ToggleGroup();
        one = new RadioButton("1");
        two = new RadioButton("2");
        three = new RadioButton("3");
        four = new RadioButton("4");
        
        one.setToggleGroup(group);
        two.setToggleGroup(group);
        three.setToggleGroup(group);
        four.setToggleGroup(group);
        
        left = new Button("Turn Left");
        right = new Button("Turn Right");
        
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                int num = Integer.parseInt(selected.getText()) - 1;
                model.rotationQuadrantLeft(num);
                group.selectToggle(null);
            }
        });
        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                int num = Integer.parseInt(selected.getText()) - 1;
                model.rotationQuadrantRight(num);
                group.selectToggle(null);
            }
        });
        
        this.getChildren().addAll(text,tPlayerName,text1,tMarbleColor,one,two,three,four,left,right);
    }

    @Override
    public void update(Observable o, Object arg) {
        model = (Facade) o;
        System.out.println("Update Fxinfo");
        initData();
        playerData();
    }

    void initData() {
        this.currentPlayerName = model.getCurrentPlayer().getName();
        this.marbleColor = model.getCurrentPlayer().getColor().toString();
    }
    
    void playerData(){
        tPlayerName.setText(currentPlayerName);
        tMarbleColor.setText(marbleColor);
    }

}