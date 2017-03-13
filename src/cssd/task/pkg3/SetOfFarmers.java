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
    public int noOfFarmers = 0;
    
    //Constructor creates an empty array of farmers
    public SetOfFarmers()
    {
        super();
    }
    
    //Checks the entered details against each farmer object to validate a login attempt
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
    
    //Checks whether there is a farmer under the provided username in the list
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
    
    //Adds a farmer to the list
    void addFarmer(Farmer afarmer)
    {
        super.add(afarmer);
        noOfFarmers++;
    }
    
    //Removes a farmer from the list
    void removeFarmer(Farmer afarmer)
    {
        super.remove(afarmer);
        noOfFarmers--;
    }
    
    //Overrides the default toString for easier reading
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
