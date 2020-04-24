/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorteren;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Willem Dendauw
 */
public class SortedList<T> extends ArrayList<T> {
    
    private Comparator<T> comparator;
    
    public SortedList(Comparator<T> comparator){
        this.comparator = comparator;
    }
    
    @Override
    public boolean add(T elt){
        int i =0;
        while(i<this.size() && comparator.compare(this.get(i),elt) < 0) {
            i++;
        }
        this.add(i,elt);
        return true;
    }
}
