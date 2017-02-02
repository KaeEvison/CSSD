/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;
import java.util.ArrayList;

/**
 *
 * @author b3014277
 */

public class SetOfUsers extends ArrayList<User>{
    
    private int noOfUsers = 0;
    
    public SetOfUsers()
    {
        super();
    }
    
    
    
    private User login(String username, String password)
    {
        for (int i = 0; i < noOfUsers; i++)
        {
           // if () 
           // {
                
           // }
        }
        return null;
        
    }
    
    void addUser(User auser)
    {
        super.add(auser);
        noOfUsers++;
    }
    
    private void removerUser(User auser)
    {
        super.remove(auser);
        noOfUsers--;
        
    }
    
    SetOfUsers getSuitableFarmers(Planting suitable)
    {
        return null;
    }
    
}
