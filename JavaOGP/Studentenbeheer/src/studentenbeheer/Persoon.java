package studentenbeheer;

/**
 *
 * @author tiwi
 */
public class Persoon {
    String voornaam;
    String achternaam;
    String adres;
    int postcode;
    String gemeente;
    String geboortedatum;
    
    public Persoon(String voornaam, String naam, String adres, int postcode, String gemeente, String geboortedatum){
        this.voornaam = voornaam;
        this.achternaam = naam;
        this.adres = adres;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.geboortedatum = geboortedatum;
    }
    
    public String getVoornaam(){
        return voornaam;
    }
    
    public String getAchternaam(){
        return achternaam;
    }
    
}
