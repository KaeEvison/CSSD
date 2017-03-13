/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

/**
 *
 * @author thoma
 */
public class AirTemperatureSensor extends Sensor {
    
    //Constructor for this type of sensor sets up the relevant values
    public AirTemperatureSensor(Location loc){
        sensorType = "Air temperature";
        location = loc;
        dataUnit = "°C";
        minReading = -5;
        maxReading = 30;
    }
}
