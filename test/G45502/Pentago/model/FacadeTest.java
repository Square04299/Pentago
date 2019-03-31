package G45502.Pentago.model;

import G45502.Pentago.exception.GameException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G45502
 */
public class FacadeTest {
    
    public FacadeTest() {
    }

    /**
     * Test of addPlayer method, of class Facade.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = new Player("Chris", Marble.BLACK);
        Game instance = new Game();
        instance.addPlayer(player);
        assertTrue(instance.getPlayers().size() > 0);
    }
    
    /**
     * Test of addPlayer method, of class Facade.
     */
    @Test(expected = GameException.class)
    public void testAddPlayerToManyPlayer() {
        System.out.println("addPlayerToManyPlayer");
        Player player = new Player("Chris", Marble.BLACK);
        Player player1 = new Player("Lucas", Marble.WHITE);
        Player player2 = new Player("Pauline", Marble.BLACK);
        Game instance = new Game();
        instance.addPlayer(player);
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        assertTrue(instance.getPlayers().size() > 0);
    }
    
    /**
     * Test of addPlayer method, of class Facade.
     */
    @Test(expected = NullPointerException.class)
    public void testAddPlayerNull() {
        System.out.println("addPlayerNull");
        Player player = null;
        Game instance = new Game();
        instance.addPlayer(player);
        assertTrue(instance.getPlayers().size() > 0);
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
     * Test of rotationQuadrantRight method, of class Facade.
     */
    @Test
    public void testRotationQuadrantRight() {
        System.out.println("rotationQuadrantRight");
        int value = 0;
        Game instance = new Game();
        int[][] exGame = instance.getQuadrant(value);
        instance.rotationQuadrantRight(value);
        assertTrue(instance.getQuadrant(value) == exGame);
    }

    /**
     * Test of rotationQuadrantLeft method, of class Facade.
     */
    @Test
    public void testRotationQuadrantLeft() {
        System.out.println("rotationQuadrantLeft");
        int value = 0;
        Game instance = new Game();
        int[][] exGame = instance.getQuadrant(value);
        instance.rotationQuadrantLeft(value);
        assertTrue(instance.getQuadrant(value) == exGame);
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
     * Test of setState method, of class Facade.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        State state = State.ROTATE;
        Game instance = new Game();
        instance.setState(state);
        assertEquals(instance.getGameState(), state);
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
}
