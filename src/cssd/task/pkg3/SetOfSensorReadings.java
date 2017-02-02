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
    
    public void addSensorReading(SensorReading newReading)
    {
        super.add(newReading);
    }
}