/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        players.add(player1);
        players.add(player2);
        
        Game instance = new Game(players);
        Joueur result = instance.getCurrentPlayer();
        assertEquals(player1, result);
    }

    /**
     * Test of changeCurrentPlayer method, of class Game.
     */
    @Test
    public void testChangeCurrentPlayer() {
        System.out.println("changeCurrentPlayer");
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        players.add(player1);
        players.add(player2);
        
        Game instance = new Game(players);
        instance.changeCurrentPlayer();
        Joueur result = instance.getCurrentPlayer();
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
        
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        players.add(player1);
        players.add(player2);
        
        Game instance = new Game(players);
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
        State state = State.OVER;
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        players.add(player1);
        players.add(player2);
        
        Game instance = new Game(players);
        boolean expResult = true;
        boolean result = instance.isOver(state);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOverFalse() {
        System.out.println("isOver");
        State state = State.PLACE;
        List<Joueur> players = new ArrayList();
        Joueur player1 = new Joueur("Lucas", Marble.WHITE);
        Joueur player2 = new Joueur("Christopher", Marble.BLACK);
        players.add(player1);
        players.add(player2);
        
        Game instance = new Game(players);
        boolean expResult = false;
        boolean result = instance.isOver(state);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinners method, of class Game.
     */
    @Test
    public void testGetWinners() {
        System.out.println("getWinners");
        Game instance = null;
        Winners expResult = null;
        Winners result = instance.getWinners();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
