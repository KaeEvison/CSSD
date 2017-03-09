/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.util.Date;

/**
 *This has the responsibility of controlling the Sensor it relates to, 
 *and relaying information between the Sensor and the StaticFieldStation.

 * 
 * @author trkirk
 */
public class SensorMonitor implements Serializable{
    
    private Sensor sensor;
    private int interval = 0;
    private Date lastReadingTime;
    private SetOfSensorReadings log = new SetOfSensorReadings();
    
    public SensorMonitor(Sensor newSensor)
    {
        sensor = newSensor;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public Date getLastReadingTime() {
        return lastReadingTime;
    }

    public void setLastReadingTime(Date lastReadingTime) {
        this.lastReadingTime = lastReadingTime;
    }
    
    public SensorReading getNewReading(){
        SensorReading holder = new SensorReading(-500, "NULL", "NULL", new Location(0, 0));
        holder = sensor.takeReading();
        log.add(holder);
        return holder;
    }
    
    public Location getLocation()
    {
        return sensor.getLocation();
    }
    
    public SetOfSensorReadings getReadings()
    {
        return log;
    }
}
