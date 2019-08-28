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

    /**
     * Builder of Game Test
     */
    public GameTest() {
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
     * Test of placePiece method, of class Game.
     */
    @Test(expected = GameException.class)
    public void testPlacePieceWrongState() {
        System.out.println("placePieceWrongState");
        int x = 0;
        int y = 0;
        int q = 0;

        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.setState(State.ROTATE);
        instance.placePiece(x, y, q);
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
     * Test of getWinners method, of class Game.
     */
    @Test(expected = NullPointerException.class)
    public void testGetWinnersStateOver() {
        System.out.println("getWinnersStateOver");
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

    /**
     * Test of getWinners method, of class Game.
     */
    @Test
    public void testGetWinnersPlayer1() {
        System.out.println("getWinnersStateOver");
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.placePiece(0, 0, 0);
        Player expResult = player1;
        Player result = instance.getWinners().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinners method, of class Game.
     */
    @Test
    public void testGetWinnersPlayer2() {
        System.out.println("getWinnersStateOver");
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.placePiece(0, 0, 1);
        instance.setState(State.PLACE);
        instance.changeCurrentPlayer();
        instance.placePiece(0, 0, 0);
        String expResult = instance.getCurrentPlayer().getName();
        String result = instance.getWinners().get(0).getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinners method, of class Game.
     */
    @Test
    public void testGetWinnersNoWinner() {
        System.out.println("getWinnersNoWinner");
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        Player expResult = null;
        Player result = instance.getWinners().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

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
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        Quadrant expResult = instance.getQuadrant(value);
        Quadrant result = instance.getQuadrant(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Game.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        State state = State.ROTATE;
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        instance.setState(state);
        assertTrue(instance.getGameState() == State.ROTATE);
    }

    /**
     * Test of getPlayers method, of class Game.
     */
    @Test(expected = AssertionError.class)
    public void testGetPlayersNull() {
        System.out.println("getPlayers");
        Game instance = new Game();
        List<Player> expResult = null;
        List<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayers method, of class Game.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Game instance = new Game();
        List<Player> expResult = new ArrayList<>();
        List<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGameState method, of class Game.
     */
    @Test
    public void testGetGameState() {
        System.out.println("getGameState");
        Game instance = new Game();
        State expResult = State.PLACE;
        State result = instance.getGameState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColor method, of class Game.
     */
    @Test
    public void testSetColorWhite() {
        System.out.println("setColorWhite");
        Game instance = new Game();
        Marble expResult = Marble.WHITE;
        Marble result = instance.setColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColor method, of class Game.
     */
    @Test
    public void testSetColorBlack() {
        System.out.println("setColorBlack");
        Player player1 = new Player("Lucas", Marble.WHITE,true);
        Player player2 = new Player("Christopher", Marble.BLACK,true);

        Game instance = new Game();
        instance.addPlayer(player1);
        instance.addPlayer(player2);
        Marble expResult = Marble.BLACK;
        Marble result = instance.setColor();
        assertEquals(expResult, result);
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
}
