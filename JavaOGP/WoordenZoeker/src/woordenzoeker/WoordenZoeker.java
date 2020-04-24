package woordenzoeker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ...
 */
public class WoordenZoeker{
    private Set<String> woorden = new TreeSet<>();
    
    public WoordenZoeker(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));
        while(sc.hasNext()){
            String woord = sc.next().toLowerCase();
            woorden.add(woord);
        }
    }
    
    public int aantalVerschillendeWoorden(){
        return woorden.size();
    }
    
    public String alfabetischEersteWoord(){
        for(String woord: woorden){
            return woord;
        }
        return null;
    }
    
    public String alfabetischEersteWoordVanLengte(int i){
        for(String woord: woorden){
            if(woord.length() == i){
                return woord;
            }
        }
        return null;
    }
}
