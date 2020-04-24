package krijgers;

public class Samoerai extends Krijger {

    public Samoerai (int aantalLevens, String naam) {
        super (aantalLevens,naam);
    }
    
    @Override
    public int getAanvalsKracht() {
        return r.nextInt (75*aantalLevens+75*aantalGewonnen);
    }

    @Override
    public int getVerdedigingsKracht(){
        return r.nextInt (80*aantalLevens+80*aantalGewonnen);
    }  
}
