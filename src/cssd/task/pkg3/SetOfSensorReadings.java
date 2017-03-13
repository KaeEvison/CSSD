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
    
    public int getSize()
    {
        return this.size();
    }
    
    public void append(SetOfSensorReadings toAdd)
    {
        for (int i = 0; i < toAdd.getSize(); i++)
        {
            this.add(toAdd.get(i));
        }
    }
    
    public String toString()
    {
        String holder = new String("");
        holder += this.get(0);
        for (int i = 1; i < this.size(); i++)
        {
            holder += "\n";
            holder += this.get(i).toString();
        }
        return holder;
    }
    
    public SensorReading mostRecent()
    {
        int temp =  this.getSize();
        return this.get(temp-1);
    }
}