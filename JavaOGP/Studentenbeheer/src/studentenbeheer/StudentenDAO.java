package studentenbeheer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author tiwi
 */
public class StudentenDAO {

    private Map<String, Student> studenten; // voornaam+" "+naam als key !!
    private Map<String, Docent> docenten;
    private Map<String, Cursus> cursussen;

    public StudentenDAO(String bestandMetCursussen) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(new File(bestandMetCursussen));
            while (sc.hasNextLine()) {
                String lijn = sc.nextLine();
                String[] stukjes = lijn.split(";");
                int studiejaar = Integer.parseInt(stukjes[0]);
                String naam = stukjes[1];
                String docent = stukjes[2];
                int studiepunten = Integer.parseInt(stukjes[3]);
                String code = stukjes[4];
                Cursus crs = new Cursus(naam, studiejaar, studiepunten,code);
                if(!cursussen.containsKey(naam)){
                    cursussen.put(naam, crs);
                }
                
                String voornaam = docent.substring(0,docent.indexOf(" "));
                String achternaam = docent.substring(docent.indexOf(" "));
                Docent dc = new Docent(voornaam,achternaam);
                if(!docenten.containsKey(docent)){
                    docenten.put(docent,dc);
                }
                docenten.put(docent,dc);
                
                
                cursussen.get(naam).setDocent(docenten.get(docent));
                docenten.get(docent).addCursus(crs);
            }
        } catch (FileNotFoundException e){

        }

    }

    public Student getStudent(String naam) {
        for (Map.Entry<String, Student> st : studenten.entrySet()) {
            if (st.getKey().equals(naam)) {
                return st.getValue();
            }
        }
        return null;
    }

    public Docent getDocent(String naam) {
        for (Map.Entry<String, Docent> dc : docenten.entrySet()) {
            if (dc.getKey().equals(naam)) {
                return dc.getValue();
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        String naam = student.getVoornaam() + " " + student.getAchternaam();
        studenten.put(naam, student);
    }
    
    public Cursus getCursus(String naam){
        for (Map.Entry<String, Cursus> crs : cursussen.entrySet()) {
            if (crs.getKey().equals(naam)) {
                return crs.getValue();
            }
        }
        return null;
    }
    
    public Set<Cursus> getCursussenVanDocent(String naam){
        Docent dc = getDocent(naam);
        Set<Cursus> set = dc.getCursussen();
        return set;
    }
    
    public String getCursussenToString(){
        String res= "";
        for(Map.Entry<String, Cursus> crs: cursussen.entrySet()){
            res += crs.getKey()+" ";
        }
        return res;
    }

}
