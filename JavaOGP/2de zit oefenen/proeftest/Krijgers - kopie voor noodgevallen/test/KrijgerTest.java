/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import krijgers.*;
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
public class KrijgerTest {
    
    public KrijgerTest() {
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
    
    @Test (expected = NullPointerException.class)
    public void testCompareToNull()throws NullPointerException{
        System.out.println("compareToObject");
        Krijger krijger = new Ninja("Ninja",20);
        krijger.compareTo(null);
    }
    
    @Test (expected = ClassCastException.class)
    public void testCompareToObject() throws ClassCastException {
        Krijger krijger = new Ninja("Ninja",20);
        //krijger.compareTo(new Object());
    }
    
    @Test
    public void testCompareToKrijger() {
        Krijger krijger = new Ninja("Donatello",20);
        Krijger instance = new Ninja("Michelangelo",20);
        assertTrue(krijger.compareTo(instance) < 0);
        krijger = new Ninja("Rafaelo",20);
        assertTrue(krijger.compareTo(instance) > 0);
        instance = new Samourai("Rafaelo",20);
        assertTrue(krijger.compareTo(instance) == 0);
        instance = new Samourai("Rafaelo",15);
        assertTrue(krijger.compareTo(instance) == 0);
        instance = new Samourai("Rafaelo",0);
        assertTrue(krijger.compareTo(instance) < 0);
        assertTrue(instance.compareTo(krijger) > 0);
        assertTrue(instance.compareTo(instance) == 0);
        
    }
}
