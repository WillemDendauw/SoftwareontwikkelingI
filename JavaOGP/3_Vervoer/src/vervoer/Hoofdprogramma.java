/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vervoer;

import java.io.FileNotFoundException;

/**
 *
 * @author Marleen
 */
public class Hoofdprogramma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        /*
        //Testen van de klasse Trein en MaxGawichtTruck
        Trein treintje = new Trein(125, 245, "ja");
        System.out.println("Maximale snelheid : " + treintje.getMaxSnelheid());
        System.out.println("Aantal passagiers : " + treintje.getAantalPassagiers());
        System.out.println(treintje);

        MaxGewichtTruck truck = new MaxGewichtTruck(125, 200, 35);
        System.out.println("Maximale snelheid : " + truck.getMaxSnelheid());
        System.out.println("Aantal passagiers : " + truck.getAantalPassagiers());
        System.out.println(truck.toString());
        if (truck.isOverLaden()) {
            System.out.println("Is overladen");
        }
         */

        //eerste versie (zonder args)
        //Voertuigen voertuigen = new Voertuigen("vervoer.csv");  //(*)
        //aangepast met args
        if (args.length > 0) {
            System.out.println("Bestand "+args[0] + " wordt verwerkt");
            Voertuigen voertuigen = new Voertuigen(args[0]);
            //verdere verwerking komt hier  

            System.out.println("Max snelheid treinen is " + voertuigen.maxSnelheidTreinen()); //zonder parameter

            Trein snelste = voertuigen.geefSnelsteTrein();
            System.out.println(snelste);
            //vervolg
            Truck vrachtwagen = voertuigen.kiesTruck();
            System.out.println(vrachtwagen.toString());
            System.out.println("Aantal zware trucks is " + voertuigen.aantalMaxGewichtTruck());
            System.out.println("aantal overladen trucks: " + voertuigen.aantalOverladen());

       } else {
          System.out.println("Geef de bestandsnaam op als argument.");
        }

    }

}
