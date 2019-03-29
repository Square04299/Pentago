package G45502.Pentago.model;

import G45502.Pentago.exception.GameException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G45502
 */
public class JoueurTest {
    
    public JoueurTest() {
    }

    /**
     * Test of getName method, of class Joueur.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Joueur instance = new Joueur("lucas", Marble.WHITE);
        String expResult = "lucas";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Joueur.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Joueur instance = new Joueur("lucas", Marble.WHITE);
        Marble expResult = Marble.WHITE;
        Marble result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWhite method, of class Joueur.
     */
    @Test
    public void testIsWhite() {
        System.out.println("isWhite");
        Joueur instance = new Joueur("lucas", Marble.WHITE);
        boolean expResult = true;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isWhite method, of class Joueur.
     */
    @Test
    public void testIsNotWhite() {
        System.out.println("isNotWhite");
        Joueur instance = new Joueur("lucas", Marble.BLACK);
        boolean expResult = false;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayer method, of class Joueur.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        players.add(player1);
        players.add(player2);
        
        Game game = new Game(players);
        
        Marble color = Marble.BLACK;
        Joueur instance = game.getCurrentPlayer();
        Joueur expResult = player2;
        Joueur result = instance.getPlayer(players, color);
        assertEquals(expResult.getColor(), result.getColor());
    }
    
    /**
     * Test of getPlayer method, of class Joueur.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPlayerEmptyList() {
        System.out.println("getPlayerEmptyList");
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        
        Game game = new Game(players);
        
        Marble color = Marble.BLACK;
        Joueur instance = game.getCurrentPlayer();
        Joueur expResult = player2;
        Joueur result = instance.getPlayer(players, color);
        assertEquals(expResult.getColor(), result.getColor());
    }
    
    /**
     * Test of getPlayer method, of class Joueur.
     */
    @Test(expected = NullPointerException.class)
    public void testGetPlayerNull() {
        System.out.println("getPlayerNull");
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        players.add(player1);
        players.add(player2);
        
        Game game = new Game(players);
        
        Marble color = Marble.BLACK;
        Joueur instance = game.getCurrentPlayer();
        Joueur expResult = player2;
        Joueur result = instance.getPlayer(null, color);
        assertEquals(expResult.getColor(), result.getColor());
    }
    
}
