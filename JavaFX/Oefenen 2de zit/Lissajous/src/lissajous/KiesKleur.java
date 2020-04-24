/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissajous;

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
public class KiesKleur extends Stage {
    
    private final LissajousCanvas canvas;
    
    public KiesKleur(LissajousCanvas c){
        this.canvas = c;
        this.initModality(Modality.NONE);
        this.setTitle("Kies kleur assen");
        
        HBox paneel = new HBox();
        paneel.setSpacing(10);
        paneel.setAlignment(Pos.CENTER);
        paneel.getChildren().add(new Label("Kleur assen"));
        ColorPicker kleurKiezer = new ColorPicker(canvas.getKleurAs());
        kleurKiezer.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t){
                canvas.setKleurAs(kleurKiezer.getValue());
            }
        });
        paneel.getChildren().add(kleurKiezer);
        
        Scene scene = new Scene(paneel,170,35);
        setScene(scene);
    }
}
