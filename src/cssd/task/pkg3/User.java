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
public class User implements Serializable{
    private String username;
    private String firstName;
    private String surname;
    private String location;
    private String phoneNumber;
    private String password;
    protected SetOfOrders orders;
    public boolean isFarmer;
    
    //Standard constructor
    public User (String username, 
        String firstName, String surname, 
        String location, String 
        phoneNumber, String password)
    {
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.password = password;
    
        orders = new SetOfOrders();
        isFarmer = false;
        
    
    }

    //Returns first name
    public String getFirstName() {
        return firstName;
    }

    //Sets first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Returns first name
    public String getSurname() {
        return surname;
    }

    //Sets surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Returns location
    public String getLocation() {
        return location;
    }

    //Sets location
    public void setLocation(String location) {
        this.location = location;
    }

    //Returns phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Sets phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    //Returns username
    public String getUsername() {
        return username;
    }

    //Returns password
    public String getPassword() {
        return password;
    }
    
    //Expects current password and a new password, as long as the current password is correct the password is set to the new value
    public void changePassword(String newPass, String oldPass)
    {
        if (this.password.equals(oldPass))
        {
            this.password = newPass;
        }
        else
        {
            System.out.println("Password Incorrect");
        }
    }

    //Adds an order to the list of orders
    public void addOrder(Order newOrder)
    {
        orders.addOrder(newOrder);
    }
    
    //Overrides the default toString for easier reading
    public String toString()
    {
        String holder = "\n\nUsername: " + username + "\nName: " + firstName + " " + surname + "\nLocation: " + location + "\nPhone number: " + phoneNumber + "\nPassword: " + password;
        return holder;
    }
}


