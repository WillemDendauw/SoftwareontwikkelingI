package model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author tiwi 
 */
public class Circle extends Shape {

    public Circle(Color kleur, Integer... geg){
        super(kleur, geg[0], geg[1], geg[2], geg[2]);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(kleur);
        g.fillOval(x, y, breedte, hoogte);
    }

}
