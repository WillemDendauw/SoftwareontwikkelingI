/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmte;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class Warmte extends Application implements EventHandler<MouseEvent> {

    private Slider links = new Slider();
    private Slider rechts = new Slider();
    private Slider onder = new Slider();
    private Slider boven = new Slider();
    private static final int DIM = 10;

    private GridPane gp;
    private Warmtemodel model;
    private MyLabel[][] label;
    private AnimationTimer animation;

    @Override
    public void start(Stage primaryStage) {
        model = new Warmtemodel(10, 10, this);
        label = new MyLabel[DIM][DIM];
        BorderPane root = new BorderPane();

        root.setTop(boven);
        root.setLeft(links);
        root.setRight(rechts);
        root.setBottom(onder);

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

        Scene scene = new Scene(root, 300, 300);

        primaryStage.setTitle("Warmte");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setSliders(Slider s) {
        s.setMin(0.0);
        s.setMax(100.0);
        s.setValue(0.0);
        s.setShowTickMarks(true);
        s.setMajorTickUnit(20);
        s.setBlockIncrement(0.1);
    }

    public Label[][] getLabels() {
        return label;
    }

    public double getLinks() {
        return links.getValue();
    }

    public double getRechts() {
        return rechts.getValue();
    }

    public double getBoven() {
        return boven.getValue();
    }

    public double getOnder() {
        return onder.getValue();
    }

    public void addLabels() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                label[i][j] = new MyLabel(i, j);
                label[i][j].setStyle("-fx-background-color:BLUE");
                label[i][j].setPrefSize(40, 40);
                gp.add(label[i][j], i, j);
            }
        }
    }

    public void updateGui() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                double temp = model.getTemp(i, j);
                int roodWaarde = (int) ((temp / 100.0) * 255);
                int blauwWaarde = 255 - roodWaarde;
                label[i][j].setKleur(roodWaarde, blauwWaarde);
            }
        }
    }

    @Override
    public void handle(MouseEvent e) {
        Object source = e.getSource();
        if (source == links || source == rechts || source == boven || source == onder) {
            model.initTemp((int) links.getValue(), (int) rechts.getValue(), (int) boven.getValue(), (int) onder.getValue());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
