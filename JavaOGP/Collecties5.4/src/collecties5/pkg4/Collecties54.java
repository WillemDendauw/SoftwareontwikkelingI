/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecties5.pkg4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Willem Dendauw
 */
public class Collecties54 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer,List> woorden = new HashMap<>();
        String zin = "alleen ga je sneller samen kom je verder";
        Scanner sc = new Scanner(zin);
        sc.useDelimiter(" ");
        while(sc.hasNext()){
            String woord = sc.next();
            int lengte = woord.length();
            List hulp = new ArrayList();
            hulp = woorden.get(lengte);
            hulp.add(woord);
            woorden.put(lengte, hulp);
        }
    }
    
}
