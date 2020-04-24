/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorapp;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class ColorApp extends Application {
    
    private Slider rood = new Slider(0,255,128);
    private Slider groen = new Slider(0,255,128);
    private Slider blauw = new Slider(0,255,128);
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(20);
        setSlider(rood);
        setSlider(groen);
        setSlider(blauw);
        
        Label red = makeLabel("Red: ");
        Label green = makeLabel("Green: ");
        Label blue = makeLabel("Blue: ");
        Label vierkant = new Label();
        vierkant.setMinSize(400,400);
        
        root.add(rood,1,1);
        root.add(groen,1,2);
        root.add(blauw,1,3);
        
        root.add(red,1,1);
        root.add(green,1,2);
        root.add(blue,1,3);
        
        rood.valueProperty().addListener(
                        new ChangeListener<Number>() {
                              public void changed(ObservableValue ov,
                              Number old_val, Number new_val) {vierkant.setStyle("-fx-background-color: rgb("+rood.getValue()+","+groen.getValue()+","+blauw.getValue()+")");}
                                });
        
        groen.valueProperty().addListener(
                        new ChangeListener<Number>() {
                              public void changed(ObservableValue ov,
                              Number old_val, Number new_val) {vierkant.setStyle("-fx-background-color: rgb("+rood.getValue()+","+groen.getValue()+","+blauw.getValue()+")");}
                                });
        
        blauw.valueProperty().addListener(
                        new ChangeListener<Number>() {
                              public void changed(ObservableValue ov,
                              Number old_val, Number new_val) {vierkant.setStyle("-fx-background-color: rgb("+rood.getValue()+","+groen.getValue()+","+blauw.getValue()+")");}
                                });

        vierkant.setStyle("-fx-background-color: rgb("+rood.getValue()+","+groen.getValue()+","+blauw.getValue()+")");
        
        root.add(vierkant,2,2);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Label makeLabel(String s){
        Label l = new Label();
        l.setText(s);
        return l;
    }
    
    public void setSlider(Slider s){
        //s = new Slider(0,255,128);
        s.setMajorTickUnit(100);
        s.setMinorTickCount(25);
        s.setShowTickLabels(true);
        s.setShowTickMarks(true);
        s.setBlockIncrement(0.5);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
