package G45502.Pentago.view;

import G45502.Pentago.model.Facade;
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

    private final Facade game;
    private final List<Player> players;
    private final Scanner sc;

    /**
     * Builder of View
     *
     * @param game the logical part of the game
     */
    public View(Facade game) {
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
        Player p = new Player(sc.next(), game.setColor(),true);
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
    private String printMarble(Quadrant q, int x, int y) {
        switch (q.getPoint(x, y)) {
            case BLACK:
                return "0";
            case WHITE:
                return "1";
            default:
                return ".";
        }
    }

    /**
     * View of a console board
     */
    public void viewBoard() {
        //Gestion Board //Mettre dans la facade
        Quadrant q1 = game.getQuadrant(0);
        Quadrant q2 = game.getQuadrant(1);
        Quadrant q3 = game.getQuadrant(2);
        Quadrant q4 = game.getQuadrant(3);
        //Printing
        System.out.println("   0  1  2 | 0  1  2 | ");
        System.out.println("  ---------+---------");
        System.out.println("0| " + printMarble(q1, 0, 0) + "  " + printMarble(q1, 0, 1) + "  " + printMarble(q1, 0, 2) + " | " + printMarble(q2, 0, 0) + "  " + printMarble(q2, 0, 1) + "  " + printMarble(q2, 0, 2) + " | ");
        System.out.println("1| " + printMarble(q1, 1, 0) + "  " + printMarble(q1, 1, 1) + "  " + printMarble(q1, 1, 2) + " | " + printMarble(q2, 1, 0) + "  " + printMarble(q2, 1, 1) + "  " + printMarble(q2, 1, 2) + " | ");
        System.out.println("2| " + printMarble(q1, 2, 0) + "  " + printMarble(q1, 2, 1) + "  " + printMarble(q1, 1, 2) + " | " + printMarble(q2, 2, 0) + "  " + printMarble(q2, 2, 1) + "  " + printMarble(q2, 2, 2) + " | ");
        System.out.println("  ---------+---------");
        System.out.println("0| " + printMarble(q3, 0, 0) + "  " + printMarble(q3, 0, 1) + "  " + printMarble(q3, 0, 2) + " | " + printMarble(q4, 0, 0) + "  " + printMarble(q4, 0, 1) + "  " + printMarble(q4, 0, 2) + " | ");
        System.out.println("1| " + printMarble(q3, 1, 0) + "  " + printMarble(q3, 1, 1) + "  " + printMarble(q3, 1, 2) + " | " + printMarble(q4, 1, 0) + "  " + printMarble(q4, 1, 1) + "  " + printMarble(q4, 1, 2) + " | ");
        System.out.println("2| " + printMarble(q3, 2, 0) + "  " + printMarble(q3, 2, 1) + "  " + printMarble(q3, 2, 2) + " | " + printMarble(q4, 2, 0) + "  " + printMarble(q4, 2, 1) + "  " + printMarble(q4, 2, 2) + " | ");
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
     * @return value modulo 3 to limite the x value from 0 to 2
     */
    public int askX() {
        System.out.println(Color.toWhite("Where to add point "
                + game.getCurrentPlayer().getName() + " (X axis)"));
        System.out.print("X : ");
        return checkBornInt(0, 2);
    }

    /**
     * Ask the y axis
     *
     * @return value modulo 3 to limite the x value from 0 to 2
     */
    public int askY() {
        System.out.println(Color.toWhite("Where to add point "
                + game.getCurrentPlayer().getName() + " (Y axis)"));
        System.out.print("Y : ");
        return checkBornInt(0, 2);
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
        return checkBornInt(0, 3);
    }

    private int checkInt() {

        int input;
        while (!sc.hasNextInt()) {
            System.out.println(Color.toRed("You didn't enter a number"));
            System.out.print(Color.toRed("New number : "));
            sc.next();

        }
        input = sc.nextInt();
        return input;
    }
    
    private int checkBornInt(int min, int max){
        int input = checkInt();
        while (input < min || input > max) {
            System.out.println(Color.toRed("You enter " + input + " that is out of "
                    + "the range (" + min + "/" + max + ")"));
            input = checkInt();
        }
        return input;
    }

    /**
     * Ask Which quadrant to rotate Will do nothing but write in the console
     * with quadrant you rotate and in which direction
     */
    public void askRotate() {
        System.out.println(Color.toWhite("Which Quadrant do"
                + " you want to rotate"));
        System.out.print("Quadrant : ");
        int q = checkBornInt(0, 3);
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
        System.out.println(Color.toWhite("Thank you for playing"));
    }

    /**
     * Print that a player has already placed a marble in this slot
     */
    public void placePieceError() {
        System.out.println(Color.toRed("A marble is already in this slot\n"
                + "Please put a free spot on the board"));
    }
}
