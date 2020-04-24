/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissajous;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 *
 * @author Willem Dendauw
 */
public class RadioButtonPaneel extends TitelPaneel{
    
    private final ToggleGroup keuzes;
    
    public RadioButtonPaneel(String titel, String[] waarden) {
        super(titel);
        keuzes = new ToggleGroup();
        setContent(maakKeuzeGroep(waarden));
    }
    
    private HBox maakKeuzeGroep(String[] waarden){
        HBox paneel = new HBox();
        paneel.setSpacing(10);
        for(String waarde: waarden){
            RadioButton keuze = new RadioButton(waarde);
            keuze.setToggleGroup(keuzes);
            keuze.setUserData(waarde);
            paneel.getChildren().add(keuze);
        }
        return paneel;
    }
    
    public void addListener(ChangeListener<Toggle> cl){
        keuzes.selectedToggleProperty().addListener(cl);
    }
}
