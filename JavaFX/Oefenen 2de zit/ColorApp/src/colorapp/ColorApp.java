/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorapp;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class ColorApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox hb = new HBox();
        VBox vb = new VBox();
        Slider r = makeSlider();
        Slider g = makeSlider();
        Slider b = makeSlider();
        
        Label red = new Label("Red: ");
        Label green = new Label("Green: ");
        Label blue = new Label("Blue: ");
        Label vierkant = new Label();
        vierkant.setMinSize(400,400);
        vb.getChildren().addAll(red,r,green,g,blue,b);
        
        
        r.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number old_val, Number new_val){
                vierkant.setStyle("-fx-background-color: rgb("+r.getValue()+","+g.getValue()+","+b.getValue()+")");
            }
        });
        
        g.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number old_val,Number new_val){
                vierkant.setStyle("-fx-background-color: rgb("+r.getValue()+","+g.getValue()+","+b.getValue()+")");
            }
        });
        
        b.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number old_val, Number new_val){
                vierkant.setStyle("-fx-background-color: rgb("+r.getValue()+","+g.getValue()+","+b.getValue()+")");
            }
        });
        
        vierkant.setStyle("-fx-background-color: rgb("+r.getValue()+","+g.getValue()+","+b.getValue()+")");
        hb.getChildren().addAll(vb,vierkant);
        Scene scene = new Scene(hb);
        
        primaryStage.setTitle("Colorapp");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private Slider makeSlider(){
        Slider s = new Slider(0,255,128);
        s.setMajorTickUnit(100);
        s.setMinorTickCount(25);
        s.setShowTickLabels(true);
        s.setShowTickMarks(true);
        return s;
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
