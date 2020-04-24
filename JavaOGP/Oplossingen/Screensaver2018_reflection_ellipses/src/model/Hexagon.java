package model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author tiwi
 */
public class Hexagon extends Shape{

    public Hexagon(Color kleur, Integer... geg){
        super(kleur,geg[0],geg[1],geg[2],(int)(Math.sqrt(3)*geg[2])/2);
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(kleur);
        int r = breedte/2;
        int[] xx= {x+r/2,x+3*r/2,x+2*r,x+3*r/2,x+r/2,x};
        int z = (int) (Math.sqrt(3)*r);
        int[] yy = {y,y,y+z/2,y+z,y+z,y+z/2};
        g.fillPolygon(xx,yy,6);
    }
    
}
