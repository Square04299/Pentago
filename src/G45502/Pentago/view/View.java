package G45502.Pentago.view;

import G45502.Pentago.model.Board;
import G45502.Pentago.model.Game;
import G45502.Pentago.model.Player;
import G45502.Pentago.model.Quadrant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Square
 */
public class View {
    
    private final Game game;
    private final List<Player> players;
    private final Scanner sc;

    public View(Game game) {
        this.game = game;
        this.players = new ArrayList();
        this.sc = new Scanner(System.in);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player askPlayer() {
        System.out.println(Color.toPurple("Name of the Player"));
        Player p = new Player(sc.next(), game.setColor());
        return p;
    }
    
    public String c(Quadrant q,int x, int y){
        if(q.getPoint(x, y) == 0) {
            return "0";
        } else if(q.getPoint(x, y) == 1){
            return "1";
        }else{
            return ".";
        }
    }

    public void viewBoard() {
        //Gestion Board
        Quadrant q1 = game.getBoard().getQuadrant(0);
        Quadrant q2 = game.getBoard().getQuadrant(1);
        Quadrant q3 = game.getBoard().getQuadrant(2);
        Quadrant q4 = game.getBoard().getQuadrant(3);
        //Printing
        System.out.println("   0  1  2 | 0  1  2 | ");
        System.out.println("  ---------+---------");
        System.out.println("0| "+c(q1, 0, 0)+"  "+c(q1, 0, 1)+"  "+c(q1, 0, 2)+" | "+c(q2, 0, 0)+"  "+c(q2, 0, 1)+"  "+c(q2, 0, 2)+" | ");
        System.out.println("1| "+c(q1, 1, 0)+"  "+c(q1, 1, 1)+"  "+c(q1, 1, 2)+" | "+c(q2, 0, 0)+"  "+c(q2, 1, 1)+"  "+c(q2, 1, 2)+" | ");
        System.out.println("2| "+c(q1, 2, 0)+"  "+c(q1, 2, 1)+"  "+c(q1, 1, 2)+" | "+c(q2, 0, 0)+"  "+c(q2, 2, 1)+"  "+c(q2, 2, 2)+" | ");
        System.out.println("  ---------+---------");
        System.out.println("0| "+c(q3, 0, 0)+"  "+c(q3, 0, 1)+"  "+c(q3, 0, 2)+" | "+c(q4, 0, 0)+"  "+c(q4, 0, 1)+"  "+c(q4, 0, 2)+" | ");
        System.out.println("1| "+c(q3, 1, 0)+"  "+c(q3, 1, 1)+"  "+c(q3, 1, 2)+" | "+c(q4, 1, 0)+"  "+c(q4, 1, 1)+"  "+c(q4, 1, 2)+" | ");
        System.out.println("2| "+c(q3, 2, 0)+"  "+c(q3, 2, 1)+"  "+c(q3, 2, 2)+" | "+c(q4, 2, 0)+"  "+c(q4, 2, 1)+"  "+c(q4, 2, 2)+" | ");
        System.out.println("  ---------+---------");
        //Exemple
//        System.out.println("   0  1  2 | 3  4  5");
//        System.out.println("  ---------+---------");
//        System.out.println("0| .  .  . | .  .  .");
//        System.out.println("1| .  .  . | .  .  .");
//        System.out.println("2| .  .  . | .  .  .");
//        System.out.println("  ---------+---------");
//        System.out.println("3| .  .  . | .  .  .");
//        System.out.println("4| .  .  . | .  .  .");
//        System.out.println("5| .  .  . | .  .  .");
    }
    
    public int askX() {
        System.out.println(Color.toWhite("Where to add point "
                + game.getCurrentPlayer().getName() +" (X axis)"));
        System.out.print("X : ");
        int x = sc.nextInt();
        return x%3;
    }

    public int askY() {
        System.out.println(Color.toWhite("Where to add point "
                + game.getCurrentPlayer().getName() +" (Y axis)"));
        System.out.print("Y : ");
        int y = sc.nextInt();
        return y%3;
    }

    public int askQuadrant() {
        System.out.println(Color.toWhite("What block do you want"
                + " to add your point (Top Left is 0, Top Right is 1,"
                + " Bottom Left is 2 , Bottom right is 3"));
        System.out.print("Quadrant : ");
        int quadrant = sc.nextInt();
        return quadrant;
    }

    public void askRotate() {
        System.out.println(Color.toWhite("Which Quadrant do"
                + " you want to rotate"));
        System.out.print("Quadrant : ");
        int q = sc.nextInt();
        System.out.println(Color.toWhite("What direction \"RIGHT\" or "
                + "\"LEFT\""));
        System.out.print("Direction : ");
        String s = sc.next();
        s = s.toUpperCase(Locale.ENGLISH);
        
        while (!s.equals("RIGHT") && !s.equals("LEFT")) {            
            System.out.println(Color.toRed("\nAnswer either \"RIGHT\" or "
                    + "\"LEFT\""));
            System.out.print("Direction : ");
            s = sc.next();
            s = s.toUpperCase(Locale.ENGLISH);
        }
        
        System.out.println(Color.toYellow("(SYSTEM) The quadrant " + q + " rotates to the "
                + s +"\n"));
    }

    public void showWinner(Player winner) {
        System.out.println(Color.toRed("Winner of the Game Pentago is "
                + winner.getName()));
        System.out.println(Color.toWhite("Thank you for player"));
    }
}
