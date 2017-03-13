/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author b4027708
 */
public class FieldArea implements Serializable
{
    ArrayList<Location> points;
    
    //Constructor allows for any number of coordinates for the fields corners
    public FieldArea(Location... pointsList)
    {
        this.points = new ArrayList();
        for (int i = 0; i < pointsList.length; i++)
        {
            points.add(pointsList[i]);
        }
    }
    
    //Takes a location and returns true or false on whether that location is within the field
    public boolean isLocationInArea(Location loc)
    {
        int xMin, xMax, yMin, yMax;
        xMin = points.get(0).getX();
        xMax = points.get(0).getX();
        yMin = points.get(0).getY();
        yMax = points.get(0).getY();
        boolean result = false;
        for (int i = 1; i < points.size(); i++)
        {
            if (points.get(i).getX() < xMin)
            {
                xMin = points.get(i).getX();
            }
            else if (points.get(i).getX() > xMax)
            {
                xMax = points.get(i).getX();
            }
            
            if (points.get(i).getY() < yMin)
            {
                yMin = points.get(i).getY();
            }
            else if (points.get(i).getY() > yMax)
            {
                yMax = points.get(i).getY();
            }
        }
        
        if ((xMin <= loc.getX()) && (xMax >= loc.getX()) && (yMin <= loc.getY()) && (yMax >= loc.getY()))
        {
            result = true;
        }
        
        return result;
    }
}