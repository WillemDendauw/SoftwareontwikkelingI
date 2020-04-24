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
    
    
    public ComplexNumberDAO(String naam) throws FileNotFoundException {
        getallen = new ArrayList<>();
        Scanner sc = new Scanner(new File(naam));
        while(sc.hasNextLine()){
            String next = sc.next();
            try{
                getallen.add(new ComplexNumber(next));
            } catch (NoComplexNumberNotation n){
                foutmeldingen += "is geen complex getal: " +next+ "\n";
            }
        }
        System.out.println(foutmeldingen);
    }
    
    public ComplexNumber totaleSom(){
        ComplexNumber[] arr = new ComplexNumber[getallen.size()];
        arr = getallen.toArray(arr);
        ComplexNumber totaal = ComplexNumber.sommatie(arr);
        return totaal;
    }
    
    public String getFoutmeldingen(){
        return foutmeldingen;
    }
    
    public int getAantalGetallen(){
        return getallen.size();
    }
}
