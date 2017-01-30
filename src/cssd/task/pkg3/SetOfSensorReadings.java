/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author b4027708
 */
public class SetOfSensorReadings extends ArrayList<SensorReading>
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