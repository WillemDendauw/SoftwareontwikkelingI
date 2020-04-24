/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecties;

import java.util.Set;

/**
 *
 * @author Willem Dendauw
 */
public class Collecties {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Generator generator = new Generator(10, 30);

        Set<Integer> getallen = generator.geefVerschillendeGetallen(10);
        //Schrijf deze getallen uit ter controle
        for (Integer i : getallen) {
            System.out.println(i);
        }

        Set<Integer> getallenInvolgorde = generator.geefVerschillendeGetallenInVolgorde(10);
        //Schrijf deze getallen uit ter controle
        for (Integer i : getallenInvolgorde) {
            System.out.println(i);
        }

    }
}
