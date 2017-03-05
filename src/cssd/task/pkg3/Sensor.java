/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author thoma
 */
public class Sensor {
    
    protected String sensorType = "";
    protected String dataUnit = "";
    protected Location location;
    protected static Random numberGen = new Random();
    protected double minReading, readingRange;
    
    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public SensorReading takeReading()
    {
        return new SensorReading(   getRandomValue(),
                                    this.dataUnit,
                                    this.sensorType,
                                    this.location);
    }
    
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
