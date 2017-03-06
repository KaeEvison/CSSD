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
    
    
    
    public User login(String username, String password)
    {
        User user = null;
        
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
