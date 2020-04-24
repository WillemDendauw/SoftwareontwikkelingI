package krijgers;

import java.util.Random;

/**
 *
 * @author tiwi
 */
public class KrijgersDAODummy extends KrijgerDAO {

    Krijger[] krijgers;

    public KrijgersDAODummy() {
        final String[] namen
                = {"Donatello", "Michelangelo", "Rafaelo", "Schreder",
                    "Bruce Lee", "Arnold", "Bruce Lee"};
        final int[] levens = {3, 4, 3, 3, 3, 3, 3, 3, 3, 3};
        krijgers = new Krijger[namen.length]; 
        Random r = new Random();
        for (int i = 0; i < namen.length; i++) { 
            String naam = namen[i];
            if (r.nextInt(2) == 0) {
                krijgers[i] = new Ninja(levens[i], naam); 
            } else {
                krijgers[i] = new Samoerai(levens[i], naam);
            }
        }
        for (int i = 0; i < 3; i++) {
            krijgers[1].win();
            krijgers[3].win();
            krijgers[4].win();
            krijgers[5].win();
            krijgers[6].win();
        }
        for (int i = 0; i < 2; i++) {
            krijgers[0].win();
            krijgers[2].win();
        }
        krijgers[0].verlies();
        krijgers[2].verlies();
        for (int i = 0; i < 3; i++) {
            krijgers[3].verlies();
        }
    }

    @Override
    public Krijger[] getKrijgers() {
        return krijgers;
    }
}
