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
public class GameTest {
    
    public GameTest() {
    }

    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @Test
    public void testGetCurrentPlayerBlackAndWhite() {
        System.out.println("getCurrentPlayer Black and White");
        
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        
        Player result = instance.getCurrentPlayer();
        assertEquals(player1, result);
    }

    /**
     * Test of changeCurrentPlayer method, of class Game.
     */
    @Test
    public void testChangeCurrentPlayer() {
        System.out.println("changeCurrentPlayer");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        
        instance.changeCurrentPlayer();
        Player result = instance.getCurrentPlayer();
        assertEquals(player2.getColor(), result.getColor());
    }

    /**
     * Test of placePiece method, of class Game.
     */
    @Test
    public void testPlacePiece() {
        System.out.println("placePiece");
        int x = 0;
        int y = 0;
        int q = 0;
        
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        
        instance.placePiece(x, y, q);
        int[][] expected = instance.getQuadrant(q);
        
        assertTrue(expected[0][0] == 1);
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOverTrue() {
        System.out.println("isOver");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.setState(State.OVER);
        boolean expResult = true;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOverFalse() {
        System.out.println("isOver");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinners method, of class Game.
     */
    @Test
    public void testGetWinners() {
        System.out.println("getWinners");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.setState(State.OVER);
        Player expResult = player1;
        Player result = instance.getWinners();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @Test
    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        Player expResult = player1;
        Player result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        
        Board expResult = instance.getBoard();
        Board result = instance.getBoard();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuadrant method, of class Game.
     */
    @Test
    public void testGetQuadrant() {
        System.out.println("getQuadrant");
        int value = 0;
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        int[][] expResult = instance.getQuadrant(value);
        int[][] result = instance.getQuadrant(value);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Game.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        State state = State.ROTATE;
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Christopher", Marble.BLACK);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.setState(state);
        assertTrue(instance.getGameState() == State.ROTATE);
    }
}
