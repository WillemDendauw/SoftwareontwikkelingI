package complexnumbers;

/**
 *
 * @author tiwi
 */
public class NoComplexNumberNotation extends Exception {

    public NoComplexNumberNotation(String s) {
        super("is geen complex getal: "+s);
    }
    
}
