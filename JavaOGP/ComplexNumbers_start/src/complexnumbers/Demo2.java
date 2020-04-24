package complexnumbers;

/**
 *
 * @author tiwi
 */
public class Demo2 {

    public static void main(String[] args) {
        ComplexNumber cn = new ComplexNumber(-1, 1);
        checkEqual(1.4142135623730951, cn.getModulus());
        cn = new ComplexNumber(2.0 / 5, -7);
        checkEqual(7.011419257183241, cn.getModulus());
    }

    public static void checkEqual(double expected, double actual) {
        if (Math.abs(expected - actual) < 1e-5) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL: expected: " + expected + ", found: " + actual);
        }
    }

}
