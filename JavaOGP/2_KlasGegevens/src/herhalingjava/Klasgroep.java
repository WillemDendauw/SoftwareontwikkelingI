/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herhalingjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marleen
 */
public class Klasgroep {

    private Persoon[] personen;

    //Constructor is volledig herwerkt
    public Klasgroep(String bestandsnaam) throws FileNotFoundException {

        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            int aantal = sc.nextInt(); //eerste getal is aantal studenten
            sc.nextLine();
            personen = new Student[aantal];        // verwerk de rest van de eerste regel 
            Student.initTesten(sc.nextLine(), sc.nextLine());  //verwerk de twee volgende lijnen
            int nr = 0;
            while (sc.hasNextLine()) {
                String lijn = sc.nextLine();
                Scanner sc2 = new Scanner(lijn); //een volledige lijn gebruiken voor de tweede Scanner-variabele
                sc2.useDelimiter(";");                    //delimiter instellen
                sc2.useLocale(Locale.FRENCH);

                String naam = sc2.next();                 //de drie deeltjes ophalen
                int leeftijd = sc2.nextInt();
                String richting = sc2.next();
                if (richting.equals("")) {
                    richting = "???";
                }
                //student maken              

                String rest = sc2.nextLine().substring(1);
                if (rest.equals("")) {
                    personen[nr] = new Persoon(naam, leeftijd);
                } else {
                    personen[nr] = new Student(naam, leeftijd, richting);
                    if (personen[nr] instanceof Student) {
                        Student st = (Student) personen[nr];
                        st.addPunten(rest);
                    }
                }
                sc2.close();

                nr++;
            }
        }
    }

    public int aantalGeslaagdenVoor(String test, String richting) {
        int tel = 0;
        for (Persoon sp : personen) //alle elementen in de array zijn ingevuld  
        {
            if (sp instanceof Student) {
                Student st = (Student) sp;
                if (st.getRichting().equals(richting) && st.isGeslaagdVoor(test)) {
                    tel++;
                }
            }
        }
        return tel;
    }

    public Student geefBesteStudent() {
        Student beste = (Student) personen[0];
        int score = beste.geefTotaal();
        for (Persoon sp : personen) {
            if (sp instanceof Student) {
                Student st = (Student) sp;

                int s = st.geefTotaal();
                if (s > score) {
                    score = s;
                    beste = st;
                }
            }
        }
        return beste;
    }

    public int aantalDocenten() {
        int aantal = 0;
        for (Persoon ps : personen) {
            if (!(ps instanceof Student)) {
                aantal++;
            }
        }
        return aantal;
    }
    
    public Persoon kiesPersoon(){
        Random rd= new Random();
        int nr = rd.nextInt(personen.length);
        Persoon p = personen[nr];
        return p;
    }
    
    public Persoon kiesDocent(){
        Persoon p = kiesPersoon();
        while(p instanceof Student){
            p = kiesPersoon();
        }
        return p;
    }
}
