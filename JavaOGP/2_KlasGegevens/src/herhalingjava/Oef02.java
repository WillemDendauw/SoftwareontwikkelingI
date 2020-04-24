/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herhalingjava;

import java.io.FileNotFoundException;

/**
 *
 * @author Marleen
 */
public class Oef02 {

    //Uittesten van de klasse Klasgroep
    public static void main(String[] args) throws FileNotFoundException {
        Klasgroep klasgroep = new Klasgroep("studenten.csv");
        for(String test : Student.testen)    //lukt enkel indien de array testen public is gemaakt
        {
            System.out.println("Aantal geslaagd voor " + test + ": " + klasgroep.aantalGeslaagdenVoor(test,"???"));
        }
        
      
        
        
        Student beste = klasgroep.geefBesteStudent();
        System.out.println(beste.getNaam()+" behaalt " + beste.geefTotaal()+"%");
    }
    
}
