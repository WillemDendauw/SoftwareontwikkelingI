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
public class MaxGewichtTruck extends Truck{
    private int maxGewichtLading;

    public MaxGewichtTruck(int gewichtLeeg, int gewichtLading, int maxGewichtLading) {
        super(gewichtLeeg, gewichtLading);
        this.maxGewichtLading = maxGewichtLading;
    }

   
    @Override
    public String toString()
    {
        return super.toString()+ " (" + maxGewichtLading + " kg max lading)";
    }
    
     public boolean isOverladen()
     {
       
         return (maxGewichtLading < super.getLading());
     }
     
    
}
