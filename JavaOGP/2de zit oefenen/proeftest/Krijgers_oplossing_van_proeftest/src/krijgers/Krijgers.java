package krijgers;

import java.util.Arrays;

/**
 *
 * @author tiwi
 */
public class Krijgers {

    public static void main(String[] args) {
        KrijgerDAO dao = new KrijgersDAODummy();
        print("Krijgers zoals ingevoerd", Arrays.asList(dao.getKrijgers()));
        print("Krijgers alfabetisch",dao.getSpelersAlfabetisch());
        print("Krijgers op punten",dao.getSpelersOpPunten());
    }

    private static void print(String bericht, Iterable<Krijger> krijgers) {
        System.out.println(bericht);
        for (Krijger krijger : krijgers) {
            printKrijger(krijger);
        }
    }

    private static void printKrijger(Krijger krijger) {
        System.out.print(krijger.getNaam());
        System.out.print(" aantal gewonnen: ");
        System.out.print(krijger.getAantalGewonnen());
        System.out.print(" aantal levens: ");
        System.out.print(krijger.getAantalLevens());
        System.out.print(krijger.isLevend()?" levend":" dood");
        System.out.println();
    }
}
