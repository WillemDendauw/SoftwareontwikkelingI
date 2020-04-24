/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper_view;

import javafx.scene.control.Button;

/**
 *
 * @author Wim
 */
public class MyButton extends Button{
    private int row;
    private int column;

    public MyButton(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
}
