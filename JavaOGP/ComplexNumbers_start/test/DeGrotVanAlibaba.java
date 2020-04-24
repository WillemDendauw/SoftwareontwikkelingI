import complexnumbers.ComplexNumber;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
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
public class DeGrotVanAlibaba {

    public DeGrotVanAlibaba() {
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
    public void testGelijkheid() {
        // zoek naar twee getallen die iets van elkaar verschillen, maar niet teveel:
        // hun modulus mag niet meer dan 0.001 verschillen!
        ComplexNumber duizendDerde = (new ComplexNumber(1000, 1000)).gedeeldDoor(3);
        ComplexNumber benadering = new ComplexNumber(333.333, 333.333);
        assertTrue("equals in orde voor gelijke objecten?", duizendDerde.equals(benadering));
        assertTrue("hashCode in orde voor gelijke objecten?", duizendDerde.hashCode() == benadering.hashCode());
    }

    @Test
    public void testOngelijkheid() {
        // nu nemen we twee getallen die teveel van elkaar verschillen,
        // het verschil tussen hun moduli is meer dan 0.001.
        ComplexNumber eenDerde = (new ComplexNumber(1, 1)).gedeeldDoor(3);
        ComplexNumber benadering = new ComplexNumber(0.333, 0.333);
        assertFalse("equals in orde voor ongelijke objecten?", eenDerde.equals(benadering));
        //assertFalse("hashCode in orde voor ongelijke objecten (hoeft niet per se)?", eenDerde.hashCode() == benadering.hashCode());
    }

    @Test
    public void inHashSetBewaren() {
        Set<ComplexNumber> verz = new HashSet<>();
        verz.add((new ComplexNumber(1000, -1000)).gedeeldDoor(3));
        verz.add(new ComplexNumber(333.3333, -333.3333));
        assertEquals("size van hashSet is niet juist; reële getallen goed vergeleken?", 1, verz.size());
    }

    @Test(expected = NullPointerException.class)
    public void testCompareTo1() {
        ComplexNumber cn = new ComplexNumber();
        cn.compareTo(null);
    }

    @Test(expected = ClassCastException.class)
    public void testCompareTo2() {
        ComplexNumber cn = new ComplexNumber();
        cn.compareTo("hallo");
    }

    @Test(expected = ClassCastException.class)
    public void testCompareTo3() {
        ComplexNumber cn = new ComplexNumber();
        cn.compareTo(new Double(7.7));
    }

    @Test
    public void testCompareTo4() {
        ComplexNumber duizendDerde = new ComplexNumber(1000, -1000).gedeeldDoor(3);
        ComplexNumber benaderingDuizendDerde = new ComplexNumber(333.333, -333.333);
        assertEquals("compareTo van (quasi) gelijke getallen in orde?", 0, duizendDerde.compareTo(benaderingDuizendDerde));

        ComplexNumber eenDerde = new ComplexNumber(1, -1).gedeeldDoor(3);
        ComplexNumber benaderingEenDerde = new ComplexNumber(0.333, -0.333);
        assertTrue("compareTo van dicht bij elkaar liggende getallen in orde (modulus licht verschillend, argument gelijk)?", eenDerde.compareTo(benaderingEenDerde) > 0);
        assertTrue("compareTo van dicht bij elkaar liggende getallen in orde (modulus licht verschillend, argument gelijk)?", benaderingEenDerde.compareTo(eenDerde) < 0);

        ComplexNumber groot = new ComplexNumber(Math.cos(46 * Math.PI / 180), Math.sin(46 * Math.PI / 180));
        ComplexNumber klein = new ComplexNumber(Math.cos(45 * Math.PI / 180), Math.sin(45 * Math.PI / 180));
        assertTrue("compareTo van (quasi) gelijke getallen in orde (modulus gelijk, argument met 1 graad verschillend)?", groot.compareTo(klein) > 0);
        assertTrue("compareTo van (quasi) gelijke getallen in orde (modulus gelijk, argument met 1 graad verschillend)?", klein.compareTo(groot) < 0);
    }

    @Test
    public void inTreeSetBewaren() {
        Set<ComplexNumber> verz = new TreeSet<>();
        // deze getallen zijn net NIET gelijk
        verz.add((new ComplexNumber(1, -1)).gedeeldDoor(3));
        verz.add(new ComplexNumber(0.333, -0.333));
        assertEquals("size van treeSet is niet juist; complexe getallen goed vergeleken (2 net niet gelijk)?", 2, verz.size());
        // deze getallen zijn net WEL gelijk
        verz.add((new ComplexNumber(1000, -1000)).gedeeldDoor(3));
        verz.add(new ComplexNumber(333.333, -333.333));
        assertEquals("size van treeSet is niet juist; complexe getallen goed vergeleken (2 wel gelijk)?", 3, verz.size());
    }    

}
