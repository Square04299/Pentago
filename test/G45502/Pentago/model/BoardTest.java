/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G45502.Pentago.model;

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
        Board instance = new Board();
        instance.addPiece(x, y, m, v);
        Quadrant result = instance.getQuadrant(v);
        result.addPiece(x, y, m);
    }
    
}
