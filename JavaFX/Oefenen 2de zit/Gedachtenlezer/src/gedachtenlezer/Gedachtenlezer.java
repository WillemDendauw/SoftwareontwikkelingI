/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gedachtenlezer;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class Gedachtenlezer extends Application {
    
    private Label[][] numberLabels;
    private Label[][] symbolLabels;
    private final int ROWS = 10;
    private final int COLUMNS = 10;
    private final int LABEL_WIDTH_HEIGHT = 25;
    private Random randomizer = new Random();
    private Button bttn_showResult;
    private Label lbl_showResult;
    
    @Override
    public void start(Stage primaryStage) {
        numberLabels = new Label[ROWS][COLUMNS];
        symbolLabels = new Label[ROWS][COLUMNS];
        
        GridPane centerPane = new GridPane();
        
        for(int i =0; i< numberLabels.length; i++){
            for(int j=0; j<numberLabels[i].length;j++){
                numberLabels[i][j] = new Label(""+(i*10 + j));
                numberLabels[i][j].setPrefSize(LABEL_WIDTH_HEIGHT,LABEL_WIDTH_HEIGHT);
                numberLabels[i][j].setStyle("-fx-border-width: 0.5 ; -fx-border-color: black ; -fx-background-color: beige;");
                numberLabels[i][j].setAlignment(Pos.CENTER);
                centerPane.add(numberLabels[i][j],j*2,i);
            }
        }
        
        for (int i = 0; i < symbolLabels.length; i++) {
            for (int j = 0; j < symbolLabels[i].length; j++) {
                symbolLabels[i][j] = new Label();
                symbolLabels[i][j].setPrefSize(LABEL_WIDTH_HEIGHT, LABEL_WIDTH_HEIGHT);
                symbolLabels[i][j].setStyle("-fx-border-width: 0.5 ; -fx-border-color: black ; -fx-background-color: orange; -fx-font-family: serif; -fx-font-size: 14");
                symbolLabels[i][j].setAlignment(Pos.CENTER);
                symbolLabels[i][j].setText(("" + (char) (randomizer.nextInt(51) + 74)));
                centerPane.add(symbolLabels[i][j], j * 2 + 1, i);
            }
        }
        
        int column = COLUMNS-2;
        for (int i = 1; i < symbolLabels.length; i++) {
            symbolLabels[i][column].setText(symbolLabels[0][COLUMNS - 1].getText());
            column--;
        }
        
        VBox rightPane = new VBox();
        rightPane.setSpacing(LABEL_WIDTH_HEIGHT);
        bttn_showResult = new Button("Toon");
        bttn_showResult.setPrefWidth(LABEL_WIDTH_HEIGHT *2);
        bttn_showResult.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                lbl_showResult.setText(symbolLabels[0][COLUMNS -1].getText());
                bttn_showResult.setDisable(true);
            }
        });
        
        lbl_showResult = new Label();
        lbl_showResult.setPrefSize(LABEL_WIDTH_HEIGHT * 2, LABEL_WIDTH_HEIGHT * 2);
        lbl_showResult.setAlignment(Pos.CENTER);
        lbl_showResult.setStyle("-fx-background-color: darkgrey; -fx-font-family: serif; -fx-font-size: 24");
        rightPane.getChildren().add(bttn_showResult);
        rightPane.getChildren().add(lbl_showResult);
        
        HBox root = new HBox();
        root.setSpacing(LABEL_WIDTH_HEIGHT * 2);
        root.setPadding(new Insets(LABEL_WIDTH_HEIGHT,LABEL_WIDTH_HEIGHT,LABEL_WIDTH_HEIGHT,LABEL_WIDTH_HEIGHT));
        root.getChildren().add(centerPane);
        root.getChildren().add(rightPane);
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Gedachtenlezer jwz");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
