/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vervoer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marleen
 */
public class Voertuigen {

    private ArrayList<IVoertuig> voertuigen = new ArrayList<>();
    
    //toevoegen voor deel 2

    public Voertuigen(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));

        while (sc.hasNext()) {  // gebruik GEEN hasNextLine(); dat geeft (soms) fouten bij
            // het inlezen van de laatste lijnen van het bestand
            String regel = sc.nextLine();
            try (Scanner sc2 = new Scanner(regel)) {
                sc2.useDelimiter(";");
                String type = sc2.next();
                if (type.equals("TREIN")) {
                    int aantalPassagiers = sc2.nextInt();
                    int snelheid = sc2.nextInt();
                    String internationaal = sc2.next();
                    Trein tr = new Trein(aantalPassagiers, snelheid, internationaal);
                    voertuigen.add(tr);
                            //pas de teller aan - de volgende trein komt in het volgende vakje
                }

                //toevoegen voor tweede deel                
                if (type.equals("TR")) {
                    int gewichtLeeg = sc2.nextInt();
                    int gewichtLading = sc2.nextInt();
                    Truck tr = new Truck(gewichtLeeg, gewichtLading);
                    voertuigen.add(tr);
                           //pas de teller aan - staat klaar voor de volgende trein
                }
                if (type.equals("MT")) {
                    int gewichtLeeg = sc2.nextInt();
                    int gewichtLading = sc2.nextInt();
                    int maxLading = sc2.nextInt();
                    Truck tr = new MaxGewichtTruck(gewichtLeeg, gewichtLading, maxLading);
                    voertuigen.add(tr);
                     //pas de teller aan - staat klaar voor de volgende trein
                }
                sc2.close();
            }
        }
        sc.close(); //kan ook met try-clausule - zonder close
    }

    //nieuwe methodes
    public Truck kiesTruck() {
        IVoertuig vt = kiesVoertuig();
        while(!(vt instanceof Truck)){
            vt = kiesVoertuig();
        }
        return (Truck) vt;
    }

    public int aantalMaxGewichtTruck() {
        int tel = 0;
        for (IVoertuig vt : voertuigen) {
            if (vt instanceof MaxGewichtTruck) {
                tel++;
            }
        }
        return tel;
    }

    public int aantalOverladen() {
        int tel = 0;
        for (IVoertuig vt : voertuigen) {
            {
                if (vt instanceof MaxGewichtTruck) {
                    MaxGewichtTruck zwaretruck = (MaxGewichtTruck) vt;
                    if (zwaretruck.isOverladen()) {
                        tel++;
                    }
                }
            }
        }
        return tel;
    }

    public int maxSnelheidTreinen() {  //geen parameter, geen fout doorwerpen
        int max = voertuigen.get(0).getMaxSnelheid();
        for (IVoertuig vt : voertuigen) {
            if (vt instanceof Trein) {
                if (vt.getMaxSnelheid() > max) {
                    max = vt.getMaxSnelheid();
                }
            }  
        }
        return max;
    }
        // Merk op: je kan hier geen for-each lus gebruiken omdat er op het einde van de array
        // allicht nog veel niet-geinitialiseerde elementen staan.
        // Als je daar al op bedacht zou zijn (en dus zou testen op !=null),
        // dan heb je toch nog teveel werk verricht!

    public Trein geefSnelsteTrein() {
        Trein max = null;
        int maxsnel = 0;
        for(IVoertuig vt: voertuigen){
            if(vt instanceof Trein){
                if(vt.getMaxSnelheid()>maxsnel){
                    max = (Trein)vt;
                    maxsnel = vt.getMaxSnelheid();
                }
            }
        }
        return max;
    }
    // Merk op: als je de methode 'geefSnelsteTrein' kent, kan je de methode
    // 'maxSnelheidTreinen' schrijven door de methode 'geefSnelsteTrein' op te roepen.
    // Probeer dat.
    
    public IVoertuig kiesVoertuig(){
        Random rd = new Random();
        int kies = rd.nextInt(voertuigen.size());
        IVoertuig gekozen = voertuigen.get(kies);
        return gekozen;
    }
}
