/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexnumbers;

/**
 *
 * @author Willem Dendauw
 */
public class NoComplexNumberNotation extends Exception {

    /**
     * Creates a new instance of <code>NoComplexNumberNotation</code> without
     * detail message.
     */
    public NoComplexNumberNotation() {
    }

    /**
     * Constructs an instance of <code>NoComplexNumberNotation</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoComplexNumberNotation(String msg) {
        super(msg);
    }
}
