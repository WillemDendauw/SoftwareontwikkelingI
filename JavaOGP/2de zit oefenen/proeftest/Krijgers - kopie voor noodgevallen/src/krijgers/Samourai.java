/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krijgers;

/**
 *
 * @author Willem Dendauw
 */
public class Samourai extends Krijger {
    
    public Samourai(String naam, int aantalLevens){
        this.naam = naam;
        this.levens = aantalLevens;
        this.aantalGewonnen = 0;
    }
    
    public int getAanvalskracht(){
        return r.nextInt(75*levens + 75*aantalGewonnen);
    }
    
    public int getVerdedigingskracht(){
        return r.nextInt(80*levens + 80*aantalGewonnen);
    }
}
