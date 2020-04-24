package mijnenveger_model;

import java.util.Random;

/**
 *
 * @author Leen Brouns
 */
public class SpeelveldModel {

    private int aantalBommen;
    private int hoogte;
    private int breedte;
    private MijnenveldVakje[][] vakjes;
    private int aantalGemerkteBommen;
    private int aantalVerkeerdelijkGemerkteBommen;
    
    public SpeelveldModel(int hoogte, int breedte, int aantalBommen) {
        this.aantalBommen = aantalBommen;
        this.hoogte = hoogte;
        this.breedte = breedte;
        vakjes = new MijnenveldVakje[hoogte+2][breedte+2];
        this.aantalGemerkteBommen = 0;
        this.aantalVerkeerdelijkGemerkteBommen = 0;
        
        for(int rij = 1; rij < hoogte+1; rij++){
            for(int kolom = 1; kolom < breedte+1; kolom++){
                vakjes[rij][kolom] = new MijnenveldVakje(rij,kolom,this,true); // interne vakjes
            }
        }
        for(int rij = 0; rij < hoogte+2; rij++){
            vakjes[rij][0] = new MijnenveldVakje(rij,0,this,false);
            vakjes[rij][breedte+1] = new MijnenveldVakje(rij,breedte+1,this,false);
        }
        for(int kolom = 0; kolom < breedte+2; kolom++){
            vakjes[0][kolom] = new MijnenveldVakje(0,kolom,this,false);
            vakjes[hoogte+1][kolom] = new MijnenveldVakje(hoogte+1,kolom,this,false);
        }
        
        plaatsBommen(aantalBommen);
    }
    
    public void openAlles(){
        for(int rij = 1; rij < hoogte+1; rij++){
            for(int kolom = 1; kolom < breedte+1; kolom++){
                vakjes[rij][kolom].open();
            }
        }
    }    
    
    private void plaatsBommen(int aantal){
        int[] deltaX = {-1,-1,-1,0,0,1,1,1};
        int[] deltaY = {-1,0,1,-1,1,-1,0,1};        
        Random random = new Random();
        int a = 0;
        while(a < aantal){
            int rij = 1 + random.nextInt(hoogte);
            int kolom = 1 + random.nextInt(breedte);
            if(vakjes[rij][kolom].plaatsBom()){
                a++;
                for(int i=0; i<8; i++){
                    vakjes[rij+deltaX[i]][kolom+deltaY[i]].verhoogAantalBuren();
                }
            }
        }
    }
    
    // publieke gebruiker heeft er geen zaken mee dat er 'n extra rand is!
    public MijnenveldVakje getVakje(int rij, int kolom){
        return vakjes[rij+1][kolom+1];
    }
    
    public MijnenveldVakje getVakjeInterneNummering(int rij, int kolom){
        return vakjes[rij][kolom];
    }
    
    public void toon(){
        System.out.println("\n\n");
        for(int rij = 0; rij < hoogte; rij++){
            for(int kolom = 0; kolom < breedte; kolom++){
                vakjes[rij+1][kolom+1].toonInhoud();
            }
            System.out.print("   ");
            for(int kolom = 0; kolom < breedte; kolom++){
                vakjes[rij+1][kolom+1].toonSpelersview();
            }
            System.out.println("");
            
        }
        
    }
    
    public boolean controleerSucces(){
        if(aantalGemerkteBommen == aantalBommen && aantalVerkeerdelijkGemerkteBommen == 0){
            openAlles();
            return true;
        }
        return false;
    }
    
    public void bomMinderGemerkt(){
        this.aantalGemerkteBommen--;
    }
    
    public void bomMeerGemerkt(){
        this.aantalGemerkteBommen++;
        controleerSucces();
    }
    
    public void bomMinderVerkeerdelijkGemerkt(){
        this.aantalVerkeerdelijkGemerkteBommen--;
        controleerSucces();
    }
    
    public void bomMeerVerkeerdelijkGemerkt(){
        this.aantalVerkeerdelijkGemerkteBommen++;
    }
    
}
