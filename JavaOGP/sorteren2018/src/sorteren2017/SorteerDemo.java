package sorteren2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author tiwi
 */
public class SorteerDemo {
    
    // oef 1: pas aan 
    public static int[] geefGesorteerdeVersieVan(int... getallen){
        int[] x = getallen.clone();
        Arrays.sort(x);
        return x;
    }
    
    public static String[] geefGesorteerdeVersieVan(String... woorden ){
        String[] x = woorden.clone();
        Arrays.sort(x);
        return x;
    }
    
    public static String[] geefOpLengteGesorteerdeVersieVan(String... woorden){
        String[] x = woorden.clone();
        Arrays.sort(x, new StringVergelijkerOpLengte());
        return x;
    }
    
    public static List<String> geefGesorteerdeVersieVan(List<String> woorden ){
        List<String> kopie = new ArrayList(woorden);
        Collections.sort(kopie);
        return kopie;
    }
    
    public static List<String> geefOpLengteGesorteerdeVersieVan(List<String> woorden){
        List<String> kopie = new ArrayList(woorden);
        Collections.sort(kopie, new StringVergelijkerOpLengte());
        return kopie;
    }
    
    public static List<Boek> geefOpTitelGesorteerdeVersieVan(List<Boek> boeken) {
        List<Boek> kopie = new ArrayList<>(boeken);
        Collections.sort(kopie);
        return kopie;
    }
    
    public static List<Boek> geefOpAuteurGesorteerdeVersieVan(List<Boek> boeken){
        List<Boek> kopie = new ArrayList<>(boeken);
        Collections.sort(kopie, new ComparatorOpAuteur());
        return kopie;
    }
    
    public static List<Boek> geefOptitleGesorteerdeDiepeKopieVan(List<Boek> boeken) {
        List<Boek> kopie = new ArrayList<>();
        for (Boek b: boeken){
            kopie.add(b.clone());
        }
        Collections.sort(kopie);
        return kopie;
    }
    
    public static List<Boek> geefOpAuteurGesorteerdeDiepeKopieVan(List<Boek> boeken){
        List<Boek> kopie = new ArrayList<>();
        for (Boek b: boeken) {
            kopie.add(b.clone());
        }
        Collections.sort(kopie, new ComparatorOpAuteur());
        return kopie;
    }
    
    
}
