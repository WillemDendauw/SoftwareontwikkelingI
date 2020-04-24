package studentenbeheer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiwi
 */
public class Cursus {
    private String naam;
    private int studiejaar;
    private Docent titularis;
    private int aantalStudiepunten;
    private String cursuscode;
    private List<Student> studenten= new ArrayList<>();  // kies hier voor een andere container indien gewenst
    
    public Cursus(String naam, int studiejaar, int aantalStudiepunten, String cursuscode){
        this.naam = naam;
        this.studiejaar = studiejaar;
        this.aantalStudiepunten = aantalStudiepunten;
        this.cursuscode = cursuscode;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public void setDocent(Docent docent){
        titularis = docent;
    }
    
    public void voegStudentToe(Student student){
        studenten.add(student);
    }
    
    public int getAantalStudiepunten(){
        return aantalStudiepunten;
    }
    
    public Docent getDocent(){
        return titularis;
    }
    
}
