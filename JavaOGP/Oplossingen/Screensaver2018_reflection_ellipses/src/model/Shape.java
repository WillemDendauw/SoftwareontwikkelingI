package model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author tiwi
 */
public abstract class Shape {

    protected final int x;
    protected final int y;
    protected final int breedte;
    protected final int hoogte;
    protected final Color kleur;

    public Shape(Color kleur, int x, int y, int breedte, int hoogte){
        this.x = x;
        this.y = y;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.kleur = kleur;
    }
    
    public abstract void draw(Graphics2D g);
    
    

}
