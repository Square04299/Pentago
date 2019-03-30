package G45502.Pentago.controleur;

import G45502.Pentago.model.Game;
import G45502.Pentago.model.State;
import G45502.Pentago.view.View;


/**
 *
 * @author G45502
 */
public class Controleur {
    
    private final Game game;
    private final View view;

    public Controleur(Game game, View view) {
        this.game = game;
        this.view = view;
    }
    
    public void startGame(){
        while (game.getPlayers().size() < 2) {            
            game.addPlayer(view.askPlayer());
        }
        while (!game.isOver()) {
            view.viewBoard();
            game.placePiece(view.askX(), view.askY(), view.askQuadrant());
            view.askRotate();
            game.setState(State.PLACE);//Temporary until the rotate function is used
            if (!game.getBoard().isFreePlaceOnBoard()) {
                game.setState(State.OVER);
            }
            if (!game.isOver()) {
                game.changeCurrentPlayer();
            }
        }
        view.showWinner(game.getWinners());
    }
    
    

   
}
