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
 * @author Square
 */
public class StateTest {
    
    /**
     * Builder of State Test
     */
    public StateTest() {
    }

    /**
     * Test of values method, of class State.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        State[] expResult = {State.PLACE,State.ROTATE,State.OVER};
        State[] result = State.values();
        assertArrayEquals(expResult, result);
    }
    
}
