package groepen;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author tiwi
 */
public class Main {

    public static void main(String[] args) {

        DAOFigurenDummy dummy = new DAOFigurenDummy();

        System.out.println("Dit zijn alle figuren:\n");
        for (Ruimtefiguur f : dummy.getFiguren()) {
            System.out.println("" + f);
        }

        String[] kleuren = {"rood", "geel", "blauw"};
        for (String kleur : kleuren) {
            System.out.println("\nVOOR KLEUR " + kleur + ":\n");
            System.out.println("Grootste van figuren   is " + max(dummy.getFiguren(), kleur));
            System.out.println("Grootste van balken    is " + max(dummy.getBalken(), kleur));
            System.out.println("Grootste van cilinders is " + max(dummy.getCilinders(), kleur));
        }
    }

    public static Ruimtefiguur max(Collection<? extends Ruimtefiguur> collectie, String kleur) {
        Ruimtefiguur grootste = null;
        double volume = 0;
        for (Ruimtefiguur fig : collectie) {
            if (fig.getKleur().equals(kleur) && fig.getVolume() > volume) {
                volume = fig.getVolume();
                grootste = fig;
            }
        }
        return grootste;
    }

    public static Ruimtefiguur maxBis(Collection<? extends Ruimtefiguur> collectie, String kleur) {
        if (collectie.isEmpty()) {
            return null;
        }
        Iterator it = collectie.iterator();
        Ruimtefiguur grootste = (Ruimtefiguur) it.next();
        while (it.hasNext() && !grootste.getKleur().equals(kleur)) {
            grootste = (Ruimtefiguur) it.next();
        }
        if(!grootste.getKleur().equals(kleur)){
            return null;
        }
        while(it.hasNext()) {
            Ruimtefiguur volgende = (Ruimtefiguur) it.next();
            if(volgende.getKleur().equals(kleur) && volgende.compareTo(grootste) > 0) {
                grootste = volgende;
            }
        }
        return grootste;
    }
}
