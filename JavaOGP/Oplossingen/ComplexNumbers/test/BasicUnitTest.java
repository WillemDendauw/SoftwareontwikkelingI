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
 * @author tiwi
 */
public class BasicUnitTest {

    public BasicUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        // om alle input en output met decimale punt te krijgen
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

    @Test
    public void testToString0(){
        ComplexNumber cn = new ComplexNumber(0,0);
        assertEquals("toString voor nul?","0.000",cn.toString());        
    }
    @Test
    public void testToString1(){
        ComplexNumber cn = new ComplexNumber(0,1);
        assertEquals("toString voor i?","1.000i",cn.toString());        
    }
    @Test
    public void testToString2(){
        ComplexNumber cn = new ComplexNumber(0,-1);
        assertEquals("toString voor -i?","-1.000i",cn.toString());        
    }
    @Test
    public void testToString3(){
        ComplexNumber cn = new ComplexNumber(1,0.000005);
        assertEquals("toString voor 1+0.0000005?","1.000",cn.toString());        
    }
    
}
