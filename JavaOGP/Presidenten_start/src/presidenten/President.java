/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenten;

/**
 *
 * @author Willem Dendauw
 */
public class President extends Persoon {

    private String naam;
    private String tijd;
    private String start;
    private String eind;
    private int periodes;

    public President() {

    }

    public President(String naam, String tijd, String start, String eind, int periodes) {
        this.naam = naam;
        this.tijd = tijd;
        this.start = start;
        this.eind = eind;
        this.periodes = periodes;
    }
}
