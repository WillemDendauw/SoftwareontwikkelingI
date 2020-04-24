package krijgers;

import java.util.Comparator;

/**
 *
 * @author tiwi
 */
public class KrijgerVergelijker implements Comparator<Krijger> {

    @Override
    public int compare(Krijger t, Krijger t1) {
        if (t.isLevend() && t1.isLevend()) { 
            return vergelijk(t, t1);
        } else if (t.isLevend()) {
            return -1;
        } else if (t1.isLevend()) {
            return 1;
        } else {
            return vergelijk(t, t1);
        }
    }

    private int vergelijk(Krijger t, Krijger t1) { 
        if (t.getAantalGewonnen() != t1.getAantalGewonnen()) {
            return t1.getAantalGewonnen() - t.getAantalGewonnen();
        } else if (t.getAantalLevens() != t1.getAantalLevens()) {
            return t1.getAantalLevens() - t.getAantalLevens();
        } else {
            return t.compareTo(t1);
        }
    }

}
