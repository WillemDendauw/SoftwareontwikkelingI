/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorteren;

import java.util.ArrayList;

/**
 *
 * @author Willem Dendauw
 */
public class SortedStringList extends ArrayList<String> {
    
    public boolean add(String x) {
        int i=0;
        while(i < this.size() && this.get(i).compareTo(x) < 0){
            i++;
        }
        this.add(i,x);
        return true;
    }
}
