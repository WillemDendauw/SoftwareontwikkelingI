/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mijnenveger_model;

/**
 *
 * @author Willem Dendauw
 */
public class MijnenveldVakje {
    private boolean bom;
    private int aantalBuren;
    private Status status;
    private boolean ontploft;
    private boolean internVakje;
    
    private int rij;
    private int kolom;
    private SpeelveldModel speelveld;
    
    public MijnenveldVakje(int rij, int kolom, SpeelveldModel speelveld, boolean intern){
        this.rij = rij;
        this.kolom = kolom;
        this.speelveld = speelveld;
        this.internVakje = intern;
        
        bom = false;
        aantalBuren = 0;
        status = Status.GESLOTEN;
        ontploft = false;
    }
    
    protected void verhoogAantalBuren(){
        aantalBuren++;
    }
    
    protected boolean isInternVakje(){
        return internVakje;
    }
    
    public void klikOpen(){
        System.out.println("Ik klik open: "+rij+" "+kolom);
        status = Status.OPEN;
        if(bom){
            ontploft = true;
            speelveld.openAlles();
        }
        else if(aantalBuren == 0){
            int[] deltaX = {-1,0,0,1};
            int[] deltaY = {0,-1,1,0};
            for(int i=0;i<4;i++){
                try{
                    MijnenveldVakje buur = speelveld.getVakjeInterneNummering(rij+deltaX[i],kolom+deltaY[i]);
                    if (buur.internVakje && buur.getStatus() != Status.OPEN){
                        buur.klikOpen();
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    
                }
            }
        }
    }
    
    public void open(){
        status = Status.OPEN;
    }
    
    public void toggleVlag() throws Exception {
        if (null != status){
            switch(status){
                case GEMERKT:
                    status = Status.GESLOTEN;
                    if(bom){
                        speelveld.bomMinderGemerkt();
                    }
                    else {
                        speelveld.bomMeerGemerkt();
                    }
                    break;
                case GESLOTEN:
                    status = Status.GEMERKT;
                    if(bom){
                        speelveld.bomMeerGemerkt();
                    }
                    else {
                        speelveld.bomMeerVerkeerdelijkGemerkt();
                    }
                    break;
                case OPEN:
                    throw new Exception("Vlag hier plaatsen heeft geen nut!!");
                default:
                    break;
            }
        }
    }
    
    protected boolean plaatsBom(){
        if(!bom){
            bom  = true;
            return true;
        }
        return false;
    }
    
    public boolean isBom(){
        return bom;
    }
    
    public int getAantalBuren(){
        return aantalBuren;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public boolean isOntploft(){
        return ontploft;
    }
    
    public void toonInhoud(){
        String x= "";
        if (bom){
            x = "B";
            if(ontploft){
                x= "*";
            }
        }
        else {
            x = "" + aantalBuren;
        }
        System.out.println(" "+x);
    }
    
    public void toonSpelersview(){
        String x= "";
        if(status == Status.GESLOTEN){
            x = ".";
        } else if (status == Status.GEMERKT){
            x = "F";
        } else if (status == Status.OPEN){
            if(bom){
                x = "B";
                if(ontploft) {
                    x = "*";
                }
            } else {
                x = ""+aantalBuren;
            }
        }
        System.out.println(" "+ x);
    }
    
    @Override
    public String toString(){
        String str = "" + aantalBuren;
        if(bom) {
            str = ("'bom'");
        }
        return str;
    }
}