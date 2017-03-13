/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

/**
 *
 * @author trkirk
 */
public class SoilTemperatureSensor extends Sensor {
    
    //Constructor for this type of sensor sets up the relevant values
    public SoilTemperatureSensor(Location loc){
        sensorType = "Soil temperature";
        location = loc;
        dataUnit = "°C";
        minReading = -10;
        readingRange = 15;
    }
}
