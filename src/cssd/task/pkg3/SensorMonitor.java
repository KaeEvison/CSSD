/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.Date;

/**
 *This has the responsibility of controlling the Sensor it relates to, 
 *and relaying information between the Sensor and the StaticFieldStation.

 * 
 * @author trkirk
 */
public class SensorMonitor {
    
    private Sensor sensor;
    private int interval = 0;
    private Date lastReadingTime;

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
    
    public void getNewReading(double pValue, String pUnit, String pType, String pLocation){
        sensor.takeReading(pValue, pUnit, pType, pLocation);
    }
}
