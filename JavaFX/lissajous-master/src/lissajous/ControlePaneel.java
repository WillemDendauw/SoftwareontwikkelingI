/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissajous;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author tiwi
 */
public class ControlePaneel extends VBox {

    private static final String[] FREQ = {"1", "2", "3", "4", "5"};
    private static final int[] FAZES = {0, 45, 90, 135, 180};
    private final LissajousData data;

    public ControlePaneel(LissajousData data) {
        this.data = data;
        getStyleClass().add("vbox");
        RadioButtonPaneel horizFreqKeuze = new RadioButtonPaneel("Horizontale frequentie", FREQ);
        horizFreqKeuze.addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                int selectie = Integer.parseInt((String) newValue.getUserData());
                data.setHorizFreq(selectie);
            }
        });
        getChildren().add(horizFreqKeuze);
        RadioButtonPaneel vertFreqKeuze = new RadioButtonPaneel("Verticale frequentie", FREQ);
        vertFreqKeuze.addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                int selectie = Integer.parseInt((String) newValue.getUserData());
                data.setVertFreq(selectie);
            }
        });
        getChildren().add(vertFreqKeuze);
        getChildren().add(maakKeuzeFaze("Fazeverschil in graden"));
    }

    private TitelPaneel maakKeuzeFaze(String titel) {     
        HBox paneel = new HBox();
        paneel.setSpacing(10);
        paneel.getChildren().add(new Label("Faze"));
        ComboBox<Integer> keuzeFaze = new ComboBox<>();
        for (int i = 0; i < FAZES.length; i++) {
            keuzeFaze.getItems().add(FAZES[i]);
        }
        keuzeFaze.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                data.setFazeVerschil(newValue);
            }
        });
        paneel.getChildren().add(keuzeFaze);
        TitelPaneel titelPaneel = new TitelPaneel(titel);
        titelPaneel.setContent(paneel);
        return titelPaneel;
    }

}
