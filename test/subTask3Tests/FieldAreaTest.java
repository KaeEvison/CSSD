/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subTask3Tests;

import cssd.task.pkg3.FieldArea;
import cssd.task.pkg3.Location;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author b4027708
 */
public class FieldAreaTest
{
    private static Location c1 = new Location(2, 10), c2 = new Location(14, 10), c3 = new Location(14, 3), c4 = new Location(2, 3);
    private static FieldArea testArea = new FieldArea(c1, c2, c3, c4);
    private Location testPoint = new Location(3, 7);
    
    @Test
    public void testIsLocationInArea()
    {
        boolean result;
        result = testArea.isLocationInArea(testPoint);
        assertEquals(result, true);
        
        testPoint.setX(0);
        testPoint.setY(0);
        result = testArea.isLocationInArea(testPoint);
        assertEquals(result, false);
    }
}