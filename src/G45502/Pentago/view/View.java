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
        System.out.println(Color.toPurple("Name of the Player\n"));
        Player p = new Player(sc.next(), game.setColor());
        return p;
    }
    
    String c(Quadrant q,int x, int y){
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
        System.out.println("   0  1  2 | 3  4  5");
        System.out.println("  ---------+---------");
        System.out.println("0| "+q1.getPoint(0, 0)+"  "+q1.getPoint(0, 1)+"  "+q1.getPoint(0, 2)+" | "+q2.getPoint(0, 0)+"  "+q2.getPoint(0, 1)+"  "+q2.getPoint(0, 2)+"");
        System.out.println("1| "+q1.getPoint(1, 0)+"  "+q1.getPoint(1, 1)+"  "+q1.getPoint(1, 2)+" | "+q2.getPoint(1, 0)+"  "+q2.getPoint(1, 1)+"  "+q2.getPoint(1, 2)+"");
        System.out.println("2| "+q1.getPoint(2, 0)+"  "+q1.getPoint(2, 1)+"  "+q1.getPoint(2, 2)+" | "+q2.getPoint(2, 0)+"  "+q2.getPoint(2, 1)+"  "+q2.getPoint(2, 2)+"");
        System.out.println("  ---------+---------");
        System.out.println("3| "+q3.getPoint(0, 0)+"  "+q3.getPoint(0, 1)+"  "+q3.getPoint(0, 2)+" | "+q4.getPoint(0, 0)+"  "+q4.getPoint(0, 1)+"  "+q4.getPoint(0, 2)+"");
        System.out.println("4| "+q3.getPoint(1, 0)+"  "+q3.getPoint(1, 1)+"  "+q3.getPoint(1, 2)+" | "+q4.getPoint(1, 0)+"  "+q4.getPoint(1, 1)+"  "+q4.getPoint(1, 2)+"");
        System.out.println("5| "+q3.getPoint(2, 0)+"  "+q3.getPoint(2, 1)+"  "+q3.getPoint(2, 2)+" | "+q4.getPoint(2, 0)+"  "+q4.getPoint(2, 1)+"  "+q4.getPoint(2, 2)+"");
        System.out.println("");
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
        System.out.println(Color.toPurple("Where to add point (X axis)"));
        int x = sc.nextInt();
        return x%3;
    }

    public int askY() {
        System.out.println(Color.toPurple("Where to add point (Y axis)"));
        int y = sc.nextInt();
        return y%3;
    }

    public int askQuadrant() {
        System.out.println(Color.toPurple("What block do you want"
                + " to add your point (Top Left is 1, Top Right is 2"));
        int quadrant = sc.nextInt();
        return quadrant;
    }

    public void askRotate() {
        System.out.println(Color.toPurple("Which Quadrant do"
                + " you want to rotate"));
        int q = sc.nextInt();
        System.out.println(Color.toPurple("What direction \"RIGHT\" or "
                + "\"LEFT\""));
        String s = sc.next();
        s = s.toUpperCase(Locale.ENGLISH);
        
        while (!s.equals("RIGHT") || !s.equals("LEFT")) {            
            System.out.println(Color.toRed("\nAnswer either \"RIGHT\" or "
                    + "\"LEFT\" \n"));
            s = sc.next();
            s = s.toUpperCase(Locale.ENGLISH);
        }
        
        System.out.println(Color.toBlack("The quadrant " + q + " rotates to the "
                + s));
    }

    public void showWinner(Player winner) {
        System.out.println(Color.toRed("Winner of the Game Pentago is "
                + winner));
        System.out.println(Color.toBlue("Thank you for player"));
    }
}
