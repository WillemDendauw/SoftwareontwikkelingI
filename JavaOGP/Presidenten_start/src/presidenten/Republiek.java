/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Willem Dendauw
 */
public class Republiek {

    private President[] presidenten;
    
    public Republiek(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));
        int aantal = sc.nextInt();
        presidenten = new President[aantal];
        int index = 0;
        while(sc.hasNextLine()){
            String lijn = sc.nextLine();
            Scanner sc2 = new Scanner(lijn);
            sc2.useDelimiter(";");
            String naam = sc.next();
            String tijd = sc.next();
            String start = sc.next();
            String eind = sc.next();
            int periodes = sc.nextInt();
            President donny = new President(naam,tijd,start,eind,periodes);
            presidenten[index] = donny;
        }
    }
}