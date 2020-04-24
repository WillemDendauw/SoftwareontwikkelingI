/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krijgers;

import java.util.Random;

/**
 *
 * @author Willem Dendauw
 */
public abstract class Krijger implements Comparable<Krijger> {
    protected String naam;
    protected int levens;
    protected int aantalGewonnen;
    protected int aanvalskracht;
    protected int verdedigingskracht;
    protected Random r = new Random();

    public String getNaam(){
        return naam;
    }
    
    public int getAantalLevens(){
        return levens;
    }
    
    public boolean isLevend(){
        return levens>0;
    }
    
    public int getAantalGewonnen(){
        return aantalGewonnen;
    }
    
    public void win(){
        aantalGewonnen++;
    }
    
    public void verlies(){
        levens--;
    }
    
    public abstract int getAanvalskracht();
    
    public abstract int getVerdedigingskracht();
    
    @Override
    public int compareTo(Krijger k){
        if(naam.compareTo(k.getNaam()) == 0){
            if(k.isLevend() && this.isLevend()){
                return 0;
            }
            else if (k.isLevend()){
                return 1;
            }
            else if (this.isLevend()){
                return -1;
            }
            else return 0;
        }
        else {
            return naam.compareTo(k.getNaam());
        }
    }
}
