/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subTask3Tests;

import cssd.task.pkg3.Location;
import cssd.task.pkg3.SensorReading;
import cssd.task.pkg3.Server;
import cssd.task.pkg3.SetOfSensorMonitors;
import cssd.task.pkg3.SetOfSensorReadings;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author b4027708
 */
public class ServerTest
{
    SensorReading test1 = new SensorReading(21, "degrees celcius", "Soil temperature", new Location(12, 20));
    SensorReading test2 = new SensorReading(23, "degrees celcius", "Soil temperature", new Location(14, 6));
    SensorReading test3 = new SensorReading(16, "degrees celcius", "Soil temperature", new Location(7, 14));
    SetOfSensorReadings instance = new SetOfSensorReadings(test1, test2, test3);
    SetOfSensorMonitors testMonitors = new SetOfSensorMonitors();
    Server testServer = new Server(testMonitors);
    
    @Test
    public void testAddReadings()
    {
        testServer.addReadings(instance, "Jim");
        System.out.println("\n\nAfter write:\n\n");
        SetOfSensorReadings testSet = new SetOfSensorReadings();
        SetOfSensorReadings receiveSet = new SetOfSensorReadings();
        receiveSet = testServer.readLog("Jim");
        for (int i = 0; i < receiveSet.getSize(); i++)
        {
            testSet.add(receiveSet.get(i));
        }
        System.out.println(testSet.toString());
    }
}