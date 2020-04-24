/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import complexnumbers.ComplexNumber;
import complexnumbers.NoComplexNumberNotation;
import java.util.Locale;
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
public class Zweinstein {

    public Zweinstein() {
    }

    @BeforeClass
    public static void setUpClass() {
        Locale.setDefault(new Locale("en", "US"));
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
    //constructortesten
    @Test
    //quadrant 1
    public void test1Constructor() {
        ComplexNumber cn = new ComplexNumber(1, 1);
        assertEquals("toString van C(1,1)", "1.000+1.000i", cn.toString());
    }

    @Test
    //quadrant 2
    public void test2Constructor() {
        ComplexNumber cn = new ComplexNumber(-1, 1);
        assertEquals("toString van C(-1,1)", "-1.000+1.000i", cn.toString());
    }

    @Test
    //quadrant 3
    public void test3Constructor() {
        ComplexNumber cn = new ComplexNumber(-1, -1);
        assertEquals("toString van C(1,-1)", "-1.000-1.000i", cn.toString());
    }

    @Test
    //quadrant 4
    public void test4Constructor() {
        ComplexNumber cn = new ComplexNumber(1, -1);
        assertEquals("toString van C(1,-1)", "1.000-1.000i", cn.toString());
    }

    @Test
    //tussen quadrant 4 en 1
    public void test5Constructor() {
        ComplexNumber cn = new ComplexNumber(1, 0);
        assertEquals("toString van C(1,0)", "1.000", cn.toString());
    }

    @Test
    //tussen 1 en 2
    public void test6Constructor() {
        ComplexNumber cn = new ComplexNumber(0, 1);
        assertEquals("toString van C(0,1)", "1.000i", cn.toString());
    }

    @Test
    //tussen 2 en 3
    public void test7Constructor() {
        ComplexNumber cn = new ComplexNumber(-1, 0);
        assertEquals("toString van C(-1,0)", "-1.000", cn.toString());
    }

    @Test
    //tussen 3 en 4
    public void test8Constructor() {
        ComplexNumber cn = new ComplexNumber(0, -1);
        assertEquals("toString van C(0,-1)", "-1.000i", cn.toString());
    }

    @Test
    //middelpunt met defaultparameter
    public void test9Constructor() {
        ComplexNumber cn = new ComplexNumber();
        assertEquals("toString van C(0,0)", "0.000", cn.toString());
    }
    
    //testen met constructor met parameter String
    @Test
    public void test1Constructor1() throws NoComplexNumberNotation{
        ComplexNumber cn = new ComplexNumber("0.000");
        assertEquals("toString van C(0.000)", "0.000", cn.toString());
    }
    
    @Test
    public void test2Constructor2()throws NoComplexNumberNotation{
        ComplexNumber cn = new ComplexNumber("-i");
        assertEquals("toString van C(-i)", "-1.000i", cn.toString());
    }
    
    @Test
    public void test2Constructor3()throws NoComplexNumberNotation{
        ComplexNumber cn = new ComplexNumber("i");
        assertEquals("toString van C(i)", "1.000i", cn.toString());
    }
    
    @Test
    public void test2Constructor4()throws NoComplexNumberNotation{
        ComplexNumber cn = new ComplexNumber("1-i");
        assertEquals("toString van C(1-i)", "1.000-1.000i", cn.toString());
    }
    
    @Test
    public void test2Constructor5()throws NoComplexNumberNotation{
        ComplexNumber cn = new ComplexNumber("1");
        assertEquals("toString van C(1)", "1.000", cn.toString());
    }
    
    @Test (expected=NoComplexNumberNotation.class)
    public void testVerkeerdFormaat() throws NoComplexNumberNotation{
        ComplexNumber cn = new ComplexNumber("i-1");
    }

    //modulus en argument testen
    //X-as
    @Test
    public void testModulus1() {
        ComplexNumber cn = new ComplexNumber(1, 0);
        assertEquals("Modulus van de C(1,0)", 1, cn.getModulus(), 0);
        assertEquals("Argument van de C(1,0)", 0, cn.getArgumentInGraden(), 0);
    }

    //Middelpunt
    @Test
    public void testModulus2() {
        ComplexNumber cn = new ComplexNumber();
        assertEquals("Modulus van de C(0,0)", 0, cn.getModulus(), 0);
        assertEquals("Argument van de C(0,0)", 0, cn.getArgumentInGraden(), 0);
    }

    //Random
    @Test
    public void testModulus3() {
        ComplexNumber cn = new ComplexNumber(1, 1);
        assertEquals("Modulus van de C(1,1)", Math.sqrt(2), cn.getModulus(), 0);
        assertEquals("Argument van de C(1,1)", 45, cn.getArgumentInGraden(), 0);
    }
}
