/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

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
public class Server
{
    private SetOfSensorReadings sensorReadings;
    private static final String FILENAME = "readingsLog.ser";
    File outputFile = new File(FILENAME);
    
    public Server(){}
    
    public void addReadings(SetOfSensorReadings newReadings)
    {
        try
        {
            Serialize(sensorReadings, FILENAME);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    
    public SetOfSensorReadings readLog(String filename)
    {
        SetOfSensorReadings log = new SetOfSensorReadings();
        try
        {
            log = (SetOfSensorReadings)Deserialize(filename);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        return log;
    }
    
    public SetOfSensorReadings getReadingsForFieldArea(FieldArea fieldArea)
    {
        // Need to sort out fieldarea first
        return null;
    }
    
    private static void Serialize(Object obj, String filename) throws IOException
    {
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(obj);
        out.close();
    }
     
    private static Object Deserialize(String filename) throws IOException, ClassNotFoundException
    {
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object obj = ois.readObject();
        in.close();

        return obj;
    }
}