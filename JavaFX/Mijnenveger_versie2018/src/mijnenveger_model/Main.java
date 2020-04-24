/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mijnenveger_model;

import java.util.Scanner;

/**
 *
 * @author Leen Brouns
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpeelveldModel model = new SpeelveldModel(11, 11, 13);
        model.toon();

        System.out.println("Geef rij en kolom waarop je schiet (0-10), negatief is stoppen:");
        Scanner sc = new Scanner(System.in);
        int keuzeRij = sc.nextInt();
        while (keuzeRij >= 0) {
            int keuzeKolom = sc.nextInt();
            model.getVakje(keuzeRij, keuzeKolom).klikOpen();
            System.out.println("ik klik open: vakje met inhoud " + model.getVakje(keuzeRij, keuzeKolom).toString());
            model.toon();
            System.out.println("Geef rij en kolom waarop je schiet (0-10), negatief is stoppen:");
            keuzeRij = sc.nextInt();
        }

    }

}
