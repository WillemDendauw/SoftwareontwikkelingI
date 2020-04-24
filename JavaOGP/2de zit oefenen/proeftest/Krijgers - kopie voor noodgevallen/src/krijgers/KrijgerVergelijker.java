/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krijgers;

import java.util.Comparator;

/**
 *
 * @author Willem Dendauw
 */
public class KrijgerVergelijker implements Comparator<Krijger> {

    
    
    @Override
    public int compare(Krijger o1, Krijger o2) {
        if(o1.isLevend() && o2.isLevend()){
            return vergelijk(o1,o2);
        }
        else if (o1.isLevend()) {
            return -1;
        }
        else if (o2.isLevend()){
            return 1;
        }
        else {
            return vergelijk(o1,o2);
        }
    }
    
    private int vergelijk(Krijger o1,Krijger o2){
        if(o1.getAantalGewonnen() != o2.getAantalGewonnen()){
            return o2.getAantalGewonnen() - o1.getAantalGewonnen();
        }
        else if (o1.getAantalLevens() != o2.getAantalLevens()) {
            return o2.getAantalLevens() - o1.getAantalLevens();
        }
        else {
            return o1.compareTo(o2);
        }
    }
    
}
