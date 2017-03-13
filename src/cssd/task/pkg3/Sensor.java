/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author thoma
 */
public class Sensor implements Serializable{
    
    protected String sensorType = "";
    protected String dataUnit = "";
    protected Location location;
    protected static Random numberGen = new Random();
    protected double minReading, readingRange;
    
    //No constructor, each type of sensor has its own

    //Returns the data unit
    public String getDataUnit() {
        return dataUnit;
    }

    //Sets the data unit
    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    //Returns the location
    public Location getLocation() {
        return location;
    }

    //Sets the location
    public void setLocation(Location location) {
        this.location = location;
    }
    
    //Returns a new reading using a random value to simulate actual sensor hardware
    public SensorReading takeReading()
    {
        return new SensorReading(   getRandomValue(),
                                    this.dataUnit,
                                    this.sensorType,
                                    this.location);
    }
    
    //Generates a random value based on the sensor's range
    private double getRandomValue()
    {
        double value = numberGen.nextDouble();
        value *= readingRange;
        value += minReading;
        value *= 100;
        value = Math.round(value);
        value /= 100;
        return value;
    }
}
