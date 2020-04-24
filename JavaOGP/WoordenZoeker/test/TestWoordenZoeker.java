/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import woordenzoeker.WoordenZoeker;

/**
 *
 * @author tiwi
 */
public class TestWoordenZoeker {

    public TestWoordenZoeker() {
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

    @Test(expected = FileNotFoundException.class)
    public void testConstructorOnbestaandBestand() throws FileNotFoundException {
        WoordenZoeker zoeker = new WoordenZoeker("onbestaandBestand.txt");
    }

    @Test
    public void testAantal() throws FileNotFoundException {
        WoordenZoeker zoeker = new WoordenZoeker("simpel.txt");
        Assert.assertEquals("aantal verschillende woorden niet juist geteld", 6, zoeker.aantalVerschillendeWoorden());
    }
    
    @Test
    public void testAantalEnInlezenEnBewaren() throws FileNotFoundException{
        WoordenZoeker zoeker = new WoordenZoeker("symbolen.txt");
        Assert.assertEquals("Elk stukje tekst (witruimte geldt als scheidingsteken) moet als String ingelezen worden",5,zoeker.aantalVerschillendeWoorden());
        WoordenZoeker zoeker2 = new WoordenZoeker("kleineEnGroteLetters.txt");
        Assert.assertEquals("Grote letters worden als kleine behandeld",1,zoeker2.aantalVerschillendeWoorden());
        
    }

    @Test
    public void testAlfabetischEersteWoord() throws FileNotFoundException {
        WoordenZoeker zoeker = new WoordenZoeker("woorden.txt");
        Assert.assertEquals("eerste woord (volgens alfabetische volgorde) is niet juist", "a",
                zoeker.alfabetischEersteWoord());
    }

    @Test
    public void testAlfabetischEersteWoordVanLengte() throws FileNotFoundException {
        WoordenZoeker zoeker = new WoordenZoeker("woorden.txt");
        String[] oplossingen = {null,"a","am","age","able","along","action","confess","changing","attribute","consistent","development","fundamentals",null};
        for (int i = 0; i < 13; i++) {
            Assert.assertEquals("eerste woord (volgens alfabetische volgorde) van lengte " + i + " is niet juist", oplossingen[i],
                    zoeker.alfabetischEersteWoordVanLengte(i));
        }
    }

}
