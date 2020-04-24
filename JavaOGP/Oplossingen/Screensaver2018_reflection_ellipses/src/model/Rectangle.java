/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author tiwi
 */
public class Rectangle extends Shape{

    public Rectangle(Color kleur, Integer... geg) {
        super(kleur, geg[0], geg[1], geg[2], geg[3]);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(kleur);
        g.fillRect(x,y,breedte,hoogte);
    }
    
}
