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
import cssd.task.pkg3.SoilAciditySensor;
import cssd.task.pkg3.SoilMoistureSensor;
import cssd.task.pkg3.SoilTemperatureSensor;
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
    
    @Test
    public void testTakeReading()
    {
        System.out.print("\n\nMoisture:\t\t");
        System.out.println(testMonitorMoist.getNewReading().getValue());
        System.out.print("\n\nAcidity:\t\t");
        System.out.println(testMonitorAcid.getNewReading().getValue());
        System.out.print("\n\nTemperature:\t\t");
        System.out.println(testMonitorTemp.getNewReading().getValue());
        System.out.print("\n\nHumidity:\t\t");
        System.out.println(testMonitorHumid.getNewReading().getValue());
        System.out.print("\n\nLight:\t\t\t");
        System.out.println(testMonitorLight.getNewReading().getValue());
    }
}
