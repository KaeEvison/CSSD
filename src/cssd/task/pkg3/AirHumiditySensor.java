/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

/**
 *
 * @author Kae
 */
public class AirHumiditySensor extends Sensor {
    
    public AirHumiditySensor(Location loc){
        sensorType = "Air humidity";
        location = loc;
        dataUnit = "%";
        minReading = 0;
        readingRange = 100;
    }
}
