/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class SetOfFarmers extends ArrayList<Farmer>{
    
    private int noOfFarmers = 0;
    
    public SetOfFarmers()
    {
        super();
    }
    
    public Farmer login(String username, String password)
    {
        Farmer farmer = null;
        
        for (int i = 0; i < noOfFarmers; i++)
        {
           if( this.get(i).getUsername().equals(username)
                 && this.get(i).getPassword().equals(password) )
           {
               farmer = this.get(i);
           }
        }
        return farmer;
    }
    
    void addFarmer(Farmer afarmer)
    {
        super.add(afarmer);
        noOfFarmers++;
    }
    
    private void removerFarmer(Farmer afarmer)
    {
        super.remove(afarmer);
        noOfFarmers--;
        
    }
}
