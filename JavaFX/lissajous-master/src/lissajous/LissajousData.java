/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lissajous;

import javafx.scene.canvas.Canvas;

/**
 *
 * @author tiwi
 */
public class LissajousData {
    protected static final int HF_DEF = 0;
    protected static final int VF_DEF = 0;
    protected static final int F_DEF = -1;
    private int horizFreq, vertFreq, fazeVerschil;
    private LissajousCanvas canvas;

    public LissajousData() {
        horizFreq = HF_DEF;
        vertFreq = VF_DEF;
        fazeVerschil = F_DEF;
    }

    /**
     * Get the value of horizFreq
     *
     * @return the value of horizFreq
     */
    public int getHorizFreq() {
        return horizFreq;
    }

    /**
     * Set the value of horizFreq
     *
     * @param horizFreq new value of horizFreq
     */
    public void setHorizFreq(int horizFreq) {
        this.horizFreq = horizFreq;
        canvas.teken();
    }

    public int getVertFreq() {
        return vertFreq;
    }

    public void setVertFreq(int vertFreq) {
        this.vertFreq = vertFreq;
        canvas.teken();
    }

    public int getFazeVerschil() {
        return fazeVerschil;
    }

    public void setFazeVerschil(int fazeVerschil) {
        this.fazeVerschil = fazeVerschil;
        canvas.teken();
    }
    
    public void setCanvas(LissajousCanvas canvas){
        this.canvas = canvas;
    }

    
}
