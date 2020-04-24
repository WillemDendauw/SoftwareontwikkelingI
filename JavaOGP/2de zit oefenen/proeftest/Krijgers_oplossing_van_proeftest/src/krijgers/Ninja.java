package krijgers;

public class Ninja extends Krijger { 

    public Ninja (int aantalLevens, String naam) {   
       super (aantalLevens,naam);        
    }
    
    @Override
    public int getAanvalsKracht() {
        return r.nextInt (80*aantalLevens+2*aantalGewonnen);
    }
    
    @Override
    public int getVerdedigingsKracht() {
        return r.nextInt (100*aantalLevens);
    }    
     
}
