/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmte;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class Warmte extends Application {

    private Slider links = new Slider();
    private Slider rechts = new Slider();
    private Slider onder = new Slider();
    private Slider boven = new Slider();
    private GridPane gp;
    private Warmtemodel model;
    private Label[][] label;
    private AnimationTimer animation;

    private void changeCells() {

    }

    @Override
    public void start(Stage primaryStage) {

        model = new Warmtemodel(this);

        label = new Label[10][10];
        BorderPane root = new BorderPane();

        root.setTop(boven);
        root.setLeft(links);
        root.setRight(rechts);
        root.setBottom(onder);
        //root.setCenter();

        links.setOrientation(Orientation.VERTICAL);
        rechts.setOrientation(Orientation.VERTICAL);

        setSliders(boven);
        setSliders(onder);
        setSliders(links);
        setSliders(rechts);

        gp = new GridPane();
        gp.setGridLinesVisible(true);
        addLabels();

        root.setCenter(gp);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello Warmte");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void setSliders(Slider s) {
        s.setMin(0.0);
        s.setMax(100.0);
        s.setValue(0.0);
        s.setShowTickMarks(true);
        s.setMajorTickUnit(20);
        s.setBlockIncrement(0.1);
    }

    public Label[][] getLabels(){
        return label;
    }
    
    public double getLinks(){
        return links.getValue();
    }
    
    public double getRechts(){
        return rechts.getValue();
    }
    
    public double getBoven(){
        return boven.getValue();
    }
    
    public double getOnder(){
        return onder.getValue();
    }
    
    public void addLabels() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                label[i][j] = new Label();
                label[i][j].setStyle("-fx-background-color:BLUE");
                label[i][j].setPrefSize(40, 40);
                gp.add(label[i][j], i, j);
            }
        }
    }

}
