package G45502.Pentago.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G45502
 */
public class FacadeTest {
    
    /**
     * Build of Facade Test
     */
    public FacadeTest() {
    }

    /**
     * Test of addPlayer method, of class Facade.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = new Player("Chris", Marble.BLACK,true);
        Game instance = new Game();
        instance.addPlayer(player);
        assertTrue(instance.getPlayers().size() > 0);
    }
    
    /**
     * Test of addPlayer method, of class Facade.
     */
    @Test
    public void testAddPlayerToManyPlayer() {
        System.out.println("addPlayerToManyPlayer");
        Player player = new Player("Chris", Marble.BLACK,true);
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Pauline", Marble.BLACK,true);
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
        
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);
        
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
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);
        
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
        
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        
        instance.placePiece(x, y, q);
        Quadrant expected = instance.getQuadrant(q);
        
        assertTrue(expected.getPoint(0, 0) == Marble.WHITE);
    }

    /**
     * Test of rotationQuadrantRight method, of class Facade.
     */
    @Test(expected = NullPointerException.class)
    public void testRotationQuadrantRight() {
        System.out.println("rotationQuadrantRight");
        int value = 0;
        Game instance = new Game();
        Quadrant exGame = instance.getQuadrant(value);
        instance.setState(State.ROTATE);
        instance.rotationQuadrantRight(value);
        assertTrue(instance.getQuadrant(value) == exGame);
    }

    /**
     * Test of rotationQuadrantLeft method, of class Facade.
     */
    @Test(expected = NullPointerException.class)
    public void testRotationQuadrantLeft() {
        System.out.println("rotationQuadrantLeft");
        int value = 0;
        Game instance = new Game();
        Quadrant exGame = instance.getQuadrant(value);
        instance.setState(State.ROTATE);
        instance.rotationQuadrantLeft(value);
        assertTrue(instance.getQuadrant(value) == exGame);
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOverTrue() {
        System.out.println("isOver");
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);
        
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
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);
        
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
    @Test(expected = NullPointerException.class)
    public void testGetWinners() {
        System.out.println("getWinners");
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);
        
        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.setState(State.OVER);
        String expResult = player1.getName();
        String result = instance.getWinners().get(0).getName();
        assertEquals(expResult, result);
    }
}
