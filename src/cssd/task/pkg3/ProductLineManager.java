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
public class ProductLineManager extends User implements Serializable
{
    public String company = "";
    public ArrayList<Farmer> blockList;
    
    public ProductLineManager( String username, String firstName, String surname, 
            String location, String phoneNumber, String password, String companyName)
    {
        super(username, firstName, surname, location, phoneNumber, password);
        company = companyName;
        isFarmer = false;
        blockList = new ArrayList<Farmer>();
    }
    
    public String getUserType()
    {
        return "Manager";
    }
}
