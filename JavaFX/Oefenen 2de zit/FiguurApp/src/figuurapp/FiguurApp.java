/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuurapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class FiguurApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TekenCanvas canvas = new TekenCanvas();
        figuurAppMenu menu = new figuurAppMenu(canvas);
        DrukknopPaneel dp = new DrukknopPaneel(canvas,primaryStage);
        LinkerPaneel lp = new LinkerPaneel(dp,canvas);
        
        BorderPane bp = new BorderPane();
        bp.setTop(menu);
        bp.setLeft(lp);
        bp.setRight(canvas);
        
        
        Scene scene = new Scene(bp);
        
        primaryStage.setTitle("FiguurApp");   
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
