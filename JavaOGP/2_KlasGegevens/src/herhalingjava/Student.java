/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herhalingjava;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marleen
 */
public class Student extends Persoon {

    //De arrays zijn niet langer constant - de naam werd dus in kleine letters gezet
    //Je moet dit consequent aanpassen in deze klasse !!
    public static String[] testen;// = {"Java", "Guis", "Databanken"};
    private static int[] gewicht;// = {50, 30, 20};   //toegevoegd voor de berekening van het eindtotaal

    private double[] punten;  //niet statisch, want verschillend voor elke student
    private String richting;

    public static void initTesten(String testlijn, String gewichtenLijn) {
        testen = testlijn.split(";");
        testen = Arrays.copyOfRange(testen, 3, testen.length);
        int aantal = testen.length;
        Scanner sc = new Scanner(gewichtenLijn.substring(3)); //de eerste drie tekens niet gebruiken (hardgecodeerd)
        sc.useDelimiter(";");
        gewicht = new int[aantal];
        for (int i = 0; i < aantal; i++) {
            gewicht[i] = sc.nextInt();
        }
        sc.close();
    }

    public void addPunten(String lijn) {
        punten = new double[testen.length];   //elementen aanmaken
        Scanner sc = new Scanner(lijn);
        sc.useDelimiter(";");
        sc.useLocale(Locale.FRENCH);
        for (int i = 0; i < punten.length; i++) {           //en invullen
            punten[i] = sc.nextDouble();
        }
        sc.close();
    }

    public Student(String naam, int leeftijd, String richting) {
        super(naam, leeftijd);
        this.richting = richting;

        punten = new double[testen.length]; //initialiseren van het juiste aantal elementen in de array  
        //leesPunten();
        kiesPunten(); //om sneller te kunnen testen
    }

    public String getRichting() {
        return richting;
    }

    @Override
    public String toString() {
        String resultaten = "";
        for (int i = 0; i < testen.length; i++) {
            resultaten = resultaten + "\n\t" + testen[i] + ": " + punten[i] + "/20";
        }
        return super.toString() + " volgt " + richting + resultaten;
    }

    public void leesPunten() {
        System.out.println("Geef de punten van " + getNaam());
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < testen.length; i++) {
            System.out.println("\tvoor " + testen[i] + ": ");
            punten[i] = sc.nextDouble();
        }
    }

    public void kiesPunten() {
        Random r = new Random();
        for (int i = 0; i < testen.length; i++) {
            int grootgetal = r.nextInt(71) + 80; //80,81,...150
            punten[i] = grootgetal / 10.0;     //reeel delen door 10
        }
    }

    public boolean isGeslaagdVoor(String test) {
        for (int i = 0; i < testen.length; i++) {
            if (testen[i].equals(test)) {

                if (punten[i] >= 10) {
                    return true;
                } else {
                    return false;
                }
                //of if-else inkorten tot:   return ( punten[i]>=10 );   
            }
        }
        return false;  //wordt door NetBeans opgelegd
    }

    //minder mooie oplossing, die niet werkt als het aantal testen aangepast wordt
    public int geefTotaal_eersteVersie() {
        double som = punten[0] * 5 / 2 + punten[1] * 3 / 2 + punten[2];
        int afgerond = (int) Math.round(som); //casten van long naar int
        return afgerond;
    }

    //betere oplossing - array gewicht werd toegevoegd
    public int geefTotaal() {
        double tot = 0;
        double max = 0;
        for (int i = 0; i < testen.length; i++) {
            tot = tot + punten[i] * gewicht[i] / 20;
            max = max + gewicht[i];
        }
        int afgerond = (int) Math.round(tot * 100 / max); //naar 100 omrekenen en correct afronden
        return afgerond;
    }

}
