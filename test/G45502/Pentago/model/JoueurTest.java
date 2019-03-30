package G45502.Pentago.model;

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
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new Player("lucas", Marble.WHITE);
        String expResult = "lucas";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Player.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Player instance = new Player("lucas", Marble.WHITE);
        Marble expResult = Marble.WHITE;
        Marble result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWhite method, of class Player.
     */
    @Test
    public void testIsWhite() {
        System.out.println("isWhite");
        Player instance = new Player("lucas", Marble.WHITE);
        boolean expResult = true;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isWhite method, of class Player.
     */
    @Test
    public void testIsNotWhite() {
        System.out.println("isNotWhite");
        Player instance = new Player("lucas", Marble.BLACK);
        boolean expResult = false;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayer method, of class Player.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);
        
        Marble color = Marble.BLACK;
        Player instance = game.getCurrentPlayer();
        Player expResult = player2;
        Player result = instance.getPlayer(game.getPlayers(), color);
        assertEquals(expResult.getColor(), result.getColor());
    }
    
    /**
     * Test of getPlayer method, of class Player.
     */
    @Test(expected = NullPointerException.class)
    public void testGetPlayerNull() {
        System.out.println("getPlayerNull");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);
        
        Marble color = Marble.BLACK;
        Player instance = game.getCurrentPlayer();
        Player expResult = player2;
        Player result = instance.getPlayer(null, color);
        assertEquals(expResult.getColor(), result.getColor());
    }
    
}
