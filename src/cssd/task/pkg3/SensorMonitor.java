/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    private LocalDateTime lastReadingTime;
    private SetOfSensorReadings log = new SetOfSensorReadings();
    
    //Constructor takes a sensor object and assigns it to the new monitor, an initial reading is taken from the sensor and the reading time is recorded
    public SensorMonitor(Sensor newSensor)
    {
        sensor = newSensor;
        this.getNewReading();
        lastReadingTime = LocalDateTime.now();
    }

    //Returns the sensor attached to this monitor
    public Sensor getSensor() {
        return sensor;
    }

    //Assigns a sensor to the monitor
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    //Returns the interval
    public int getInterval() {
        return interval;
    }

    //Sets the interval
    public void setInterval(int interval) {
        this.interval = interval;
    }

    //Gets the time for the most recent reading
    public LocalDateTime getLastReadingTime() {
        return lastReadingTime;
    }

    //Manually sets the last reading time
    public void setLastReadingTime(LocalDateTime lastReadingTime) {
        this.lastReadingTime = lastReadingTime;
    }
    
    //Gets a new reading from the attached sensor then records that reading and time it was taken
    public SensorReading getNewReading(){
        SensorReading holder = sensor.takeReading();
        log.add(holder);
        lastReadingTime = LocalDateTime.now();
        return holder;
    }
    
    //Returns the location
    public Location getLocation()
    {
        return sensor.getLocation();
    }
    
    //Returns the log of sensorReadings
    public SetOfSensorReadings getReadings()
    {
        return log;
    }
}
