
package krijgers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiwi
 */
public class KrijgerVergelijkerTest {
    
    public KrijgerVergelijkerTest() {
    }

    /**
     * Test of compare method, of class KrijgerVergelijker.
     */
    @Test
    public void testCompare() { 
        Krijger[] krijgers = new KrijgersDAODummy().getKrijgers();
        KrijgerVergelijker vergelijker = new KrijgerVergelijker();
        assertTrue(vergelijker.compare(krijgers[0], krijgers[1]) > 0);
        assertTrue(vergelijker.compare(krijgers[0], krijgers[3]) < 0);
        assertTrue(vergelijker.compare(krijgers[0], krijgers[2]) < 0);
        assertTrue(vergelijker.compare(krijgers[1], krijgers[4]) < 0);
        assertTrue(vergelijker.compare(krijgers[5], krijgers[4]) < 0);
        assertTrue(vergelijker.compare(krijgers[6], krijgers[4]) == 0);
    }
    
}
