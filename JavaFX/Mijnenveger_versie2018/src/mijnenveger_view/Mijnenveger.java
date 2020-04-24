/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mijnenveger_view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mijnenveger_model.SpeelveldModel;

/**
 *
 * @author Willem Dendauw
 */
public class Mijnenveger extends Application implements EventHandler<MouseEvent> {
    
    private int HOOGTE = 11;
    private int BREEDTE = 11;
    private int AANTALBOMMEN = 10;
    private SpeelveldModel model;
    private MijnenveldButton[][] buttons;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mijnenveger");
        primaryStage.setScene(maakScene());
        primaryStage.show();
    }

    private Scene maakScene(){
        Scene scene = new Scene(maakGridPane(),500,500);
        return scene;
    }
    
    private GridPane maakGridPane(){
        GridPane grid = new GridPane();
        model = new SpeelveldModel(HOOGTE,BREEDTE,AANTALBOMMEN);
        buttons = new MijnenveldButton[HOOGTE][BREEDTE];
        for (int i=0; i< HOOGTE; i++){
            for (int k=0; i-k<BREEDTE; k++){
                buttons[i][k] = new MijnenveldButton(i,k,model.getVakje(i,k));
                buttons[i][k].setOnMouseClicked(this);
                grid.add(buttons[i][k],k,i);
            }
        }
        return grid;
    }
    
    private void hertekenAlles() {
        for (int i=0; i<HOOGTE; i++){
            for (int k=0; k<BREEDTE;k++){
                buttons[i][k].toonPrent();
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void handle(MouseEvent event){
        Object source = event.getSource();
        if (source instanceof MijnenveldButton){
            MijnenveldButton btn = (MijnenveldButton) source;
            if(((MouseEvent) event).getButton().equals(MouseButton.PRIMARY)){
                btn.klikOpen();
            }
            else if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)){
                btn.toggleVlag();
            }
        }
        hertekenAlles();
    }
    
}
