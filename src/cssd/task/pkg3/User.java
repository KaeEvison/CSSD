/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

/**
 *
 * @author b3014277
 */
public class User {
    private String username;
    private String firstName;
    private String surname;
    private String location;
    private String phoneNumber;
    private String password;
    private SetOfOrders orders;
    
public User (String username, String firstName, String surname, String location, String phoneNumber, String password)
{
    this.username = username;
    this.firstName = firstName;
    this.surname = surname;
    this.location = location;
    this.phoneNumber = phoneNumber;
    this.password = password;
    
}
    
public void changePassword(String newPass)
{
    this.password = newPass;
}

public void addOrder()
{
    
}
    
    
}


