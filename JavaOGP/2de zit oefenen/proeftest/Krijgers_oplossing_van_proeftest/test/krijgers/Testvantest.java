/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krijgers;

import java.io.FileNotFoundException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Willem Dendauw
 */
public class Testvantest {
    
    public Testvantest(){
        
    }
    
    @Test
    public void testCompare() {
        Krijger[] krijgers = new KrijgersDAODummy().getKrijgers();
        KrijgerVergelijker vergelijker = new KrijgerVergelijker();
        assertTrue("hier staat wat er geprint wordt indien fout", vergelijker.compare(krijgers[0], krijgers[1]) > 0);
    }
    
    @Test (expected = FileNotFoundException.class)
    public void test() throws FileNotFoundException {
        //hier een functie oproepen die FileNotFound Zou moeten opwerpen;
    }
    
    @Test
    public void testCompareToObject(){
        System.out.println("compareTo(Object");
        Krijger krijger = new Ninja(20,"Ninja");
        try{
            krijger.compareTo(null);
            fail("Moet nullpointerExceptie opwerken");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
        try {
            krijger.compareTo(new Object());
            fail("moet ClassCastException opwerpen");
        } catch (ClassCastException e){
            assertTrue(true);
        }
    }
    
    //bovenstaande kan ook in 2 worden opgedeeld en andere syntax gebruiken
    @Test (expected = NullPointerException.class)
    public void testNull() throws NullPointerException {
        System.out.println("compareTo(Object)");
        Krijger krijger = new Ninja(20,"Ninja");
        krijger.compareTo(null);
    }
}
