/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import krijgers.Krijger;
import krijgers.KrijgerVergelijker;
import krijgers.KrijgersDAODummy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Willem Dendauw
 */
public class KrijgerVergelijkerTest {
    
    public KrijgerVergelijkerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
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
