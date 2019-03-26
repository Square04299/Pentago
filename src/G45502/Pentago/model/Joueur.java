package G45502.Pentago.model;

import java.util.List;

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
    
    boolean isWhite(){
        return (this.color == Marble.WHITE);
    }
    
    Joueur getPlayer(List<Joueur> players, Marble color){
        if (players.isEmpty()) {
            throw new IllegalArgumentException("The list players is empty");
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
