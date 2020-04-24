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
public class MyLabel extends Label{
    private int rij, kolom;
    
    public MyLabel(int rij, int kolom){
        this.rij = rij;
        this.kolom = kolom;
        this.setPrefSize(30,30);
        this.setStyle("-fx-background-color: red");
    }
    
    public void setKleur(int roodWaarde, int blauwWaarde){
        this.setStyle("-fx-background-color: rgb("+roodWaarde+",0,"+blauwWaarde+")");
    }
}
