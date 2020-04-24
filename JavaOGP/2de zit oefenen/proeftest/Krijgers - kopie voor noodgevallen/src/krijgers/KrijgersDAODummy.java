/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krijgers;

import java.util.Random;

/**
 *
 * @author Willem Dendauw
 */
public class KrijgersDAODummy extends KrijgersDAO {
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
                krijgers[i] = new Ninja(naam,levens[i]); 
            } else {
                krijgers[i] = new Samourai(naam,levens[i]);
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
