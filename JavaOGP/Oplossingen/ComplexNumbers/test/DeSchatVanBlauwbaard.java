import complexnumbers.ComplexNumber;
import complexnumbers.ComplexNumberDAO;
import complexnumbers.NoComplexNumberNotation;
import java.io.FileNotFoundException;
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
public class DeSchatVanBlauwbaard {

    public DeSchatVanBlauwbaard() {
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

    // er zijn 11 gevallen te onderscheiden:
    // 4 op de assen (reeel/imganair, postief/negatief)
    // 1 op de kruising van de assen
    // 4 in de kwadranten
    // en tenslotte nog de speciale notatie i of -i
    // EERST IN DE KWADRANTEN
    @Test
    public void constructorKwadrant1() {
        ComplexNumber cn = new ComplexNumber(1, 2);
        assertEquals("constructor met 2 argumenten of toString niet juist?", "1.000+2.000i", cn.toString());
    }

    @Test
    public void constructorKwadrant2() {
        ComplexNumber cn = new ComplexNumber(-2.22, -3.33);
        assertEquals("constructor met 2 negatieve argumenten niet juist?", "-2.220-3.330i", cn.toString());

    }

    @Test
    public void constructorKwadrant3() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("-3.45+7i");
        assertEquals("constructor met String niet juist?", "-3.450+7.000i", cn.toString());

    }

    @Test
    public void constructorKwadrant4() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("3.45-7i");
        assertEquals("constructor met String niet juist?", "3.450-7.000i", cn.toString());

    }

    @Test
    public void constructorNul() {
        ComplexNumber cn = new ComplexNumber();
        assertEquals("defaultConstructor niet juist?", "0.000", cn.toString());

    }

    @Test
    public void constructorNulViaString() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("0");
        assertEquals("constructor met String niet juist?", "0.000", cn.toString());
    }

    @Test
    public void constructorenAs1() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("-5i");
        assertEquals("constructor met String niet juist?", "-5.000i", cn.toString());
    }

    @Test
    public void constructorenAs2() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("5i");
        assertEquals("constructor met String niet juist?", "5.000i", cn.toString());
    }

    @Test
    public void constructorenAs3() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("-5");
        assertEquals("constructor met String niet juist?", "-5.000", cn.toString());
    }

    @Test
    public void constructorenAs4() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("5");
        assertEquals("constructor met String niet juist?", "5.000", cn.toString());
    }

    @Test
    public void constructorSpeciaal1() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("i");
        assertEquals("constructor met String niet juist?", "1.000i", cn.toString());

    }

    @Test
    public void constructorSpeciaal2() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("-i");
        assertEquals("constructor met String niet juist?", "-1.000i", cn.toString());
    }

    @Test(expected = NoComplexNumberNotation.class)
    public void constructorSpeciaal3() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber("tekst eindigend op i");
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
    
    @Test
    public void poolcoordinaten() throws NoComplexNumberNotation {
        ComplexNumber cn = new ComplexNumber();
        assertEquals("argument van 0?", 0, cn.getArgumentInGraden());
        assertEquals("modulus van 0?", 0.0, cn.getModulus(), 0.001);

        cn = new ComplexNumber("-i");
        assertEquals("argument van -i?", -90, cn.getArgumentInGraden());
        assertEquals("modulus van -i?", 1, cn.getModulus(), 0.001);

        cn = new ComplexNumber("i");
        assertEquals("argument van i?", 90, cn.getArgumentInGraden());
        assertEquals("modulus van i?", 1, cn.getModulus(), 0.001);

        cn = new ComplexNumber("-1");
        assertEquals("argument van -1?", 180, cn.getArgumentInGraden());
        assertEquals("modulus van -1?", 1, cn.getModulus(), 0.001);
    }

    @Test
    public void testVermeerderMet() {
        ComplexNumber cn = new ComplexNumber(-2, 3);
        cn.vermeerderMet(new ComplexNumber(-1, 1));
        cn.vermeerderMet(new ComplexNumber(-10, 10));
        assertEquals("vermeerder met niet juist?", "-13.000+14.000i", cn.toString());
    }

    @Test
    public void testSom() {
        ComplexNumber cn = new ComplexNumber(-11, 22);
        ComplexNumber som = cn.som(new ComplexNumber(-33, 44));
        assertEquals("som niet juist?", "-44.000+66.000i", som.toString());
    }

    @Test
    public void testSommatie() {
        ComplexNumber som = ComplexNumber.sommatie(new ComplexNumber(-1, 1), new ComplexNumber(), new ComplexNumber(-2, 2), new ComplexNumber(-3, 3));
        assertEquals("sommatie niet juist?", "-6.000+6.000i", som.toString());
    }

    @Test
    public void testSommatieEnGedeeldDoor() {
        ComplexNumber eenDerde = (new ComplexNumber(1, -1)).gedeeldDoor(3);
        ComplexNumber som = ComplexNumber.sommatie(eenDerde, eenDerde, eenDerde);
        assertEquals("sommatie niet juist?", "1.000-1.000i", som.toString());
    }

    @Test
    public void testProduct() {
        ComplexNumber a = new ComplexNumber(2, -1);
        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber nul = new ComplexNumber();
        assertEquals("product niet juist?", "10.000+5.000i", a.product(b).toString());
        assertEquals("product met nul niet juist?", "0.000", b.product(nul).toString());
        assertEquals("product van nul niet juist?", "0.000", nul.product(a).toString());
    }
    
    @Test
    public void inlezenBestand() throws FileNotFoundException {
        String fouten = "is geen complex getal: dit\n"
                + "is geen complex getal: is\n"
                + "is geen complex getal: verkeerde\n"
                + "is geen complex getal: input\n"
                + "is geen complex getal: oei\n"
                + "is geen complex getal: hier\n"
                + "is geen complex getal: staat\n"
                + "is geen complex getal: nu\n"
                + "is geen complex getal: weer\n"
                + "is geen complex getal: rommel\n"
                + "is geen complex getal: 8a+7b";
        ComplexNumberDAO dao = new ComplexNumberDAO("deSchatVanBlauwbaard.txt");
        assertEquals("bestand juist ingelezen?", "48.470-12.902i", dao.totaleSom().toString());
        assertEquals("foutmeldingen juist verwerkt?", fouten, dao.getFoutmeldingen().trim());
    }

}
