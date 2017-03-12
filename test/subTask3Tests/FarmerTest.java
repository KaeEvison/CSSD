/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subTask3Tests;

import cssd.task.pkg3.Farmer;
import cssd.task.pkg3.Field;
import cssd.task.pkg3.Planting;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Kae
 */
public class FarmerTest
{
    String username = "TestFarmer";
    String firstName = "Harry";
    String surname = "Test";
    String location = "Testville";
    String phoneNumber = "01234567890";
    String password = "testPass1";
    Farmer testFarmer = new Farmer(username, firstName, surname, location, phoneNumber, password);
    Field testField1 = new Field();
    ArrayList<Planting> crops = new ArrayList();
    Planting testPlanting1 = new Planting("beans", 20);
    Planting testPlanting2 = new Planting("carrots", 15);
    Planting testPlanting3 = new Planting("oranges", 25);
    
    @Test
    public void testCreateFarmer()
    {
        assertEquals(testFarmer.getUsername(), "TestFarmer");
        assertEquals(testFarmer.getFirstName(), "Harry");
        assertEquals(testFarmer.getSurname(), "Test");
        assertEquals(testFarmer.getLocation(), "Testville");
        assertEquals(testFarmer.getPhoneNumber(), "01234567890");
        assertEquals(testFarmer.getPassword(), "testPass1");
    }
    
    @Test
    public void testAddFields()
    {
        testFarmer.getFields().addField(testField1);
        
        assertEquals(testFarmer.getFields().getFieldByIndex(0), testField1);
    }
    
    @Test
    public void testCrops()
    {
        crops.add(testPlanting1);
        crops.add(testPlanting2);
        crops.add(testPlanting3);
        testFarmer.setCrops(crops);
        
        assertEquals(testFarmer.getCrops().get(0), testPlanting1);
        assertEquals(testFarmer.getCrops().get(1), testPlanting2);
        assertEquals(testFarmer.getCrops().get(2), testPlanting3);
        assertEquals(testFarmer.getCrops().get(0).getType(), "beans");
        assertEquals(testFarmer.getCrops().get(0).getPricePerTon(), 20, 0);
    }
    
    @Test
    public void testChangePassword()
    {
        testFarmer.changePassword("newPass1", testFarmer.getPassword());
        assertEquals(testFarmer.getPassword(), "newPass1");
        
        testFarmer.changePassword("newPass2", "wrongPass1");
        assertEquals(testFarmer.getPassword().equals("newPass2"), false);
    }
}