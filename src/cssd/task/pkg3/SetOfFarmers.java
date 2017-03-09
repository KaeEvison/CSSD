/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class SetOfFarmers extends ArrayList<Farmer> implements Serializable 
{
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
    
    public Boolean availability(String username){
        
        for (int i = 0; i < noOfFarmers; i++) 
        {
            if (this.get(i).getUsername().equals(username))
            {
                return true;
            }
        }
        return false;
    }
    
    void addFarmer(Farmer afarmer)
    {
        super.add(afarmer);
        noOfFarmers++;
    }
    
    private void removeFarmer(Farmer afarmer)
    {
        super.remove(afarmer);
        noOfFarmers--;
    }
    
    public String toString()
    {
        String holder = "";
        for (int i = 0; i < this.size(); i++)
        {
            holder += this.get(i).toString();
        }
        return holder;
    }
}
