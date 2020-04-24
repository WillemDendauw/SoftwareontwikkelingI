/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuurapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class DrukknopPaneel extends VBox implements EventHandler<ActionEvent> {
    Button wis;
    Button defaultKleur;
    Button kleur;
    TekenCanvas canvas;
    Stage ouder;
    
    public DrukknopPaneel(TekenCanvas canvas,Stage ouder){
        this.canvas = canvas;
        this.ouder = ouder;
        
        wis = new Button("wis de tekening");
        defaultKleur = new Button("Default kleur");
        kleur = new Button("Kies een kleur");
        
        this.getChildren().addAll(wis,defaultKleur,kleur);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(40,40,40,40));
        
        wis.setOnAction(this);
        defaultKleur.setOnAction(this);
        kleur.setOnAction(this);
    }
    
    @Override
    public void handle(ActionEvent e){
        Button btn = (Button) e.getSource();
        if(btn.equals(wis)){
            canvas.resetCanvas();
            canvas.initCanvas();
        }
        if(btn.equals(defaultKleur)){
            canvas.setKleur(canvas.getDefaultKleur());
        }
        if(btn.equals(kleur)){
            new KiesKleur(canvas,ouder).show();
        }
    }
}
