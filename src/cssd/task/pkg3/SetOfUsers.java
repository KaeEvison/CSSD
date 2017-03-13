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
 * @author b3014277
 */

public class SetOfUsers extends ArrayList<ProductLineManager> implements Serializable{
    
    private int noOfUsers = 0;
    
    //Constructor sets up an empty list
    public SetOfUsers()
    {
        super();
    }
    
    //Returns a manager object based on login details
    public ProductLineManager login(String username, String password)
    {
        ProductLineManager user = null;
        
        for (int i = 0; i < noOfUsers; i++)
        {
           if( this.get(i).getUsername().equals(username)
                 && this.get(i).getPassword().equals(password) )
           {
               user = this.get(i);
           }
        }
        return user;
    }
    
    //Checks whether a manager under the provided username is in the list
    public Boolean availability(String username){
        
        for (int i = 0; i < noOfUsers; i++) 
        {
            if (this.get(i).getUsername().equals(username))
            {
                return true;
            }
        }
        return false;
    }
    
    //Adds a user to the list
    void addUser(ProductLineManager auser)
    {
        super.add(auser);
        noOfUsers++;
    }
    
    //Removes a user from the list
    void removerUser(ProductLineManager auser)
    {
        super.remove(auser);
        noOfUsers--;
        
    }
    
    SetOfUsers getSuitableFarmers(Planting suitable)
    {
        return null;
    }
}
