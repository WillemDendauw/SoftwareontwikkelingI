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
public class Circle extends Shape {
    
    public Circle(java.awt.Color kleur, Integer x, Integer y, Integer breedte){
        super(x,y,breedte,breedte,kleur);
    }
    
    @Override
    public void draw(Graphics2D g){
        g.setColor(kleur);
        g.fillOval(x,y,hoogte,breedte);
    }
}
