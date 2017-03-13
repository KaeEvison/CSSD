/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subTask3Tests;

import cssd.task.pkg3.Field;
import cssd.task.pkg3.Harvest;
import cssd.task.pkg3.Planting;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Kae
 */
public class HarvestTest
{
    Field testField = new Field();
    Planting testPlanting1 = new Planting("Pineapples", 300);
    Planting testPlanting2 = new Planting("Tomatoes", 150);
    
    @Test
    public void testHarvest()
    {
        testField.recordNewPlanting(testPlanting1);
        testField.recordNewHarvest(new Harvest(testField.getPlanting(), new java.util.Date(), 500, 1));
        assertEquals(testField.getPlanting().getType(), "Empty");
        assertEquals(testField.getHarvestHistory().get(0).getPlanting(), testPlanting1);
    }
}