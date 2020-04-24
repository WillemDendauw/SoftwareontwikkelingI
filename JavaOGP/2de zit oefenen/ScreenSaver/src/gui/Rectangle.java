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
public class Rectangle extends Shape {
    
    public Rectangle(java.awt.Color kleur, Integer x, Integer y, Integer breedte, Integer hoogte){
        super(x,y,breedte,hoogte,kleur);
    }
    
    @Override
    public void draw(Graphics2D g){
        g.setColor(kleur);
        g.fillRect(x, y, breedte, hoogte);
    }
}
