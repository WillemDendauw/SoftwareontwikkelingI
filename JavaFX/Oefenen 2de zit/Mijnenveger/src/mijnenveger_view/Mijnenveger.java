/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mijnenveger_view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
    private Knoppen[][] buttons;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mijnenveger");
        primaryStage.setScene(maakScene());
        primaryStage.show();
    }

    private Scene maakScene() {
        Scene scene = new Scene(maakGridPane(), 500, 500);
        return scene;
    }

    private GridPane maakGridPane() {
        GridPane gp = new GridPane();
        model = new SpeelveldModel(HOOGTE, BREEDTE, AANTALBOMMEN);
        buttons = new Knoppen[HOOGTE][BREEDTE];
        for (int i = 0; i < HOOGTE; i++) {
            for (int j = 0; j < BREEDTE; j++) {
                buttons[i][j] = new Knoppen(i, j, model.getVakje(i, j));
                buttons[i][j].setOnMouseClicked(this);
                gp.add(buttons[i][j], j, i);
            }
        }
        return gp;
    }

    private void hertekenAlles() {
        for (int i = 0; i < HOOGTE; i++) {
            for (int k = 0; k < BREEDTE; k++) {
                buttons[i][k].toonPrent();
            }
        }
    }

    @Override
    public void handle(MouseEvent e) {
        Object source = e.getSource();
        if (source instanceof Knoppen) {
            Knoppen btn = (Knoppen) source;
            if (((MouseEvent) e).getButton().equals(MouseButton.PRIMARY)) {
                btn.klikOpen();
            } else if (((MouseEvent) e).getButton().equals(MouseButton.SECONDARY)) {
                btn.toggleVlag();
            }
        }
        hertekenAlles();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
