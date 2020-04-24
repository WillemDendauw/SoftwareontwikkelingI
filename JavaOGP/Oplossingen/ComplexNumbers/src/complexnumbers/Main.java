package complexnumbers;

import java.io.FileNotFoundException;
import java.util.Locale;

/**
 *
 * @author tiwi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Locale.setDefault(new Locale("en", "US"));
        /*
        ComplexNumber eenDerde = (new ComplexNumber(1000,1000)).gedeeldDoor(3);
        ComplexNumber benadering = new ComplexNumber(333.333,333.333);
        System.out.println("argument in graden: "+eenDerde.getArgumentInGraden()+"  "+benadering.getArgumentInGraden());
        System.out.println(""+eenDerde.hashCode());
        System.out.println(""+benadering.hashCode());

        
        ComplexNumber eenDerde = (new ComplexNumber(1,1)).gedeeldDoor(3);
        ComplexNumber benadering = new ComplexNumber(0.333,0.333);
        System.out.println("modulus is "+eenDerde.getModulus());
        System.out.println("argument is "+eenDerde.getArgumentInGraden());
        System.out.println("modulus is "+benadering.getModulus());
        System.out.println("argument is "+benadering.getArgumentInGraden());
        
        
        ComplexNumber groot = new ComplexNumber(Math.cos(46*Math.PI/180),Math.sin(46*Math.PI/180));
        ComplexNumber klein = new ComplexNumber(Math.cos(45*Math.PI/180),Math.sin(45*Math.PI/180));
        System.out.println("modulus is "+groot.getModulus());
        System.out.println("argument is "+groot.getArgumentInGraden());
        System.out.println("modulus is "+klein.getModulus());
        System.out.println("argument is "+klein.getArgumentInGraden());
         */
/*
        String[] getallen = {"22.2+7.5i", "22.2-7.5i", "-22.2+7.5i", "-22.2-7.5i", "22k.2+7.5i","fd","i","x","ff",""};
        for (int i = 0; i < getallen.length; i++) {
            try {
                ComplexNumber cn = new ComplexNumber(getallen[i]);
            } catch (NoComplexNumberNotation e) {
                System.out.println(e.getMessage());    
            }
        }
        
*/        
        ComplexNumberDAO dao = new ComplexNumberDAO("deGrotVanAlibaba.txt");
        System.out.println(""+dao.getFoutmeldingen().trim());
    }

}
