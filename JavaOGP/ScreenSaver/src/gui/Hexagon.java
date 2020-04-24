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
public class Hexagon extends Shape {
    
    private int[] xwaardes, ywaardes;
    //uitleg polygoon kijk naar de foto van 14/3/19
    public Hexagon(java.awt.Color kleur, Integer x, Integer y, Integer breedte){
        super(x,y,breedte,breedte,kleur);
        int z = breedte / 2;
        int h = (int) (breedte * Math.sqrt(3) / 2);
        xwaardes = new int[]{x,x + breedte/4,x + 3*breedte/4,x+breedte,x + 3*breedte/4,x + breedte/4};
        ywaardes = new int[]{y+h/2,y,y,y+h/2,y+h,y+h};
    }
    
    @Override
    public void draw(Graphics2D g){
        g.setColor(kleur);
        g.fillPolygon(xwaardes,ywaardes,6);
    }
}
