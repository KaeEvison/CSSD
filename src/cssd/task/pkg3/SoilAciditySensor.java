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
public class SoilAciditySensor extends Sensor
{
    //Constructor for this type of sensor sets up the relevant values
    public SoilAciditySensor(Location loc){
        sensorType = "Soil acidity";
        location = loc;
        dataUnit = "pH";
        minReading = 0;
        maxReading = 14;
    }
}
