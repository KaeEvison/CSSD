/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author b4027708
 */
public class SensorReading implements Serializable
{
    private double value;
    private LocalDateTime timeTaken;
    private String readingUnit;
    private String readingType;
    private Location location;
    
    public SensorReading(double pValue, String pUnit, String pType, Location pLocation)
    {
        value = pValue;
        timeTaken = LocalDateTime.now();
        readingUnit = pUnit;
        readingType = pType;
        location = pLocation;
    }
    
    public String toString()
    {
        String outputTime = new String();
        outputTime = timeTaken.toString().substring(0, 10);
        outputTime += " ";
        outputTime += timeTaken.toString().substring(11, 16);
        String holder = new String("");
        holder += "\n\nReading type:\t";
        holder += readingType;
        holder += "\nValue:\t\t";
        holder += value;
        holder += " ";
        holder += readingUnit;
        holder += "\nTime recorded:\t";
        holder += outputTime;
        holder += "\nLocation:\t";
        holder += location;
        return holder;
    }
}