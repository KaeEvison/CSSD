/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subTask3Tests;

import cssd.task.pkg3.Farmer;
import cssd.task.pkg3.Field;
import cssd.task.pkg3.Order;
import cssd.task.pkg3.Server;
import static cssd.task.pkg3.Server.serializeAll;
import cssd.task.pkg3.SetOfFarmers;
import cssd.task.pkg3.SetOfOrders;
import cssd.task.pkg3.SetOfSensorMonitors;
import cssd.task.pkg3.SetOfUsers;
import cssd.task.pkg3.User;
import java.time.LocalDateTime;
import org.junit.Test;

/**
 *
 * @author b4027708
 */
public class ServerTest
{
    SetOfFarmers testFarmers = new SetOfFarmers();
    SetOfUsers testUsers = new SetOfUsers();
    SetOfOrders testOrders = new SetOfOrders();
    Farmer testFarmer1;
    Farmer testFarmer2;
    User testUser1 = new User("","James","","","","");
    Order testOrder1;
    Order testOrder2;
    Order testOrder3;
    
    @Test
    public void testSerialization()
    {
        testFarmer1 = new Farmer("Testman1", "John", "Testman", "Harrogate", "01234567890", "Pass1");
        testFarmer2 = new Farmer("Testguy1", "Billy", "Testman", "Barnsley", "09876543210", "Pass2");
        testOrder1 = new Order("Apples", 100.00, testFarmer1, testUser1, LocalDateTime.now(), LocalDateTime.now(), "pending");
        testOrder2 = new Order("Oranges", 120.00, testFarmer1, testUser1, LocalDateTime.now(), LocalDateTime.now(), "complete");
        testOrder3 = new Order("Pears", 140.00, testFarmer2, testUser1, LocalDateTime.now(), LocalDateTime.now(), "pending");
        testFarmers.add(testFarmer1);
        testFarmers.add(testFarmer2);
        testOrders.add(testOrder1);
        testOrders.add(testOrder2);
        testOrders.add(testOrder3);
        
        serializeAll(testFarmers, testUsers, testOrders);
        
        Server testServer = new Server(new SetOfSensorMonitors());
        System.out.println(testServer.getData());
    }
}