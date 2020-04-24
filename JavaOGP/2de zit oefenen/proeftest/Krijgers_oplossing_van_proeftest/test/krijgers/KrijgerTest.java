package krijgers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiwi
 */
public class KrijgerTest { 
    
    public KrijgerTest() {
    }

    /**
     * Test of compareTo method, of class Krijger.
     */
    @Test 
    public void testCompareTo_Object() {
        System.out.println("compareTo(Object)");
        Krijger krijger = new Ninja(20,"Ninja"); 
        try {
            krijger.compareTo(null);
            fail("Moet NullPointerException gooien");
        } catch (NullPointerException e) {
            assertTrue(true);
        }        
        try {
            krijger.compareTo(new Object());
            fail("Moet ClassCastException gooien");
        } catch (ClassCastException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of compareTo method, of class Krijger.
     */
    @Test
    public void testCompareTo_Krijger() { 
        System.out.println("compareTo(Krijger)");
        Krijger krijger = new Ninja(20,"Donatello");
        Krijger instance = new Ninja(20,"Michelangelo");
        assertTrue(krijger.compareTo(instance) < 0);
        krijger = new Ninja(20,"Rafaelo");
        assertTrue(krijger.compareTo(instance) > 0);
        instance = new Samoerai(20,"Rafaelo");
        assertTrue(krijger.compareTo(instance) == 0);
        instance = new Samoerai(15,"Rafaelo");
        assertTrue(krijger.compareTo(instance) == 0);
        instance = new Samoerai(0,"Rafaelo");
        assertTrue(krijger.compareTo(instance) < 0);
        assertTrue(instance.compareTo(krijger) > 0);
        assertTrue(instance.compareTo(instance) == 0);
    }
    
}
