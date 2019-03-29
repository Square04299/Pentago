package G45502.Pentago.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author G45502
 */
public class Joueur {

    private final String name;
    private final Marble color;

    public Joueur(String name, Marble color) {
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

    Joueur getPlayer(List<Joueur> players, Marble color) {
        Objects.requireNonNull(players, "The list doesn't exist");
        if (players.isEmpty()) {
            throw new IndexOutOfBoundsException("The List is empty");
        }
        Joueur newCurrentPlayer = null;
        for (Joueur player : players) {
            if (player.getColor() == color) {
                newCurrentPlayer = new Joueur(player.getName(), color);
            }
        }
        return newCurrentPlayer;
    }
}
