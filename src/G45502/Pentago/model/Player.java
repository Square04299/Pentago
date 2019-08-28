package G45502.Pentago.model;

import java.util.List;
import java.util.Objects;

/**
 * Description of a player with the color of the marble and his name
 *
 * @author G45502
 */
public class Player {

    private final String name;
    private final Marble color;
    private Boolean joker;

    /**
     * Builder of Player Will Build the name and marble color
     *
     * @param name name of the player
     * @param color Color of the Marble the Player will get
     * @param joker See if the player can place a marble in the enemy spot
     */
    public Player(String name, Marble color,Boolean joker) {
        this.name = name;
        this.color = color;
        this.joker = joker;
    }

    /**
     * Getter of name
     *
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Getter Color
     *
     * @return color of the marble
     */
    public Marble getColor() {
        return color;
    }
    
    public boolean getJoker(){
        return joker;
    }
    
    /**
     * After the player used this joker it will turn false
     * Only 1 joker per player
     */
    public void useJoker(){
        this.joker = false;
    }

    boolean isWhite() {
        return (this.color == Marble.WHITE);
    }

    Player getPlayer(List<Player> players, Marble color) {
        Objects.requireNonNull(players, "The list doesn't exist");
        if (players.isEmpty()) {
            throw new IndexOutOfBoundsException("The List is empty");
        }
        Player newCurrentPlayer = null;
        for (Player player : players) {
            if (player.getColor() == color) {
                newCurrentPlayer = player;
            }
        }
        return newCurrentPlayer;
    }
}
