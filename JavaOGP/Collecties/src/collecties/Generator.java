/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecties;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Willem Dendauw
 */
public class Generator {

    private int onder;
    private int boven;

    public Generator(int onder, int boven) {
        this.onder = onder;
        this.boven = boven;
        
    }

    public Set<Integer> geefVerschillendeGetallen(int aantal) {
        Random rd = new Random();
        Set<Integer> getallen = new HashSet<>();
        for (int i = 0; i < aantal; i++) {
            int getal = rd.nextInt(boven-onder) + onder;
            getallen.add(getal);
        }
        return getallen;
    }
    
    public Set<Integer> geefVerschillendeGetallenInVolgorde(int aantal){
        Random rd = new Random();
        Set<Integer> getallen = new TreeSet<>();
        for(int i=0; i<aantal; i++){
            int getal = rd.nextInt(boven - onder) + onder;
            getallen.add(getal);
        }
        return getallen;
    }
}
