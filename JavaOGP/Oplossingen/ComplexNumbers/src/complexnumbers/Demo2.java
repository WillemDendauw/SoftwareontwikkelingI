package complexnumbers;

/**
 *
 * @author tiwi
 */
public class Demo2 {
    /*
    public static void main(String[] args) {
        ComplexNumber cn = new ComplexNumber(-1, 1);
        if (cn.getModulus() == 1.4142135623730951) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL: expected 1.4142135623730951, found "+cn.getModulus());
        }

        cn = new ComplexNumber(2.0 / 5, -7);
        if (cn.getModulus() == 7.011419257183241) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL: expected 7.011419257183241, found "+cn.getModulus());
        }
    }
    
    */
    
    public static void main(String[] args) {
        ComplexNumber cn = new ComplexNumber(-1, 1);
        checkEqual(1.4142135623730951,cn.getModulus());
        
        cn = new ComplexNumber(2.0 / 5, -7);       
        checkEqual(7.011419257183241,cn.getModulus());
    }
    
    /*
    public static void checkEqual(double expected, double actual){
        if(expected == actual){
            System.out.println("OK");
        }
        else{
            System.out.println("FAIL: expected "+expected+", found "+actual);
        }
    }
    */
    
    public static void checkEqual(double expected, double actual){
        if( Math.abs(expected-actual) < 0.00001){
            System.out.println("OK");
        }
        else{
            System.out.println("FAIL: expected "+expected+", found "+actual);
        }
    }
    
}
