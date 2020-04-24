/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krijgers;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Willem Dendauw
 */
public abstract class KrijgersDAO {
    
    public abstract Krijger[] getKrijgers();
    
    public SortedSet<Krijger> getKrijgersAlfa(){
        return new TreeSet<>(Arrays.asList(getKrijgers()));
    }
    
    public SortedSet<Krijger> getKrijgersVergelijker(){
        SortedSet krijgers = new TreeSet(new KrijgerVergelijker());
        krijgers.addAll(Arrays.asList(getKrijgers()));
        return krijgers;
    }
}
