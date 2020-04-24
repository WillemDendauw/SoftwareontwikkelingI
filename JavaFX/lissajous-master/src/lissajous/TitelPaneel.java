/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lissajous;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author tiwi
 */
public class TitelPaneel extends StackPane {
    public TitelPaneel(String titel) {
        Label titelLabel = new Label();
        titelLabel.setText(titel);
        titelLabel.getStyleClass().add("bordered-titled-title");
        StackPane.setAlignment(titelLabel, Pos.TOP_LEFT);        
        getChildren().add(titelLabel);

        getStyleClass().add("bordered-titled-border");

        
    }
    
    public void setContent(Node paneel) {
        paneel.getStyleClass().add("bordered-titled-content");
        getChildren().add(paneel);
    }
}
