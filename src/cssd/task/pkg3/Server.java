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
    Location testData = new Location(2,3);
    private SetOfSensorReadings sensorReadings;
    private static final String FILENAME = "readingsLog.ser";
    File outputFile = new File(FILENAME);
    private SetOfSensorMonitors allSensors = new SetOfSensorMonitors();
    
    public Server(){}
    
    public Server(SetOfSensorMonitors initialSensors)
    {
        allSensors = initialSensors;
    }
    
    public void addReadings(SetOfSensorReadings newReadings)
    {
        try
        {
            Serialize(newReadings, FILENAME);
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
        SetOfSensorReadings readingsForArea = new SetOfSensorReadings();
        for (int i = 0; i < allSensors.size(); i++)
        {
            if (fieldArea.isLocationInArea(allSensors.get(i).getLocation()))
            {
                readingsForArea.add(allSensors.get(i).getNewReading(21.0, "Celcius", "Soil temperature", testData));
            }
        }
        return readingsForArea;
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