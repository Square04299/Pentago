package G45502.Pentago.model;

import G45502.Pentago.exception.UnavailablePlace;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G45502
 */
public class QuadrantTest {
    
     private Player player;
    
    /**
     * Build for the test
     */
    public QuadrantTest() {
        this.player= new Player("Chris", Marble.BLACK, Boolean.TRUE);
    }

    /**
     * Test of addPiece method, of class Quadrant.
     */
    @Test
    public void testAddPiece() {
        System.out.println("addPiece");
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.BLACK,player);
        Marble[][] result = instance.getQuadrant();
        
        Quadrant expected = new Quadrant();
        Marble[][] expected1 = expected.getQuadrant();
        expected1[0][0] = Marble.BLACK;
        assertTrue(result[0][0] == expected1[0][0]);
    }
    
    /**
     * Test of addPiece method, of class Quadrant.
     */
    @Test(expected = UnavailablePlace.class)
    public void testAddPieceException() {
        System.out.println("addPiece");
        
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.BLACK,player);
        
        Quadrant exception = new Quadrant();
        instance.addPiece(0, 0, Marble.BLACK,player);
    }

    /**
     * Test of rotateRight method, of class Quadrant.
     */
    @Test
    public void testRotateRight() {
        
        System.out.println("rotateRight");
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.WHITE,player);
        
        instance.rotateRight();
        
        Quadrant expected = new Quadrant();
        expected.addPiece(2, 0, Marble.WHITE,player);
        
        Marble[][] instance1 = instance.getQuadrant();
        Marble[][] expected1 = expected.getQuadrant();
        
        assertEquals(expected1[2][0], instance1[2][0]);
    }

    /**
     * Test of rotateLeft method, of class Quadrant.
     */
    @Test
    public void testRotateLeft() {
        System.out.println("rotateLeft");
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.WHITE,player);
        
        instance.rotateLeft();
        
        Quadrant expected = new Quadrant();
        expected.addPiece(0, 2, Marble.WHITE,player);
        
        Marble[][] instance1 = instance.getQuadrant();
        Marble[][] expected1 = expected.getQuadrant();
        
        assertEquals(expected1[0][2], instance1[0][2]);
    }

    /**
     * Test of getQuadrant method, of class Quadrant.
     */
    @Test
    public void testGetQuadrant() {
        System.out.println("getQuadrant");
        Quadrant instance = new Quadrant();
        Marble[][] expResult = instance.getQuadrant();
        Marble[][] result = instance.getQuadrant();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Quadrant.
     */
    @Test
    public void testIsEmptyTrue() {
        System.out.println("isEmptyTrue");
        Quadrant instance = new Quadrant();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmpty method, of class Quadrant.
     */
    @Test
    public void testIsEmptyFalse() {
        System.out.println("isEmptyFalse");
        Quadrant instance = new Quadrant();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                instance.addPiece(i, j, Marble.BLACK,player);
            }
        }
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoint method, of class Quadrant.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        int x = 0;
        int y = 0;
        Quadrant instance = new Quadrant();
        Marble expResult = Marble.EMPTY;
        Marble result = instance.getPoint(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Quadrant.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Quadrant instance = new Quadrant();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
}
