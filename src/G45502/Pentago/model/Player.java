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

    public Player(String name, Marble color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

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
