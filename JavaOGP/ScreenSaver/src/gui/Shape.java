/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.awt.Graphics2D;

/**
 *
 * @author Willem Dendauw
 */
public abstract class Shape {
    protected int x, y, breedte, hoogte;
    protected java.awt.Color kleur;
    
    public Shape(int x, int y, int breedte, int hoogte, java.awt.Color kleur){
        this.x = x;
        this.y = y;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.kleur = kleur;  
    }
    
    public abstract void draw(Graphics2D g);
    

}
