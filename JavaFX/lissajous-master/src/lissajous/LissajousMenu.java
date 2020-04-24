/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lissajous;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

/**
 *
 * @author tiwi
 */
public class LissajousMenu extends MenuBar {

    public LissajousMenu() {
        Menu bestand = new Menu("Bestand");
        MenuItem item = new MenuItem("Afsluiten");
        item.setAccelerator(KeyCombination.keyCombination("Ctrl+q"));
        item.setOnAction( new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        bestand.getItems().add(item);
        getMenus().add(bestand);
    }
    
}
