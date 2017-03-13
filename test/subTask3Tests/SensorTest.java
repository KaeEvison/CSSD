/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subTask3Tests;

import cssd.task.pkg3.AirHumiditySensor;
import cssd.task.pkg3.LightSensor;
import cssd.task.pkg3.Location;
import cssd.task.pkg3.SensorMonitor;
import cssd.task.pkg3.SensorReading;
import cssd.task.pkg3.SetOfSensorMonitors;
import cssd.task.pkg3.SoilAciditySensor;
import cssd.task.pkg3.SoilMoistureSensor;
import cssd.task.pkg3.SoilTemperatureSensor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Kae
 */
public class SensorTest
{
    Location loc = new Location(0, 0);
    SoilMoistureSensor testSensorMoist = new SoilMoistureSensor(loc);
    SoilAciditySensor testSensorAcid = new SoilAciditySensor(loc);
    SoilTemperatureSensor testSensorTemp = new SoilTemperatureSensor(loc);
    AirHumiditySensor testSensorHumid = new AirHumiditySensor(loc);
    LightSensor testSensorLight = new LightSensor(loc);
    SensorMonitor testMonitorMoist = new SensorMonitor(testSensorMoist);
    SensorMonitor testMonitorAcid = new SensorMonitor(testSensorAcid);
    SensorMonitor testMonitorTemp = new SensorMonitor(testSensorTemp);
    SensorMonitor testMonitorHumid = new SensorMonitor(testSensorHumid);
    SensorMonitor testMonitorLight = new SensorMonitor(testSensorLight);
    SetOfSensorMonitors testSet = new SetOfSensorMonitors();
    
    @Test
    public void testTakeReading()
    {
        System.out.println("First reading:\n");
        System.out.print("Moisture:\t\t");
        System.out.println(testMonitorMoist.getNewReading().getValue());
        System.out.print("Acidity:\t\t");
        System.out.println(testMonitorAcid.getNewReading().getValue());
        System.out.print("Temperature:\t\t");
        System.out.println(testMonitorTemp.getNewReading().getValue());
        System.out.print("Humidity:\t\t");
        System.out.println(testMonitorHumid.getNewReading().getValue());
        System.out.print("Light:\t\t\t");
        System.out.println(testMonitorLight.getNewReading().getValue());
        System.out.println("\n\nSecond reading:\n");
        System.out.print("Moisture:\t\t");
        System.out.println(testMonitorMoist.getNewReading().getValue());
        System.out.print("Acidity:\t\t");
        System.out.println(testMonitorAcid.getNewReading().getValue());
        System.out.print("Temperature:\t\t");
        System.out.println(testMonitorTemp.getNewReading().getValue());
        System.out.print("Humidity:\t\t");
        System.out.println(testMonitorHumid.getNewReading().getValue());
        System.out.print("Light:\t\t\t");
        System.out.println(testMonitorLight.getNewReading().getValue());
        System.out.println("\n\nThird reading:\n");
        System.out.print("Moisture:\t\t");
        System.out.println(testMonitorMoist.getNewReading().getValue());
        System.out.print("Acidity:\t\t");
        System.out.println(testMonitorAcid.getNewReading().getValue());
        System.out.print("Temperature:\t\t");
        System.out.println(testMonitorTemp.getNewReading().getValue());
        System.out.print("Humidity:\t\t");
        System.out.println(testMonitorHumid.getNewReading().getValue());
        System.out.print("Light:\t\t\t");
        System.out.println(testMonitorLight.getNewReading().getValue());
    }
    
