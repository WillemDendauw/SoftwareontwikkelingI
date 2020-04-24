/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexomzetter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class HexOmzetter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox root = makeRoot();
        
        
        Label lblhex = makeLabel("Hexadecimaal getal: ");
        TextField txtfhex = makeTextField(true);
        Label lbldec = makeLabel("Decimaal getal: ");
        TextField txtfdc = makeTextField(false);
        Button zetOm = makeButton();
        
        
        zetOm.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event) {
                try {
                String hex = txtfhex.getText();
                int dec = Integer.parseInt(hex,16);
                txtfdc.setText(""+dec);
                }
                catch (NumberFormatException ex) {
                    txtfdc.clear();
                    txtfhex.clear();
                }
            }
        });
        
        
        root.getChildren().addAll(lblhex,txtfhex,lbldec,txtfdc,zetOm);
        Scene scene = new Scene(root);
        root.setPadding(new Insets(10,10,10,10));
        primaryStage.setTitle("HexOmzetter");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene(); //gelijkaardig aan pack()
        primaryStage.show();
    }

    public HBox makeRoot() {
        HBox root = new HBox(15); //is hetzelfde als root.setSpacin(15)
        return root;
    }
    
    public Button makeButton(){
        Button btn = new Button();
        btn.setText("Zet Om");
        
        return btn;
    }
    
    public Label makeLabel(String s) {
        Label l = new Label();
        l.setText(s);
        return l;
    }
    
    public TextField makeTextField(boolean editable) {
        TextField txt = new TextField();
        txt.setEditable(editable);
        return txt;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
