package G45502.Pentago.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G45502
 */
public class MarbleTest {
    
    public MarbleTest() {
    }
    /**
     * Test of getValue method, of class Marble.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Marble instance = Marble.BLACK;
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
}
