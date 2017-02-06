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
 * @author b4027708
 */
public class SetOfSensorReadings extends ArrayList<SensorReading> implements Serializable
{
    public SetOfSensorReadings()
    {
        super();
    }
    
    public SetOfSensorReadings(SensorReading... readingList)
    {
        for (int i = 0; i < readingList.length; i++)
        {
            super.add(readingList[i]);
        }
    }
    
    public void addSensorReading(SensorReading newReading)
    {
        super.add(newReading);
    }
}