/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herhalingjava;

/**
 *
 * @author Marleen
 */
public class Persoon {
    private String naam;
    private int leeftijd;
    
    public Persoon(String naam, int leeftijd)
    {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }
    
    public Persoon()
    {
        this("Anoniem",0); 
    }
    
    public String getNaam()
    {
        return naam;    
    }
    
    @Override
    public String toString()
    {
        return naam+" is " + leeftijd + " jaar";
    }
}
