package G45502.Pentago.view;

import G45502.Pentago.alert.Help;
import G45502.Pentago.model.Facade;
import G45502.Pentago.model.Marble;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
    private String currentPlayerName, marbleColor,joker;
    private Text text, text1, text2, tPlayerName, tMarbleColor, tJoker;
    private ToggleGroup group;
    private RadioButton one, two, three, four;
    private Button left, right, help, quit, historiqueB, statB;
    private Help helpAlert;
    private FxHistorique historique;
    private FxStat stat;

    /**
     * Builder of the left side with all the information a player needs
     *
     * @param model
     */
    public FxInfo(Facade model) {
        super(10);
        this.model = model;
        initialize();
    }

    private void initialize() {
        text = new Text(20, 20, "Current player");
        tPlayerName = new Text();
        text1 = new Text(20, 20, "Marble Color");
        text2 = new Text(20,20,"Joker");
        tMarbleColor = new Text();
        tJoker = new Text();
        group = new ToggleGroup();
        one = new RadioButton("1");
        two = new RadioButton("2");
        three = new RadioButton("3");
        four = new RadioButton("4");

        one.setToggleGroup(group);
        two.setToggleGroup(group);
        three.setToggleGroup(group);
        four.setToggleGroup(group);
        group.selectToggle(one);

        left = new Button("Turn Left");
        right = new Button("Turn Right");
        help = new Button("Help");
        helpAlert = new Help();
        quit = new Button("Quit");
        //interro 1
        this.historique = new FxHistorique(model);
        model.addObserver(historique);
        historiqueB = new Button("Historique");
        //interro 2
        this.stat = new FxStat(model);
        model.addObserver(stat);
        statB = new Button("Statistique");

        left.setOnAction((ActionEvent t) -> {
            RadioButton selected = (RadioButton) group.getSelectedToggle();
            int num = Integer.parseInt(selected.getText()) - 1;
            model.rotationQuadrantLeft(num);
        });
        right.setOnAction((ActionEvent t) -> {
            RadioButton selected = (RadioButton) group.getSelectedToggle();
            int num = Integer.parseInt(selected.getText()) - 1;
            model.rotationQuadrantRight(num);
        });

        help.setOnAction((ActionEvent t) -> {
            helpAlert.showAndWait();
        });

        quit.setOnAction((ActionEvent t) -> {
            Platform.exit();
        });

        historiqueB.setOnAction((ActionEvent t) -> {
            FxHistorique temp = new FxHistorique(model);
            temp.show();
        });
        
        statB.setOnAction(((ActionEvent t) -> {
            FxStat temp = new FxStat(model);
            temp.show();
        }));
        

        this.getChildren().addAll(text, tPlayerName, text1, tMarbleColor, text2, tJoker ,one,
                two, three, four, left, right, historiqueB, statB, help, quit);
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
        if (model.getTurn() < 2) {
            this.marbleColor = Marble.GREY.toString();
        }else{
            this.marbleColor = model.getCurrentPlayer().getColor().toString();
        }
        this.joker = Boolean.toString(model.getCurrentPlayer().getJoker());
    }

    void playerData() {
        tPlayerName.setText(currentPlayerName);
        tMarbleColor.setText(marbleColor);
        tJoker.setText(joker);
    }
}
