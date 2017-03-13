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
    public SetOfSensorMonitors(){
        super();
    }
    
    public void addSensorMonitor(SensorMonitor sensorMonitor){
        super.add(sensorMonitor);
    }
    
    public void removeSensorMonitor(int index){
        super.remove(index);
    }
    
    public void getNewReadings()
    {
        for (int i = 0; i < this.size(); i++)
        {
            this.get(i).getNewReading();
        }
    }
}
