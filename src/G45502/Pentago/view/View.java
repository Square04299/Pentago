package G45502.Pentago.view;

import G45502.Pentago.model.Game;
import G45502.Pentago.model.Player;
import G45502.Pentago.model.Quadrant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author G45502
 */
public class View {

    private final Game game;
    private final List<Player> players;
    private final Scanner sc;

    /**
     * Builder of View
     *
     * @param game the llogical part of the game
     */
    public View(Game game) {
        this.game = game;
        this.players = new ArrayList();
        this.sc = new Scanner(System.in);
    }

    /**
     * Getter of Players
     *
     * @return List of players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * View asked the name of a player
     *
     * @return a player
     */
    public Player askPlayer() {
        System.out.println(Color.toPurple("Name of the Player"));
        Player p = new Player(sc.next(), game.setColor());
        return p;
    }

    /**
     * Method to return a string depending of the value of each cell in the
     * board if the value is 0 it will return 0 if the value is 1 it will return
     * 1 if the value is -1 it will return a dot
     *
     * @param q Quadrant
     * @param x x axis
     * @param y y axis
     * @return a string
     */
    public String c(Quadrant q, int x, int y) {
        switch (q.getPoint(x, y)) {
            case 0:
                return "0";
            case 1:
                return "1";
            default:
                return ".";
        }
    }

    /**
     * View of a console board
     */
    public void viewBoard() {
        //Gestion Board
        Quadrant q1 = game.getBoard().getQuadrant(0);
        Quadrant q2 = game.getBoard().getQuadrant(1);
        Quadrant q3 = game.getBoard().getQuadrant(2);
        Quadrant q4 = game.getBoard().getQuadrant(3);
        //Printing
        System.out.println("   0  1  2 | 0  1  2 | ");
        System.out.println("  ---------+---------");
        System.out.println("0| " + c(q1, 0, 0) + "  " + c(q1, 0, 1) + "  " + c(q1, 0, 2) + " | " + c(q2, 0, 0) + "  " + c(q2, 0, 1) + "  " + c(q2, 0, 2) + " | ");
        System.out.println("1| " + c(q1, 1, 0) + "  " + c(q1, 1, 1) + "  " + c(q1, 1, 2) + " | " + c(q2, 1, 0) + "  " + c(q2, 1, 1) + "  " + c(q2, 1, 2) + " | ");
        System.out.println("2| " + c(q1, 2, 0) + "  " + c(q1, 2, 1) + "  " + c(q1, 1, 2) + " | " + c(q2, 2, 0) + "  " + c(q2, 2, 1) + "  " + c(q2, 2, 2) + " | ");
        System.out.println("  ---------+---------");
        System.out.println("0| " + c(q3, 0, 0) + "  " + c(q3, 0, 1) + "  " + c(q3, 0, 2) + " | " + c(q4, 0, 0) + "  " + c(q4, 0, 1) + "  " + c(q4, 0, 2) + " | ");
        System.out.println("1| " + c(q3, 1, 0) + "  " + c(q3, 1, 1) + "  " + c(q3, 1, 2) + " | " + c(q4, 1, 0) + "  " + c(q4, 1, 1) + "  " + c(q4, 1, 2) + " | ");
        System.out.println("2| " + c(q3, 2, 0) + "  " + c(q3, 2, 1) + "  " + c(q3, 2, 2) + " | " + c(q4, 2, 0) + "  " + c(q4, 2, 1) + "  " + c(q4, 2, 2) + " | ");
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

    /**
     * Ask the x axis
     *
     * @return value modulo 3 to limite the x value fom 0 to 2
     */
    public int askX() {
        System.out.println(Color.toWhite("Where to add point "
                + game.getCurrentPlayer().getName() + " (X axis)"));
        System.out.print("X : ");
        return checkInt(0, 2);
    }

    /**
     * Ask the y axis
     *
     * @return value modulo 3 to limite the x value fom 0 to 2
     */
    public int askY() {
        System.out.println(Color.toWhite("Where to add point "
                + game.getCurrentPlayer().getName() + " (Y axis)"));
        System.out.print("Y : ");
        return checkInt(0, 2);
    }

    /**
     * Ask in which quadrant you will add the marble just selected
     *
     * @return
     */
    public int askQuadrant() {
        System.out.println(Color.toWhite("What block do you want"
                + " to add your point (Top Left is 0, Top Right is 1,"
                + " Bottom Left is 2 , Bottom right is 3"));
        System.out.print("Quadrant : ");
        return checkInt(0, 3);
    }
    
    private int checkInt(int min, int max) {
        int input = sc.nextInt();
        if (input < min || input > max) {
            System.out.println(Color.toRed("You enter "+input+" that is out of "
                    + "the range (" + min + "/" + max + ")"));
            return checkInt(min, max);
        }
        return input;
    }

    /**
     * Ask Which quadrant to rotate Will do nothing but write in the console
     * with quadrant you rotate and in wich direction
     */
    public void askRotate() {
        System.out.println(Color.toWhite("Which Quadrant do"
                + " you want to rotate"));
        System.out.print("Quadrant : ");
        int q = checkInt(0, 3);
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
                + s + "\n"));
    }

    /**
     * Showing which player is the winner and thanking them for playing
     *
     * @param winner The winner of the game
     */
    public void showWinner(Player winner) {
        System.out.println(Color.toRed("Winner of the Game Pentago is "
                + winner.getName()));
        System.out.println(Color.toWhite("Thank you for player"));
    }

    /**
     * Print that a player has already placed a marble in this slot
     */
    public void placePieceError() {
        System.out.println(Color.toRed("A marble is already in this slot\n"
                + "Please put a free spot on the board"));
    }
}
