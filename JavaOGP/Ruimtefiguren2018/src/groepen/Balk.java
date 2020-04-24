package groepen;

import java.util.Objects;


/**
 *
 * @author tiwi
 */
public class Balk extends Ruimtefiguur{
    private final String kleur;
    private final double lengte;
    private final double breedte;
    private final double hoogte;
    
    public Balk(double l, double b, double h, String kleur){
        lengte = l;
        breedte = b;
        hoogte = h;
        this.kleur = kleur;
    }
    
    @Override
    public double getVolume() {
        return lengte * breedte * hoogte;
    }

    @Override
    public String getKleur() {
        return kleur;
    }
    
    @Override 
    public int hashCode(){
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.kleur);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.lengte) ^ (Double.doubleToLongBits(this.lengte) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.breedte) ^ (Double.doubleToLongBits(this.breedte) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.hoogte) ^ (Double.doubleToLongBits(this.hoogte) >>> 32));
        return hash;
    }
    
    @Override 
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Balk other = (Balk) obj;
        if (Double.doubleToLongBits(this.lengte) != Double.doubleToLongBits(other.lengte)) {
            return false;
        }
        if (Double.doubleToLongBits(this.breedte) != Double.doubleToLongBits(other.breedte)) {
            return false;
        }
        if (Double.doubleToLongBits(this.hoogte) != Double.doubleToLongBits(other.hoogte)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareKey(Ruimtefiguur ander){
        if (!(ander instanceof Balk)) {
            throw new ClassCastException();
        }
        Balk b = (Balk) ander;
        if(Math.abs(lengte - b.lengte) < 0.00001) {
            return lengte - b.lengte < 0 ? -1 : 1;
        }
        if (Math.abs(breedte - b.breedte) < 0.00001) {
            return breedte - b.breedte < 0 ? -1 : 1;
        }
        if (Math.abs(hoogte - b.hoogte) < 0.00001) {
            return hoogte - b.hoogte < 0 ? -1 : 1;
        }
        return 0;
    }
}
