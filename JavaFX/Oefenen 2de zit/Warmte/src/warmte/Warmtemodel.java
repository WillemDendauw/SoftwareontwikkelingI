/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmte;

import java.util.Arrays;
import javafx.animation.AnimationTimer;

/**
 *
 * @author Willem Dendauw
 */
public class Warmtemodel extends AnimationTimer {

    private double[][] matrix;
    private Warmte w;
    private int aantalRijen, aantalKolommen;

    public Warmtemodel(int aantalRijen, int aantalKolommen, Warmte w) {
        this.aantalRijen = aantalRijen;
        this.aantalKolommen = aantalKolommen;
        matrix = new double[this.aantalRijen][this.aantalKolommen];
        System.out.println(Arrays.deepToString(matrix));
        this.w = w;
        this.start();

    }

    public void stelRandIn(int links, int rechts, int boven, int onder) {
        for (int i = 0; i < aantalRijen; i++) {
            matrix[i][0] = 1.0 * links;
            matrix[i][aantalKolommen - 1] = 1.0 * rechts;
        }
        for (int j = 0; j < aantalKolommen; j++) {
            matrix[0][j] = 1.0 * boven;
            matrix[aantalRijen - 1][j] = 1.0 * onder;
        }
    }

    public void initTemp(int links, int rechts, int boven, int onder){
        stelRandIn(links,rechts,boven,onder);
        for(int i=0;i<aantalRijen;i++){
            for(int j=0;j<aantalKolommen;j++){
                matrix[i][j]=0.0;
            }
        }
    }
    
    private void kopieerRanden(double[][] origineel, double[][] kopie){
        for (int i = 0; i < aantalRijen; i++) {
            kopie[i][0] = origineel[i][0];
            kopie[i][aantalKolommen - 1] = origineel[i][aantalKolommen - 1];
        }
        for (int i = 0; i < aantalKolommen; i++) {
            kopie[0][i] = origineel[0][i];
            kopie[aantalRijen - 1][i] = origineel[aantalRijen - 1][i];
        }
    }
    
    private void kopieerCenter(double[][] origineel, double[][] kopie){
        for (int i = 1; i < aantalRijen - 1; i++) {
            for (int k = 1; k < aantalKolommen - 1; k++) {
                kopie[i][k] = origineel[i][k];
            }
        }
    }
    
    private void veranderTemp(){
        double reserveMatrix[][] = new double[aantalRijen][aantalKolommen];
        kopieerRanden(matrix, reserveMatrix);
        
        for(int i=1; i<aantalRijen - 1; i++){
            for (int k = 1; k<aantalKolommen - 1; k++){
                reserveMatrix[i][k] = 0.25*(matrix[i+1][k] + matrix[i-1][k] + matrix[i][k-1] + matrix[i][k+1]);
            }
        }
        
        kopieerCenter(reserveMatrix, matrix);
    }
    
    @Override
    public void handle(long now){
        veranderTemp();
        w.updateGui();
    }
    
    public double getTemp(int rij, int kolom){
        return matrix[rij+1][kolom+1];
    }
    
}
