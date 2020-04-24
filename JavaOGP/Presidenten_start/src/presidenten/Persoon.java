package presidenten;


/**
 *
 * @author tiwi
 */
public class Persoon {
    
    private String naam;
    private String periode;
    
    // vul aan waar nodig
    public Persoon(){
        
    }
    
    public Persoon(String naam, String tijd){
        this.naam = naam;
        this.periode = tijd;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public String toString(){
        String res = "Volksfiguur: "+naam+" "+periode;
        return res;
    }
}
