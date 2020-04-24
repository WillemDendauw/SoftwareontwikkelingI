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
        int studiept = cursus.getAantalStudiepunten();
        if(!(totaalAantalStudiepunten + studiept > MAXAANTALSTUDIEPUNTEN || curriculum.contains(cursus))){
            curriculum.add(cursus);
            totaalAantalStudiepunten += studiept;
        }
        else {
            throw new foutBijInschrijving("max aantal studiepunten overschreden of curriculum bevat cursus al");
        }
    }
    
    public int getAantalStudiepunten(){
        return totaalAantalStudiepunten;
    }

}
