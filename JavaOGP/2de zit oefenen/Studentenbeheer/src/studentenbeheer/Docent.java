/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenbeheer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Willem Dendauw
 */
public class Docent extends Persoon{
    
    private Set<Cursus> cursussen = new HashSet<>();
    
    public Docent(String voornaam, String naam){
        super(voornaam,naam,"",0,"","");
    }
    
    public void addCursus(Cursus cursus){
        cursussen.add(cursus);
    }
    
    public boolean geeftCursus(Cursus cursus){
        for(Cursus cr : cursussen){
            if(cr.equals(cursus.getNaam())){
                return true;
            }
        }
        return false;
    }
    
    public Set<Cursus> getCursussen() {
        return cursussen;
    }
}
