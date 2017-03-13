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
public class SoilMoistureSensor extends Sensor {
    
    //Constructor for this type of sensor sets up the relevant values
    public SoilMoistureSensor(Location loc){
        sensorType = "Soil moisture level";
        location = loc;
        dataUnit = "m3.m-3";
        minReading = 0;
        readingRange = 0.5;
    }
}
