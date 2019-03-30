package G45502.Pentago.model;

import G45502.Pentago.exception.UnavailablePlace;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G45502
 */
public class Board {
    private final List<Quadrant> board;

    public Board() {
        this.board = new ArrayList();
        for (int i = 0; i < 4; i++) {
            this.board.add(new Quadrant());
        }
    }
    
    public Quadrant getQuadrant(int value){
        if (value < 0 || value > 4) {
            throw new UnavailablePlace("The Number you gave is out of bound from the list");
        }else{
            return this.board.get(value);
        }
    }
    
    void addPiece(int x, int y, Marble c, int q){
        this.getQuadrant(q).addPiece(x, y, c);
    }
    
    boolean isEmptyQuadrant(int value){
        Quadrant empty = this.getQuadrant(value);
        return empty.isEmpty();
    }
    
    public boolean isFreePlaceOnBoard(){
        for (int i = 0; i < 4; i++) {
            if(this.isEmptyQuadrant(i)){
                return true;
            }
        }
        return false;
    }
}
