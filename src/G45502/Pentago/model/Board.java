package G45502.Pentago.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G45502
 */
public class Board {
    private List quadrant;

    public Board() {
        this.quadrant = new ArrayList();
        for (int i = 0; i < 4; i++) {
            this.quadrant.add(new Quadrant());
        }
    }
    
    
}
