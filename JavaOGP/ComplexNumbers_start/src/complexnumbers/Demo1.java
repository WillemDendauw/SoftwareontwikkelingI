package complexnumbers;


/**
 *
 * @author tiwi
 */
public class Demo1 {

    public static void main(String[] args) {
        ComplexNumber cn = new ComplexNumber(-1, 1);
        System.out.println("Modulus van -1+i is "+cn.getModulus());
        
        cn = new ComplexNumber(2.0 / 5, -7);
        System.out.println("Modulus van 0.4-7i is "+cn.getModulus());
    }

}
