package groepen;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author tiwi
 */
public abstract class Ruimtefiguur implements Comparable{

    public abstract double getVolume();

    public abstract String getKleur();

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.0");
        return this.getClass().getName().substring(8) + " [" + getKleur() + " " + formatter.format(getVolume()) + "]";
    }
    
    @Override
    public int compareTo(Object o){
        if (o == null){
            throw new NullPointerException();
        }
        if(!(o instanceof Ruimtefiguur)){
            throw new ClassCastException();
        }
        Ruimtefiguur figuur = (Ruimtefiguur) o;
         double volumeA = getVolume();
         double volumeB = figuur.getVolume();
         if(Math.abs(volumeA - volumeB) > 0.00001){
             return (int) ((volumeA - volumeB) * 10000);
         }
         else if (!getKleur().equals(figuur.getKleur())){
             return getKleur().compareTo(figuur.getKleur());
         }
         else if (!this.getClass().getName().equals(figuur.getClass().getName())){
             return getClass().getName().compareTo(figuur.getClass().getName());
         }
         else {
             return this.compareKey(figuur);
         }
    }
    
    public abstract int compareKey(Ruimtefiguur ander);

}