    @Test
    public void testMinReading()
    {
        testSet.add(testMonitorMoist);
        testSet.add(testMonitorAcid);
        testSet.add(testMonitorTemp);
        testSet.add(testMonitorHumid);
        testSet.add(testMonitorLight);
        int i = 20;
        while (i > 0)
        {
            testSet.getNewReadings();
            i--;
        }
        
        System.out.println("Moist min: " + testMonitorMoist.getMinValue());
        System.out.println("Acid min: " + testMonitorAcid.getMinValue());
        System.out.println("Temp min: " + testMonitorTemp.getMinValue());
        System.out.println("Humid min: " + testMonitorHumid.getMinValue());
        System.out.println("Light min: " + testMonitorLight.getMinValue());
        
        testMonitorMoist.getReadings().add(new SensorReading(0, "", "", loc));
        testMonitorAcid.getReadings().add(new SensorReading(0, "", "", loc));
        testMonitorTemp.getReadings().add(new SensorReading(-10, "", "", loc));
        testMonitorHumid.getReadings().add(new SensorReading(0, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(0, "", "", loc));
        
        assertEquals(testMonitorMoist.getMinValue(), 0, 0);
        assertEquals(testMonitorAcid.getMinValue(), 0, 0);
        assertEquals(testMonitorTemp.getMinValue(), -10, 0);
        assertEquals(testMonitorHumid.getMinValue(), 0, 0);
        assertEquals(testMonitorLight.getMinValue(), 0, 0);
    }
    
    @Test
    public void testMaxReading()
    {
        testSet.add(testMonitorMoist);
        testSet.add(testMonitorAcid);
        testSet.add(testMonitorTemp);
        testSet.add(testMonitorHumid);
        testSet.add(testMonitorLight);
        int i = 20;
        while (i > 0)
        {
            testSet.getNewReadings();
            i--;
        }
        
        System.out.println("Moist max: " + testMonitorMoist.getMaxValue());
        System.out.println("Acid max: " + testMonitorAcid.getMaxValue());
        System.out.println("Temp max: " + testMonitorTemp.getMaxValue());
        System.out.println("Humid max: " + testMonitorHumid.getMaxValue());
        System.out.println("Light max: " + testMonitorLight.getMaxValue());
        
        testMonitorMoist.getReadings().add(new SensorReading(0.5, "", "", loc));
        testMonitorAcid.getReadings().add(new SensorReading(14, "", "", loc));
        testMonitorTemp.getReadings().add(new SensorReading(15, "", "", loc));
        testMonitorHumid.getReadings().add(new SensorReading(100, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(10752, "", "", loc));
        
        assertEquals(testMonitorMoist.getMaxValue(), 0.5, 0.0);
        assertEquals(testMonitorAcid.getMaxValue(), 14, 0.0);
        assertEquals(testMonitorTemp.getMaxValue(), 15, 0.0);
        assertEquals(testMonitorHumid.getMaxValue(), 100, 0.0);
        assertEquals(testMonitorLight.getMaxValue(), 10752, 0.0);
    }
    
    @Test
    public void testRange()
    {
        testSet.add(testMonitorMoist);
        testSet.add(testMonitorAcid);
        testSet.add(testMonitorTemp);
        testSet.add(testMonitorHumid);
        testSet.add(testMonitorLight);
        int i = 20;
        while (i > 0)
        {
            testSet.getNewReadings();
            i--;
        }
        
        System.out.println("Moist range: " + testMonitorMoist.getRange());
        System.out.println("Acid range: " + testMonitorAcid.getRange());
        System.out.println("Temp range: " + testMonitorTemp.getRange());
        System.out.println("Humid range: " + testMonitorHumid.getRange());
        System.out.println("Light range: " + testMonitorLight.getRange());
        
        testMonitorMoist.getReadings().add(new SensorReading(0, "", "", loc));
        testMonitorMoist.getReadings().add(new SensorReading(0.5, "", "", loc));
        testMonitorAcid.getReadings().add(new SensorReading(0, "", "", loc));
        testMonitorAcid.getReadings().add(new SensorReading(14, "", "", loc));
        testMonitorTemp.getReadings().add(new SensorReading(-10, "", "", loc));
        testMonitorTemp.getReadings().add(new SensorReading(15, "", "", loc));
        testMonitorHumid.getReadings().add(new SensorReading(0, "", "", loc));
        testMonitorHumid.getReadings().add(new SensorReading(100, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(0, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(10752, "", "", loc));
        
        assertEquals(testMonitorMoist.getRange(), 0.5, 0);
        assertEquals(testMonitorAcid.getRange(), 14, 0);
        assertEquals(testMonitorTemp.getRange(), 25, 0);
        assertEquals(testMonitorHumid.getRange(), 100, 0);
        assertEquals(testMonitorLight.getRange(), 10752, 0);
    }
    
    @Test
    public void testMean()
    {
        testMonitorLight.getReadings().remove(0);
        testMonitorLight.getReadings().add(new SensorReading(100, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(1000, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(63, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(743, "", "", loc));
        testMonitorLight.getReadings().add(new SensorReading(8765, "", "", loc));
        
        assertEquals(testMonitorLight.getMean(), 2134.2, 0);
    }
}
