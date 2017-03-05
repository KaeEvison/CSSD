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
public class LightSensor extends Sensor {
    
    public LightSensor(Location loc){
        sensorType = "Light level";
        location = loc;
        dataUnit = "lx";
        minReading = -0;
        readingRange = 10752;
    }
}
