package krijgers;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author tiwi
 */
public abstract class KrijgerDAO {
    
    public abstract Krijger[] getKrijgers();
    
    public SortedSet<Krijger> getSpelersAlfabetisch() {
        return new TreeSet<>(Arrays.asList(getKrijgers()));
    }
    public SortedSet<Krijger> getSpelersOpPunten() {
        SortedSet krijgers = new TreeSet(new KrijgerVergelijker());
        krijgers.addAll(Arrays.asList(getKrijgers()));
        return krijgers;
    }    
}
