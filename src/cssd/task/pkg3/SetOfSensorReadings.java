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
    //Constructor sets up an empty list
    public SetOfSensorReadings()
    {
        super();
    }
    
    //Constructor that takes any number of sensor readings and creates a new list containing them
    public SetOfSensorReadings(SensorReading... readingList)
    {
        for (int i = 0; i < readingList.length; i++)
        {
            super.add(readingList[i]);
        }
    }
    
    //Adds a reading to the list
    public void addSensorReading(SensorReading newReading)
    {
        super.add(newReading);
    }
    
    //Returns the length of the list
    public int getSize()
    {
        return this.size();
    }
    
    //Takes a second set of readings and adds them to the current list
    public void append(SetOfSensorReadings toAdd)
    {
        for (int i = 0; i < toAdd.getSize(); i++)
        {
            this.add(toAdd.get(i));
        }
    }
    
    //Overrides the default toString for easier reading
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
    
    //Returns the most recent reading
    public SensorReading mostRecent()
    {
        int temp =  this.getSize();
        return this.get(temp-1);
    }
}