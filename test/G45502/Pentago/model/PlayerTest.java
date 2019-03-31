package G45502.Pentago.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Square
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new Player("Chris", Marble.BLACK);
        String expResult = "Chris";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Player.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Player instance = new Player("Chris", Marble.BLACK);
        Marble expResult = Marble.BLACK;
        Marble result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWhite method, of class Player.
     */
    @Test
    public void testIsWhiteFasle() {
        System.out.println("isWhiteFalse");
        Player instance = new Player("Chris", Marble.BLACK);
        boolean expResult = false;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isWhite method, of class Player.
     */
    @Test
    public void testIsWhiteTrue() {
        System.out.println("isWhiteTrue");
        Player instance = new Player("Chris", Marble.WHITE);
        boolean expResult = true;
        boolean result = instance.isWhite();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayer method, of class Player.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        List<Player> players = new ArrayList<>();
        Marble color = Marble.WHITE;
        Player insPlayer = new Player("Lucas", Marble.WHITE);
        Player insPlayer1 =  new Player("Chris", Marble.BLACK);
        
        players.add(insPlayer);
        players.add(insPlayer1);
        
        Player expResult =  new Player("Lucas", Marble.WHITE);
        
        Player result = insPlayer1.getPlayer(players, color);
        assertEquals(expResult.getColor(), result.getColor());
    }
    
    /**
     * Test of getPlayer method, of class Player.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPlayerEmpty() {
        System.out.println("getPlayer");
        List<Player> players = new ArrayList<>();
        Marble color = Marble.WHITE;
        Player insPlayer = new Player("Lucas", Marble.WHITE);
        Player insPlayer1 =  new Player("Chris", Marble.BLACK);
        
        Player expResult =  new Player("Lucas", Marble.WHITE);
        
        Player result = insPlayer1.getPlayer(players, color);
        assertEquals(expResult.getColor(), result.getColor());
    }
    
}
