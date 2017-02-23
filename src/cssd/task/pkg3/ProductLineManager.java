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
public class ProductLineManager extends User
{
    String company = "";
    
    public ProductLineManager( String username, String firstName, String surname, 
            String location, String phoneNumber, String password, String companyName)
    {
        super(username, firstName, surname, location, phoneNumber, password);
        company = companyName;
    }
}
