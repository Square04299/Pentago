package G45502.Pentago.model;

import G45502.Pentago.exception.UnavailablePlace;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Square
 */
public class BoardTest{
    
    private Player player;
    /**
     * Builder of BoardTest
     */
    public BoardTest() {
        this.player= new Player("Chris", Marble.BLACK, Boolean.TRUE);
    }

    /**
     * Test of getQuadrant method, of class Board.
     */
    @Test
    public void testGetQuadrant() {
        System.out.println("getQuadrant");
        int value = 1;
        Board instance = new Board();
        Quadrant expResult = instance.getQuadrant(1);
        Quadrant result = instance.getQuadrant(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getQuadrant method, of class Board.
     */
    @Test (expected = UnavailablePlace.class)
    public void testGetQuadrantThrow() {
        System.out.println("getQuadrant");
        int value = 6;
        Board instance = new Board();
        Quadrant result = instance.getQuadrant(value);
    }
    
    /**
     * Test of addPiece method, of class Board.
     */
    @Test
    public void testAddPiece() {
        System.out.println("addPiece");
        int x = 0;
        int y = 0;
        Marble m = Marble.WHITE;
        int v = 1;
        Board instanceBoard = new Board();
        instanceBoard.addPiece(x, y, m, v,player);
        
        Board expectedBoard = new Board();
        expectedBoard.addPiece(x, y, m, v,player);
        
        Marble[][]instance = instanceBoard.getQuadrant(v).getQuadrant();
        Marble[][]expected = expectedBoard.getQuadrant(v).getQuadrant();
        
        assertEquals(expected[0][0],instance[0][0]);
    }
    
    /**
     * Test of addPiece method, of class Board.
     */
    @Test(expected = UnavailablePlace.class)
    public void testAddPieceException() {
        System.out.println("addPiece");
        int x = 0;
        int y = 0;
        int v = 1;
        Marble m = Marble.WHITE;
        
        Board instance = new Board();
        instance.addPiece(x, y, m, v,player);
        instance.addPiece(x, y, m, v,player);
    }

    /**
     * Test of isEmpty method, of class Board.
     */
    @Test
    public void testisEmptyQuadrant() {
        System.out.println("isEmptyQuadrant");
        int value = 0;
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isEmptyQuadrant(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmptyQuadrant method, of class Board.
     */
    @Test
    public void testIsEmptyQuadrant() {
        System.out.println("isEmptyQuadrant");
        int value = 0;
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isEmptyQuadrant(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of isFreePlaceOnBoard method, of class Board.
     */
    @Test
    public void testIsFreePlaceOnBoardTrue() {
        System.out.println("isFreePlaceOnBoardTrue");
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isFreePlaceOnBoard();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isFreePlaceOnBoard method, of class Board.
     */
    @Test
    public void testIsFreePlaceOnBoardFalse() {
        System.out.println("isFreePlaceOnBoardFalse");
        Board instance = new Board();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    instance.addPiece(j, k, Marble.BLACK, i,player);
                }
            }
        }
        boolean expResult = false;
        boolean result = instance.isFreePlaceOnBoard();
        assertEquals(expResult, result);
    }
    
}
