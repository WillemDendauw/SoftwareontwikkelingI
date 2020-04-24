
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heat_2019;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Willem Dendauw
 */
public class View extends Application implements EventHandler<MouseEvent> {
    
    private Slider links, rechts, boven, onder;
    private static final int DIM = 10; //maken we static zodat dit zeker geinitialiseerd is
    
    private HeatModel model;
    
    private MyLabel[][] labelMatrix;
    
    @Override
    public void start(Stage primaryStage) {
        
        model = new HeatModel(DIM,DIM,this);
        labelMatrix = new MyLabel[DIM][DIM];
        
        Scene scene = new Scene(maakRoot(),300,300);
        
        primaryStage.setTitle("Kookpot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public GridPane maakRoot(){
        GridPane root = new GridPane();
        links = maakSlider(Orientation.VERTICAL);
        rechts = maakSlider(Orientation.VERTICAL);
        boven = maakSlider(Orientation.HORIZONTAL);
        onder = maakSlider(Orientation.HORIZONTAL);
        
        //kolom, rij
        root.add(links,0,1);
        root.add(rechts,2,1);
        root.add(boven,1,0);
        root.add(onder,1,2);
        
        root.add(maakRooster(),1,1);
        
        return root;
    }
    
    public GridPane maakRooster(){
        GridPane rooster = new GridPane();
        for(int i=0;i<DIM;i++){
            for(int j=0;i<DIM;i++){
                int kolom = i;
                int rij = j;
                labelMatrix[rij][kolom] = maakLabel(rij,kolom);
                rooster.add(labelMatrix[rij][kolom],kolom,rij);
            }
        }
        return rooster;
    }
    
    public MyLabel maakLabel(int rij,int kolom){
        return new MyLabel(rij,kolom);
    }
    
    public Slider maakSlider(Orientation orientation){
        Slider slider = new Slider();
        slider.setOrientation(orientation);
        slider.setMin(0);
        slider.setMax(100);
        slider.setMajorTickUnit(10);
        
        slider.setOnMouseReleased(this);
        return slider;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void updateGUI(){
        for(int i=0; i<DIM; i++){
            for(int k=0; k<DIM; k++){
                double temp = model.getTemperatuur(i,k);
                int roodWaarde = (int) ((temp / 100.0)*255);
                int blauwWaarde = 255 - roodWaarde;
                labelMatrix[i][k].setKleur(roodWaarde,blauwWaarde);
            }
        }
    }
    
    @Override
    public void handle(MouseEvent event){
        Object source = event.getSource();
        if(source == links || source == rechts || source == boven || source == onder){
            model.initialiseerTemperaturen((int)links.getValue(),(int)rechts.getValue(),(int)boven.getValue(),(int)onder.getValue());
        }
    }
}
