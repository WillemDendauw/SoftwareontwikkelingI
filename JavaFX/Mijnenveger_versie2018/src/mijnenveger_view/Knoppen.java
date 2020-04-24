/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mijnenveger_view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Paint;
import mijnenveger_model.MijnenveldVakje;
import mijnenveger_model.Status;
/**
 *
 * @author Willem Dendauw
 */
public class Knoppen extends Button{
    
    private int kolom;
    private int rij;
    private MijnenveldVakje vakje;
    
    public Knoppen(int kolom, int rij,MijnenveldVakje vakje){
        this.kolom = kolom;
        this.rij = rij;
        this.vakje = vakje;
        toonPrent();
    }
    
    public void toonPrent(){
        String prentnaam = "prenten/Mines";
        if (vakje.getStatus() == Status.GESLOTEN){
            prentnaam += "z";
        }
        if(vakje.getStatus() == Status.GEMERKT){
            prentnaam += "f";
        }
        if(vakje.getStatus() == Status.OPEN){
            if(vakje.isOntploft()){
                prentnaam += "n";
            }
            else if (vakje.isBom()){
                prentnaam += "b";
            }
            else {
                prentnaam += "" +vakje.getAantalBuren();
            }
        }
        prentnaam += ".gif";
        
        this.setWidth(30.0);
        this.setHeight(30.0);
        this.setPadding(new Insets(0,0,0,0));
        this.setBorder(new Border(new BorderStroke(Paint.valueOf("Black"),BorderStrokeStyle.SOLID,null,new BorderWidths(2,2,2,2))));
        
        
        ImageView image = new ImageView(new Image(prentnaam));
        image.setFitWidth(this.getWidth());
        image.setFitHeight(this.getHeight());
        setGraphic(image);
    }
    
    public void klikOpen(){
        vakje.klikOpen();
    }
    
}
