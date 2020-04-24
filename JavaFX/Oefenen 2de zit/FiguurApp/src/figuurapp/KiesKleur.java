/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuurapp;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class KiesKleur extends Stage{
    private final TekenCanvas canvas;
    private final Stage ouder;
    
    public KiesKleur(TekenCanvas canvas, Stage ouder){
        this.canvas= canvas;
        this.ouder = ouder;
        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(ouder);
        this.setTitle("Kies Kleur");
        
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(new Label("Kies kleur"));
        
        ColorPicker cp = new ColorPicker(canvas.getTekenKleur());
        cp.setOnAction(new EventHandler(){
            @Override
            public void handle(Event e){
                canvas.setKleur(cp.getValue());
                close();
            }
        });
        hb.getChildren().add(cp);
        Scene scene = new Scene(hb);
        setScene(scene);
    }
    
}
