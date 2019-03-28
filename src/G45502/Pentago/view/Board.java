package G45502.Pentago.view;

import javafx.scene.layout.GridPane;

/**
 *
 * @author G45502
 */
public class Board extends GridPane{
    
    private GridPane board;

    public Board() {
        System.out.println("Board");
        initialze();
    }

    private void initialze() {
        board = new GridPane();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                add(new Quadrant(), j, i);
            }
        }
    }
    
    
    
}
