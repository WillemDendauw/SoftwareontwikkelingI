package groepen;

import java.util.Objects;


/**
 *
 * @author tiwi
 */
public class Cilinder extends Ruimtefiguur{

    private final String kleur;
    private final double straal;
    private final double hoogte;
    
    public Cilinder(double straal, double hoogte,String kleur){
        this.straal = straal;
        this.hoogte = hoogte;
        this.kleur = kleur;
    }
    
    @Override
    public double getVolume() {
        return Math.PI * straal * straal * hoogte;
    }

    @Override
    public String getKleur() {
        return kleur;
    }
@Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.kleur);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.straal) ^ (Double.doubleToLongBits(this.straal) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.hoogte) ^ (Double.doubleToLongBits(this.hoogte) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cilinder other = (Cilinder) obj;
        if (Double.doubleToLongBits(this.straal) != Double.doubleToLongBits(other.straal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.hoogte) != Double.doubleToLongBits(other.hoogte)) {
            return false;
        }
        if (!Objects.equals(this.kleur, other.kleur)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareKey(Ruimtefiguur ander) {
        if (!(ander instanceof Cilinder)) {
            throw new ClassCastException();
        }
        Cilinder b = (Cilinder) ander;
        if (Math.abs(hoogte - b.hoogte) < 0.00001) {
            return hoogte - b.hoogte < 0 ? -1 : 1;
        }
        if (Math.abs(straal - b.straal) < 0.00001) {
            return straal - b.straal < 0 ? -1 : 1;
        }
        return 0;
    }
    
    
}
