package G45502.Pentago.model;

import G45502.Pentago.exception.GameException;
import G45502.Pentago.exception.UnavailablePlace;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Square
 */
public class BoardTest{
    
    public BoardTest() {
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
        instanceBoard.addPiece(x, y, m, v);
        
        Board expectedBoard = new Board();
        expectedBoard.addPiece(x, y, m, v);
        
        int[][]instance = instanceBoard.getQuadrant(v).getQuadrant();
        int[][]expected = expectedBoard.getQuadrant(v).getQuadrant();
        
        assertEquals(expected[0][0],instance[0][0]);
    }
    
    /**
     * Test of addPiece method, of class Board.
     */
    @Test(expected = GameException.class)
    public void testAddPieceException() {
        System.out.println("addPiece");
        int x = 0;
        int y = 0;
        int v = 1;
        Marble m = Marble.WHITE;
        
        Board instance = new Board();
        instance.addPiece(x, y, m, v);
        instance.addPiece(x, y, m, v);
    }

    /**
     * Test of isEmpty method, of class Board.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        int value = 0;
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isEmpty(value);
        assertEquals(expResult, result);
    }
    
}
