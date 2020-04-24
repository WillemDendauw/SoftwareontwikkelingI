/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuurapp;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Willem Dendauw
 */
public class TekenCanvas extends Canvas{
    private final static int BREEDTE = 400;
    private final static int HOOGTE = 400;
    private final static Color DEFAULT_COLOR = Color.BLUE;
    private final GraphicsContext gc;
    private Color tekenKleur;
    
    public TekenCanvas(){
        super(BREEDTE,HOOGTE);
        gc = this.getGraphicsContext2D();
        initCanvas();
    }
    
    public void resetCanvas(){
        gc.clearRect(0,0,BREEDTE,HOOGTE);
    }
    
    public Color getTekenKleur(){
        return tekenKleur;
    }
    public Color getDefaultKleur(){
        return DEFAULT_COLOR;
    }
    
    public void setKleur(Color kleur){
        this.tekenKleur = kleur;
        gc.setFill(tekenKleur);
    }
    
    public void initCanvas(){
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeRect(0,0,BREEDTE,HOOGTE);
        tekenKleur = DEFAULT_COLOR;
        gc.setFill(tekenKleur);
    }
    
    public void tekenFiguur(String s, double x, double y){
        if(s.equals("Rechthoek")){
            gc.fillRect(x-20,y-30,40,60);
        }
        if(s.equals("Cirkel")){
            gc.fillOval(x-20,y-30,40,40);
        }
        if(s.equals("Vierkant")){
            gc.fillRect(x-20,y-20,40,40);
        }
    }
}
