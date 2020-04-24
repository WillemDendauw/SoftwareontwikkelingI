/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vervoer;

/**
 *
 * @author Marleen
 * */
 public class Trein implements IVoertuig{
    private int aantalPassagiers;
    private int maxSnelheid;
    private boolean internationaal;
    
    public Trein(int aantalPassagiers, int maxSnelheid, String intern){
        this.aantalPassagiers = aantalPassagiers;
        this.maxSnelheid = maxSnelheid;
        this.internationaal = (intern.equals("yes")||intern.equals("ja")||intern.equals("internationaal"));

    }
        

    public int getAantalPassagiers(){
        return aantalPassagiers;
    }
    
    public int getMaxSnelheid(){
        return maxSnelheid;
    }

    @Override
    public String toString()
    {
         String resultaat = aantalPassagiers + " passagiers " + maxSnelheid + " km/h ";
         if (internationaal)
         {
              resultaat = resultaat + " - internationale trein ";
         }
         return resultaat;
    }
}