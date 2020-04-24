package krijgers;

import java.util.Random;

/**
 *
 * @author tiwi
 */
public abstract class Krijger implements Comparable{ 
    protected int aantalLevens;
    private final String naam;
    protected int aantalGewonnen;
    protected static final Random r = new Random ();

    public Krijger(int aantalLevens, String naam) { 
        this.aantalLevens = aantalLevens;
        this.naam = naam;
        aantalGewonnen = 0;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalLevens() {
        return aantalLevens;
    }

    public int getAantalGewonnen() {
        return aantalGewonnen;
    }

    public boolean isLevend() {
        return aantalLevens > 0;
    }
       
    public void win () {
        aantalGewonnen ++;
    }
    public void verlies(){
        aantalLevens--;
    }
    
    abstract public int getAanvalsKracht();

    abstract public int getVerdedigingsKracht();

    @Override 
    public int compareTo(Object t) {
        return compareTo((Krijger) t);        
    }
    
    public int compareTo(Krijger k) { 
        if (naam.compareTo(k.getNaam()) == 0) {
            if (k.isLevend() && isLevend())
                return 0;
            else if (k.isLevend()) 
                return 1;
            else if (isLevend())
                return -1;
            else return 0;
        } else {
            return naam.compareTo(k.getNaam());
        }
    }    
}
