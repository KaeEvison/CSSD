/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author b4027320
 */
public class Field implements Serializable{
    public Planting currentPlanting;
    private FieldArea fieldArea;
    public ArrayList<Harvest> harvestHistory;
    public SetOfSensorMonitors activeMonitors;
    //ArrayList<AutomatedMachineryMonitor> automatedMachineryMonitor;
    
    public Field(Planting a, FieldArea b, ArrayList<Harvest> c) {
        currentPlanting = a;
        fieldArea = b;
        harvestHistory = c;
        activeMonitors = new SetOfSensorMonitors();
    }
    
    public Field()
    {
        currentPlanting = new Planting("Empy", 0.00f);
        fieldArea = new FieldArea();
        harvestHistory = new ArrayList<Harvest>();
        activeMonitors = new SetOfSensorMonitors();
    }
    
    public void recordNewHarvest(Harvest newHarvest) {
        harvestHistory.add(newHarvest);
        currentPlanting.setType("Empty");
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
    
    public Planting getPlanting()
    {
        return currentPlanting;
    }
    
    public void addSensorMonitor(Sensor newSensor)
    {
        SensorMonitor newMonitor = new SensorMonitor(newSensor);
        activeMonitors.add(newMonitor);
    }
    
    public SetOfSensorMonitors getMonitors()
    {
        return activeMonitors;
    }
}
