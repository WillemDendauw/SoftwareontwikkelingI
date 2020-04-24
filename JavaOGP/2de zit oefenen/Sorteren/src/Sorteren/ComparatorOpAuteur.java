/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorteren;

import java.util.Comparator;

/**
 *
 * @author Willem Dendauw
 */
public class ComparatorOpAuteur implements Comparator<Boek> {
    
    @Override
    public int compare(Boek o1, Boek o2) {
        if(!(o1.getAuteur().equals(o2.getAuteur()))){
            return o1.getAuteur().compareTo(o2.getAuteur());
        }
        else {
            return o1.compareTo(o2);
        }
    }
    
}
