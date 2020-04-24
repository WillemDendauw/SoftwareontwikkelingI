/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmte;

import javafx.scene.control.Label;

/**
 *
 * @author Willem Dendauw
 */
public class Warmtemodel {
    
    private double[][][] cells;
    private Warmte w;
    
    public Warmtemodel(Warmte w){
        this.w = w;
    }
    
    public void initCells(){
        Label[][] label = w.getLabels();
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10;j++){
                label[i][j].setStyle("-fx-background-color:BLUE");
                cells[i][j][0] = 0.0;
                cells[i][j][1] = 0.0;
            }
        }
        for(int i = 1; i<12 ; i++){
            cells[0][i][0] = w.getLinks();
            cells[12][i][0] = w.getRechts();
        }
        for(int i= 1; i<12 ; i++){
            cells[i][0][0] = w.getBoven();
            cells[i][12][0] = w.getOnder();
        }
        
    }
    
    public void updateCells(){
        
    }
}
