package studentenbeheer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tiwi
 */
public class Student extends Persoon {

    private Set<Cursus> curriculum = new HashSet<>();   // kies hier voor een andere container indien nuttig  
    private int totaalAantalStudiepunten;

    private int MAXAANTALSTUDIEPUNTEN = 10;  // eigenlijk 60; voor testdoeleinden lager!!
                                     // DIT IS VOOR ELKE STUDENT GELIJK !
    
    public Student(String voornaam, String naam, String adres, int postcode, String gemeente, String geboortedatum) {
        super(voornaam, naam, adres, postcode, gemeente, geboortedatum);
    }

    public void schrijfInVoorVak(Cursus cursus) throws foutBijInschrijving {
        // indien curriculum dit vak al bevat, of totaal aantal studiepunten
        // overschreden zou worden: niet inschrijven maar fout opwerpen
        int studiept = cursus.getAantalStudiepunten();
        if(!(totaalAantalStudiepunten + studiept > MAXAANTALSTUDIEPUNTEN || curriculum.contains(cursus))){
            curriculum.add(cursus);
            totaalAantalStudiepunten += studiept;
        }
        else {
            throw new foutBijInschrijving("max aantal studiepunten overschreden of cursus al opgenomen");
        }
        // ...
    }
    
    public int getAantalStudiepunten(){
        return totaalAantalStudiepunten;
    }

}
