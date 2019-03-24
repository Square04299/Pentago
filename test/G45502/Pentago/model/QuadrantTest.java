/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G45502.Pentago.model;

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
     * Test of rotateRight method, of class Quadrant.
     */
    @Test
    public void testRotateRight() {
        System.out.println("rotateRight");
        Quadrant instance = new Quadrant();
        instance.addPiece(0, 0, Marble.WHITE);
        instance.rotateRight();
        
        int[][] expected1 = new int[3][3];
        expected1[0][2] = 1;
        
        assertEquals(expected1, instance);
    }

    /**
     * Test of rotateLeft method, of class Quadrant.
     */
    @Test
    public void testRotateLeft() {
        System.out.println("rotateLeft");
        Quadrant instance = new Quadrant();
        instance.rotateLeft();
        fail("The test case is a prototype.");
    }
    
}
