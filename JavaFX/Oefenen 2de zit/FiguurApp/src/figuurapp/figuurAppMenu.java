/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuurapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

/**
 *
 * @author Willem Dendauw
 */
public class figuurAppMenu extends MenuBar implements EventHandler<ActionEvent> {
    private Menu bestand;
    private MenuItem reset;
    private final TekenCanvas canvas;
    
    public figuurAppMenu(TekenCanvas canvas){
        this.canvas = canvas;
        bestand = new Menu("Bestand");
        reset = new MenuItem("Reset");
        reset.setAccelerator(KeyCombination.keyCombination("Ctrl+r"));
        this.getMenus().add(bestand);
        bestand.getItems().add(reset);
        reset.setOnAction(this);
    }
    
    @Override
    public void handle(ActionEvent e){
        MenuItem item = (MenuItem) e.getSource();
        if(item.equals(reset)){
            canvas.resetCanvas();
            canvas.initCanvas();
        }
    }
}
