import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sorteren2017.Boek;
import sorteren2017.SorteerDemo;

/**
 *
 * @author tiwi
 */
public class TestSorteren {

    public TestSorteren() {
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

    // Next methods must be annotated with annotation @Test. 
    private final int[] getallen = {10, 5, 20, 30, 15, 10, 0, 20};
    private final int[] vanKleinNaarGroot = {0, 5, 10, 10, 15, 20, 20, 30};
    private final String[] woordenConstant = {"boot", "kinderen", "stoel", "volwassenen", "ei", "stoel", "kop", "zeshoek", "ei", "stoel"};
    private final String[] woorden = {"boot", "kinderen", "stoel", "volwassenen", "ei", "stoel", "kop", "zeshoek", "ei", "stoel"};
    private final String[] alfab = {"boot", "ei", "ei", "kinderen", "kop", "stoel", "stoel", "stoel", "volwassenen", "zeshoek"};
    private final String[] opLengte = {"ei", "ei", "kop", "boot", "stoel", "stoel", "stoel", "zeshoek", "kinderen", "volwassenen"};

    private final BoekenDAODummy boeken = new BoekenDAODummy();

    @Test
    public void oef1() {
        assertArrayEquals(vanKleinNaarGroot, SorteerDemo.geefGesorteerdeVersieVan(getallen));
    }

    @Test
    public void oef2() {
        assertArrayEquals(alfab, SorteerDemo.geefGesorteerdeVersieVan(woorden));

        // ga na of de methode 'geefGesorteerdeVersieVan' niets aan de parameter veranderde:
        assertArrayEquals(woorden, woordenConstant);
    }

    @Test
    public void oef3() {
        assertArrayEquals(opLengte, SorteerDemo.geefOpLengteGesorteerdeVersieVan(woorden));

        // ga na of de methode 'geefOpLengteGesorteerdeVersieVan' niets aan de parameter veranderde:
        assertArrayEquals(woorden, woordenConstant);
    }

    @Test
    public void oef4a() {
        // hier zetten we een array snel om naar een list:
        //    ARRAY -> LIST  via    mijnLijst = Arrays.asList(mijnArray)
        List<String> woordenlijst = Arrays.asList(woorden);

        List<String> gesorteerdeLijst = SorteerDemo.geefGesorteerdeVersieVan(woordenlijst);
        assertArrayEquals(alfab, gesorteerdeLijst.toArray(new String[0]));
        // hierboven deden we de omgekeerde beweging:
        //    LIST -> ARRAY   via   mijnArray = mijnLijst.toArray(new Type_van_array[0])

        // ga na of de methode 'geefGesorteerdeVersieVan' niets aan de parameter veranderde:
        assertArrayEquals(woordenConstant, woordenlijst.toArray(new String[0]));
    }

    @Test
    public void oef4b() {
        // hier zetten we een array snel om naar een list:
        //    ARRAY -> LIST  via    mijnLijst = Arrays.asList(mijnArray)
        List<String> woordenlijst = Arrays.asList(woorden);

        List<String> gesorteerdeLijst = SorteerDemo.geefOpLengteGesorteerdeVersieVan(woordenlijst);
        assertArrayEquals(opLengte, gesorteerdeLijst.toArray(new String[0]));
        // hierboven deden we de omgekeerde beweging:
        //    LIST -> ARRAY   via   mijnArray = mijnLijst.toArray(new Type_van_array[0])

        // ga na of de methode 'geefGesorteerdeVersieVan' niets aan de parameter veranderde:
        assertArrayEquals(woordenConstant, woordenlijst.toArray(new String[0]));
    }

    @Test
    public void oef5a() {
        // sorteren op basis van titel (met default-vergelijkingsopdracht, nl. compareTo van klasse Boek)
        // vul zelf aan
    }
    
    @Test
    public void oef5b() {
        // sorteerder op basis van auteur: vul deze test aan.
        // boek1 komt voor boek2,
        // boek1 komt voor boek3,
        // boek3 komt na boek1
        Boek boek1 = new Boek("aa", "A. Van der Aa");
        Boek boek2 = new Boek("bb", "B. De Beer");
        Boek boek3 = new Boek("cc", "A. Van der Aa");
    }    

    @Test
    public void oef5c() {
        // sorteren op basis van auteur 
        // vul zelf aan
    }
    
    @Test
    public void oef5d(){
        // sorteren op basis van auteur; DIEPE KOPIE
    }

    @Test
    public void oef6() {
        // zelf te schrijven
    }

    @Test
    public void oef7() {
        // zelf te schrijven
    }
}
