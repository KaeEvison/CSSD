/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author trkirk
 */
public class SetOfSensorMonitors extends ArrayList<SensorMonitor> implements Serializable
{
    //Constructor sets up an empty list
    public SetOfSensorMonitors(){
        super();
    }
    
    //Adds a sensor monitor to the list
    public void addSensorMonitor(SensorMonitor sensorMonitor){
        super.add(sensorMonitor);
    }
    
    //Removes a sensor monitor from the list
    public void removeSensorMonitor(int index){
        super.remove(index);
    }
    
    //Requests new readings from each monitor in the list
    public void getNewReadings()
    {
        for (int i = 0; i < this.size(); i++)
        {
            this.get(i).getNewReading();
        }
    }
}
