/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import groepen.DAOFigurenDummy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Leen Brouns
 */
public class TestRuimtefiguren {
    
    public TestRuimtefiguren() {
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

    @Test
    public void testTellen() {
        
        DAOFigurenDummy dummy = new DAOFigurenDummy();
        Assert.assertEquals("Aantal figuren niet juist?",14,dummy.getFiguren().size());
        Assert.assertEquals("Aantal VERSCHILLENDE balken niet juist?",6,dummy.getBalken().size());
        Assert.assertEquals("Aantal VERSCHILLENDE cilinders niet juist?",6,dummy.getCilinders().size());
        
    }
    
    // Schrijf zelf verdere testcases.
    // Ter info: de klasse dummy levert volgende resultaten:
    /*
    VOOR KLEUR rood:

    Grootste van figuren   is Cilinder [rood 14137,2]
    Grootste van balken    is Balk [rood 240,0]
    Grootste van cilinders is Cilinder [rood 14137,2]

    VOOR KLEUR geel:

    Grootste van figuren   is Cilinder [geel 2513,3]
    Grootste van balken    is Balk [geel 240,0]
    Grootste van cilinders is Cilinder [geel 2513,3]

    VOOR KLEUR blauw:

    Grootste van figuren   is Balk [blauw 24000,0]
    Grootste van balken    is Balk [blauw 24000,0]
    Grootste van cilinders is Cilinder [blauw 11309,7]
    */
}
