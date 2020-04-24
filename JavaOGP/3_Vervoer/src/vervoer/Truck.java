/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vervoer;

/**
 *
 * @author Marleen
 */
public class Truck implements IVoertuig{

    private int gewichtLeeg;
    private int gewichtLading;
    // MERK OP: GEEN instantievariabelen voor aantal passagiers of maximum snelheid;
    //          die 'bereken' je in plaats van te bewaren.

    public Truck(int gewichtLeeg, int gewichtLading) {
        this.gewichtLeeg = gewichtLeeg;
        this.gewichtLading = gewichtLading;

    }

    public int getMaxSnelheid() {
        if (gewichtLeeg + gewichtLading >= 7500) {
            return 90;
        } else {
            return 120;
        }
    }

    public int getAantalPassagiers() {
        return 2;
    }

    @Override
    public String toString() {
        return gewichtLeeg + " kg leeg gewicht - " + gewichtLading + "kg geladen ";
    }

    //toegevoegd voor MaxGewichtTruck
    public int getLading() {
        return gewichtLading;
    }
}
