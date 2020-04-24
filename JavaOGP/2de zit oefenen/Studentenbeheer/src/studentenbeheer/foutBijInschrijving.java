/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenbeheer;

/**
 *
 * @author Willem Dendauw
 */
public class foutBijInschrijving extends Exception {
    
    
    public foutBijInschrijving() {
        
    }
    
    public foutBijInschrijving(String msg) {
        super(msg);
    }
}
