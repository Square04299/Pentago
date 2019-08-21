package G45502.Pentago.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Square
 */
public class ParseBoard {

    private Game game;
    private int countW;
    private int countB;
    private List<Marble> parseLine;
    private List<Marble> winner;

    public ParseBoard(Game game) {
        this.game = game;
        this.parseLine = new ArrayList<Marble>();
        this.winner = new ArrayList<Marble>();
    }
    
    public Boolean hasWinner(){
        return winner.isEmpty();
    }

    public List<Marble> getWinner() {
        parseBoard();
        return winner;
    }

    private void vertical(Marble tab[][], Marble tab1[][], int row){
        parseLine.clear();
        for (int i = 0; i < 3; i++) {
            parseLine.add(tab[row][i]);
        }
        for (int i = 0; i < 3; i++) {
            parseLine.add(tab1[row][i]);
        }
        //System.out.println(parseLine.toString());
    }
    
    private void horizontal(Marble tab[][], Marble tab1[][], int col){
        parseLine.clear();
        for (int i = 0; i < 3; i++) {
            parseLine.add(tab[i][col]);
        }
        for (int i = 0; i < 3; i++) {
            parseLine.add(tab1[i][col]);
        }
    }
    
    private Marble validation(){
        countW = 0;
        countB = 0;
        
        for (Marble marble : parseLine) {
            if (marble == Marble.WHITE) {
                countW++;
            }else if(marble == Marble.BLACK){
                countB++;
            }
        }
        if (countW > 4) {
            return Marble.WHITE;
        }else if (countB > 4) {
            return Marble.BLACK;
        }else{
            return Marble.EMPTY;
        }
    }
    
    private void duplicate(){
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < winner.size()-1; j++) {
                if (winner.get(i) == winner.get(j)) {
                    winner.remove(j);
                    j--;
                }
            }
        }
    }
    
    private void parseBoard(){
        for (int i = 0; i < 3; i++) {
            horizontal(game.getBoard().getQuadrant(0).getQuadrant(), game.getBoard().getQuadrant(1).getQuadrant(), i);
            if (validation() != Marble.EMPTY) {
                winner.add(validation());
            }
            
            horizontal(game.getBoard().getQuadrant(2).getQuadrant(), game.getBoard().getQuadrant(3).getQuadrant(), i);
            if (validation() != Marble.EMPTY) {
                winner.add(validation());
            }
            
            vertical(game.getBoard().getQuadrant(0).getQuadrant(), game.getBoard().getQuadrant(2).getQuadrant(), i);
            if (validation() != Marble.EMPTY) {
                winner.add(validation());
            }
            
            vertical(game.getBoard().getQuadrant(1).getQuadrant(), game.getBoard().getQuadrant(3).getQuadrant(), i);
            if (validation() != Marble.EMPTY) {
                winner.add(validation());
            }
        }
        duplicate();
    }
}
