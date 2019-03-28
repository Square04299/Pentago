package G45502.Pentago.model;

import G45502.Pentago.exception.GameException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G45502
 */
public class QuadrantTest {
    
    public QuadrantTest() {
    }

    /**
     * Test of addPiece method, of class Quadrant.
     */
    @Test
    public void testAddPiece() {
        System.out.println("addPiece");
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.BLACK);
        int[][] result = instance.getQuadrant();
        
        Quadrant expected = new Quadrant();
        int[][] expected1 = expected.getQuadrant();
        expected1[0][0] = 0;
        assertTrue(result[0][0] == expected1[0][0]);
    }
    
    /**
     * Test of addPiece method, of class Quadrant.
     */
    @Test(expected = GameException.class)
    public void testAddPieceException() {
        System.out.println("addPiece");
        
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.BLACK);
        
        Quadrant exception = new Quadrant();
        instance.addPiece(0, 0, Marble.BLACK);
    }

    /**
     * Test of rotateRight method, of class Quadrant.
     */
    @Test
    public void testRotateLeft() {
        
        System.out.println("rotateLeft");
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.WHITE);
        
        instance.rotateLeft();
        
        Quadrant expected = new Quadrant();
        expected.addPiece(2, 0, Marble.WHITE);
        
        int[][] instance1 = instance.getQuadrant();
        int[][] expected1 = expected.getQuadrant();
        
        assertEquals(expected1[2][0], instance1[2][0]);
    }

    /**
     * Test of rotateLeft method, of class Quadrant.
     */
    @Test
    public void testRotateRight() {
        System.out.println("rotateRight");
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.WHITE);
        
        instance.rotateRight();
        
        Quadrant expected = new Quadrant();
        expected.addPiece(0, 2, Marble.WHITE);
        
        int[][] instance1 = instance.getQuadrant();
        int[][] expected1 = expected.getQuadrant();
        
        assertEquals(expected1[0][2], instance1[0][2]);
    }
    
}
