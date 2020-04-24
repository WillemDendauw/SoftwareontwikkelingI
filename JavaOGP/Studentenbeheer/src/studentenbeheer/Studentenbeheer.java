package studentenbeheer;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Studentenbeheer {

    private static StudentenDAO stdao;
    
    public static void main(String[] args) throws foutBijInschrijving, FileNotFoundException {

        initialiseerDAO();

        int keuze = toonMenu();
        
        while (keuze != 4) {
            if (keuze == 1) {
                docentZoeken();
            } else if (keuze == 2) {
                studentZoeken();
            } else if (keuze == 3) {
                studentInschrijven();
            }
            keuze = toonMenu();
        }
    }
    
    public static void initialiseerDAO() throws FileNotFoundException {
            stdao = new StudentenDAO("cursussen.txt");
    }
    
    public static void docentZoeken(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Geef de naam van een docent:");
        String naam = sc.nextLine();
        System.out.println(naam+" geeft de volgende cursussen:");
        Set<Cursus> cursussen = stdao.getCursussenVanDocent(naam);
        for(Cursus crs: cursussen){
            String crsnaam = crs.getNaam();
            System.out.println(crsnaam);
        }
    }
    
    public static void studentZoeken(){ //nog afwerken , is voorlopig gewoon een kopie van de docent
        Scanner sc = new Scanner(System.in);
        System.out.println("Geef de naam van een student:");
        String naam = sc.nextLine();
        System.out.println(naam+" is ingeschreven voor:");
        Set<Cursus> cursussen = stdao.getCursussenVanDocent(naam);
        for(Cursus crs: cursussen){
            String crsnaam = crs.getNaam();
            System.out.println(crsnaam);
        }
    }

    public static void studentInschrijven()throws foutBijInschrijving {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deel I: Personalia\n");
        System.out.print("Voornaam: ");
        String voornaam = sc.nextLine();
        System.out.print("Achternaam: ");
        String achternaam = sc.nextLine();
        System.out.print("Geboortedatum (dd-MM-yyyy): ");
        String geboortedatum = sc.nextLine();
        System.out.print("Adres: ");
        String adres = sc.nextLine();
        System.out.print("Postcode: ");
        int postcode = sc.nextInt();
        System.out.print("Gemeente: ");
        String gemeente = sc.nextLine();
        Student st = new Student(voornaam,achternaam,adres,postcode,gemeente,geboortedatum);
        stdao.addStudent(st);
        
        System.out.print("\n");
        System.out.println("Deel II: Curriculum\n");
        System.out.println("Geef de naam van een cursus (lege string om te stoppen): ");
        String cursus = sc.nextLine();
        Cursus crs = stdao.getCursus(cursus);
        st.schrijfInVoorVak(crs);
        while(!(cursus.equals(""))){
            System.out.println("Geef de naam van een cursus (lege string om te stoppen): ");
            cursus = sc.nextLine();
            crs = stdao.getCursus(cursus);
            st.schrijfInVoorVak(crs);
        }
        sc.close();
    }
    
    public static int toonMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Maak een keuze: \n");
        System.out.println("1. Een docent zoeken");
        System.out.println("2. Een student zoeken");
        System.out.println("3. Een student inschrijven");
        System.out.println("4. Stoppen");
        System.out.println("Keuze: ");
        int keuze = sc.nextInt();
        sc.close();
        return keuze;
    }
}
