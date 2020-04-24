package groepen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author tiwi
 */
public class DAOFigurenDummy {

    private final Ruimtefiguur[] keuzelijst;

    private final List<Ruimtefiguur> figuren;
    private final SortedSet<Balk> balken;
    private final Set<Cilinder> cilinders;

    public DAOFigurenDummy() {
        keuzelijst = new Ruimtefiguur[14];
        keuzelijst[0] = new Balk(2, 3, 4,"rood");
        keuzelijst[1] = new Balk(2, 3, 4,"geel");
        keuzelijst[2] = new Cilinder(3, 4,"rood");
        keuzelijst[3] = new Cilinder(30, 4,"blauw");
        keuzelijst[4] = new Balk(20, 30, 4,"blauw");
        keuzelijst[5] = new Cilinder(10, 8,"geel");
        keuzelijst[6] = new Balk(20, 3, 4,"rood");
        keuzelijst[7] = new Balk(20, 3, 4,"geel");
        keuzelijst[8] = new Cilinder(30, 5,"rood");
        keuzelijst[9] = new Cilinder(3, 5,"blauw");
        keuzelijst[10] = new Balk(20, 30, 40,"blauw");
        keuzelijst[11] = new Cilinder(8, 8,"geel");
        keuzelijst[12] = new Balk(20, 30, 40,"blauw"); // dubbel exemplaar!
        keuzelijst[13] = new Cilinder(8, 8,"geel"); // dubbel exemplaar!

        figuren = Arrays.asList(keuzelijst);

        balken = new TreeSet<>();
        balken.add((Balk) keuzelijst[0]);
        balken.add((Balk) keuzelijst[1]);
        balken.add((Balk) keuzelijst[4]);
        balken.add((Balk) keuzelijst[6]);
        balken.add((Balk) keuzelijst[7]);
        balken.add((Balk) keuzelijst[10]);
        balken.add((Balk) keuzelijst[12]);

        cilinders = new HashSet<>();
        cilinders.add((Cilinder) keuzelijst[2]);
        cilinders.add((Cilinder) keuzelijst[3]);
        cilinders.add((Cilinder) keuzelijst[5]);
        cilinders.add((Cilinder) keuzelijst[8]);
        cilinders.add((Cilinder) keuzelijst[9]);
        cilinders.add((Cilinder) keuzelijst[11]);
        cilinders.add((Cilinder) keuzelijst[13]);
    }

    public List<Ruimtefiguur> getFiguren() {
        return figuren;
    }

    public SortedSet<Balk> getBalken() {
        return balken;
    }

    public Set<Cilinder> getCilinders() {
        return new HashSet<>(cilinders);
    }

}
