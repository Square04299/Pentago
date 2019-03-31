package G45502.Pentago.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author G45502
 */
public class Player {

    private final String name;
    private final Marble color;

    /**
     * Builder of Player Will Build the name and marble color
     *
     * @param name name of the player
     * @param color Color of the Marble the Player will get
     */
    public Player(String name, Marble color) {
        this.name = name;
        this.color = color;
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
                newCurrentPlayer = new Player(player.getName(), color);
            }
        }
        return newCurrentPlayer;
    }
}
