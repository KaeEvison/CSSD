/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.Timer;

/**This holds a SetOfSensorMonitors attached to it and 
 * stores a SetOfSensorReadings taken by each Sensor 
 * attached to it. 
 * This has 2 methods; to update the SensorReadings, 
 * and to send the SetOfSensorReadings it has collected
 * to the Server. The StaticFieldStation invokes these 
 * 2 methods based on the tick of a timer. 
 * When ‘updateSensorReadings’ method is invoked, 
 * it gets the ‘lastReadingTime’ attribute 
 * and interval from the SensorMonitor. 
 * 
 * Based on a calculation of these 2 variables, 
 * the StaticFieldStation will tell the SensorMonitor
 * to get a new SensorReading. A local store of 
 * a SetOfSensorReadings is held as, if there is no 
 * connection to the Server, the readings cannot
 * always be pushed up to the Server when they 
 * are immediately taken.
 *
 * @author trkirk
 */
public class StaticFieldStation {
    
    private SetOfSensorMonitors sensorMonitors;
    private SetOfSensorReadings readingsToSend;
    private int sendInterval = 0;
    private Timer timer;
    private Server server;
    
    public StaticFieldStation(Server server){
        timer = new Timer();
        sensorMonitors = new SetOfSensorMonitors();
        readingsToSend = new SetOfSensorReadings();
        this.server = server;
    }

    public SetOfSensorMonitors getSensorMonitors() {
        return sensorMonitors;
    }

    public void setSensorMonitors(SetOfSensorMonitors sensorMonitors) {
        this.sensorMonitors = sensorMonitors;
    }

    public SetOfSensorReadings getReadingsToSend() {
        return readingsToSend;
    }

    public void setReadingsToSend(SetOfSensorReadings readingsToSend) {
        this.readingsToSend = readingsToSend;
    }

    public int getSendInterval() {
        return sendInterval;
    }

    public void setSendInterval(int sendInterval) {
        this.sendInterval = sendInterval;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
