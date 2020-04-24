
import java.util.ArrayList;
import java.util.List;
import sorteren2017.Boek;

/**
 *
 * @author tiwi
 */
public class BoekenDAODummy {

    private final Boek[] boeken;

    public BoekenDAODummy() {
        boeken = new Boek[5];
        boeken[0] = new Boek("The book of Joy", "Dalai Lama");
        boeken[1] = new Boek("De dag dat ze ons kwamen halen", "Janine di Giovanni");
        boeken[2] = new Boek("De kunst van het geluk", "Dalai Lama");
        boeken[3] = new Boek("Jihad van liefde", "Mohamed Bachiri");
        boeken[4] = new Boek("De blikken trommel", "Gunter Grass");
    }

    public List<Boek> getKopieVanBoeken() {
        List<Boek> kopie = new ArrayList();
        for (int i = 0; i < boeken.length; i++) {
            kopie.add(new Boek(boeken[i]));
        }
        return kopie;
    }

    public List<Boek> getKopieVanBoekenGesorteerdOpTitel() {

        List<Boek> opTitel = new ArrayList();

        opTitel.add(new Boek(boeken[4]));
        opTitel.add(new Boek(boeken[1]));
        opTitel.add(new Boek(boeken[2]));
        opTitel.add(new Boek(boeken[3]));
        opTitel.add(new Boek(boeken[0]));

        return opTitel;
    }

    public List<Boek> getKopieVanBoekenGesorteerdOpAuteur() {

        List<Boek> opAuteur = new ArrayList();

        opAuteur.add(new Boek(boeken[2]));
        opAuteur.add(new Boek(boeken[0]));
        opAuteur.add(new Boek(boeken[4]));
        opAuteur.add(new Boek(boeken[1]));
        opAuteur.add(new Boek(boeken[3]));

        return opAuteur;
    }

}
