/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;
import java.util.ArrayList;

/**
 *
 * @author b4027708
 */
public class FieldArea
{
    ArrayList<Location> points;
    
    public FieldArea(Location... pointsList)
    {
        for (int i = 0; i < pointsList.length; i++)
        {
            points.add(pointsList[i]);
        }
    } 
}