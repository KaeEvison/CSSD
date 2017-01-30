/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.time.LocalDateTime;

/**
 *
 * @author b4027708
 */
public class SensorReading
{
    private double value;
    private LocalDateTime timeTaken;
    private String readingUnit;
    private String readingType;
    private String location;
    
    public SensorReading(double pValue, String pUnit, String pType, String pLocation)
    {
        value = pValue;
        timeTaken = LocalDateTime.now();
        readingUnit = pUnit;
        readingType = pType;
        location = pLocation;
    }
}