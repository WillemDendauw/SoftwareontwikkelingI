package presidenten;

import java.io.FileNotFoundException;

/**
 *
 * @author tiwi
 */
public class Main {

    public static void main(String[] args) {

        // DEEL 1
        
        // KLASSE AMBTSPERIODE
        // Schrijf hier code om een ambtsperiode aan te maken van 
        // 8 mei 1966 tot 8 mei 1970 (duur: 1)
        // (1a) ...
        Ambtsperiode per1 = new Ambtsperiode("8 mei 1966","8 mei 1970",1);
        // En schrijf die ambtsperiode dan uit op het scherm, in de vorm
        // [1 periode(s), van 8 mei 1966 tot 8 mei 1970]
        // (1b) ...
        System.out.println("["+per1.getDuur()+" periode(s), van 8 mei 1966 tot 8 mei 1970");
        
        // KLASSE PERSOON
        Persoon jantje = new Persoon("Jan Klaassen","(1634-2017)"); // (2a)
        System.out.println("Volksfiguur: "+jantje);                 // (2b)
        // Zorg ervoor dat op het scherm verschijnt:
        // Volksfiguur: Jan Klaassen (1634-2017)
        
        
        // KLASSE PRESIDENT
        President donald = new President("Trump","(1946-...)","20 januari 2017","onbekend",0); // (3a)
        System.out.println("President: "+donald);                                              // (3b)
        // Zorg ervoor dat op het scherm verschijnt:
        // President: Trump (1946-...) [0 periodes, van 20 januari 2017 tot onbekend]

        // VUL AAN VOOR INLEZEN VAN HET BESTAND

    }

}
