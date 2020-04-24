package complexnumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tiwi
 */
public class ComplexNumberDAO {
    
    private List<ComplexNumber> getallen;
    private String foutmeldingen = "";
    
    public ComplexNumberDAO(String bestandsnaam) throws FileNotFoundException{
        getallen = new ArrayList<>();
        Scanner sc = new Scanner(new File(bestandsnaam));
        while(sc.hasNext()){
            try{
                getallen.add(new ComplexNumber(sc.next()));
            }
            catch(NoComplexNumberNotation ex){
                foutmeldingen += "\n"+ex.getMessage();
            }
        }
        sc.close();
    }
    
    public ComplexNumber totaleSom(){
        return ComplexNumber.sommatie(getallen.toArray(new ComplexNumber[0]));
    }
    
    public String getFoutmeldingen(){
        return foutmeldingen;
    }
    
    public int aantalGetallen(){
        return getallen.size();
    }
    
}
