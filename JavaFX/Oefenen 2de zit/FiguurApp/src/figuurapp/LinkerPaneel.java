/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuurapp;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author Willem Dendauw
 */
public class LinkerPaneel extends VBox {
    private DrukknopPaneel dp;
    private ComboBox<String> cb;
    private TekenCanvas canvas;
    
    public LinkerPaneel(DrukknopPaneel dp, TekenCanvas canvas){
        this.canvas =canvas;
        this.dp = dp;
        cb = new ComboBox<String>();
        cb.getItems().addAll("Rechthoek","Cirkel","Vierkant");
        
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(dp,cb);
        
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                canvas.tekenFiguur(cb.getValue(),event.getX(),event.getY());
            }
        });
    }
    
    public String getCombo(){
        return cb.getValue();
    }
}
