package heat_2019;

import java.util.Arrays;
import javafx.animation.AnimationTimer;

/**
 *
 * @author Leen Brouns
 */
public class HeatModel extends AnimationTimer{

    private double[][] matrix;
    private int aantalRijen, aantalKolommen;  // inclusief de verborgen rijen en kolommen aan de buitenrand
    private HeatView view;
    
    // parameters: exclusief de verborgen rijen en kolommen aan de buitenrand
    public HeatModel(int aantalRijen, int aantalKolommen, HeatView view) {
        this.aantalRijen = aantalRijen + 2;
        this.aantalKolommen = aantalKolommen + 2;
               
        matrix = new double[this.aantalRijen][this.aantalKolommen];
        
        // Eenmalige uitschrijfopdracht; 
        // illustreert hoe je een matrix eenvoudig kan laten uitschrijven.
        // (Hoewel niet super leesbaar: alles op één lijn.)
        System.out.println(Arrays.deepToString(matrix));
        
        this.view = view; 
        
        this.start(); // start de animatie (of de klok)
    }

    private void stelRandwaardenIn(int links, int rechts, int boven, int onder) {
        for (int i = 0; i < aantalRijen; i++) {
            matrix[i][0] = 1.0 * links;
            matrix[i][aantalKolommen - 1] = 1.0 * rechts;
        }
        for (int i = 0; i < aantalKolommen; i++) {
            matrix[0][i] = 1.0 * boven;
            matrix[aantalRijen - 1][i] = 1.0 * onder;
        }
    }

    public void initialiseerTemperaturen(int links, int rechts, int boven, int onder) {
        stelRandwaardenIn(links, rechts, boven, onder);
        for (int i = 1; i < aantalRijen - 1; i++) {
            for (int k = 1; k < aantalKolommen - 1; k++) {
                matrix[i][k] = 0.0;
            }
        }
    }

    private void copieerRanden(double[][] origineel, double[][] kopie) {
        for (int i = 0; i < aantalRijen; i++) {
            kopie[i][0] = origineel[i][0];
            kopie[i][aantalKolommen - 1] = origineel[i][aantalKolommen - 1];
        }
        for (int i = 0; i < aantalKolommen; i++) {
            kopie[0][i] = origineel[0][i];
            kopie[aantalRijen - 1][i] = origineel[aantalRijen - 1][i];
        }
    }

    private void copieerCentraleDeel(double[][] origineel, double[][] kopie) {
        for (int i = 1; i < aantalRijen - 1; i++) {
            for (int k = 1; k < aantalKolommen - 1; k++) {
                kopie[i][k] = origineel[i][k];
            }
        }
    }

    public void veranderTemperatuur() {
        double reserveMatrix[][] = new double[aantalRijen][aantalKolommen];
        copieerRanden(matrix, reserveMatrix);

        for (int i = 1; i < aantalRijen - 1; i++) {
            for (int k = 1; k < aantalKolommen - 1; k++) {
                reserveMatrix[i][k] = 0.25 * (matrix[i + 1][k] + matrix[i - 1][k] + matrix[i][k + 1] + matrix[i][k - 1]);
            }
        }

        copieerCentraleDeel(reserveMatrix, matrix);
    }

    @Override
    public void handle(long now) {
        veranderTemperatuur();
        view.updateGui();
    }
    
    // parameters rij, kolom: ingevuld door externen, dus genummerd van 0 tot DIM,
    // maar slaan hier intern enkel op de centrale cellen.
    public double getTemperatuur(int rij, int kolom){
        return matrix[rij+1][kolom+1];
    }
}
