/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author b4027320
 */
public class Field {
    Planting currentPlanting;
    FieldArea fieldArea;
    ArrayList<Harvest> harvestHistory;
    ArrayList<AutomatedMachineryMonitor> automatedMachineryMonitor;
    
    public Field(Planting a, FieldArea b, ArrayList<Harvest> c) {
        currentPlanting = a;
        fieldArea = b;
        harvestHistory = c;
    }
    
    public void recordNewHarvest(Harvest newHarvest) {
        harvestHistory.add(newHarvest);
        currentPlanting = null;
    }
    
    public void recordNewPlanting(Planting newPlanting) {
        currentPlanting = newPlanting;
    }
    
    public FieldArea getFieldArea() {
        return fieldArea;
    }
    
    public ArrayList<Harvest> getHarvestHistory() {
        return harvestHistory;
    }
}
