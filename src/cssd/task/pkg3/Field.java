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
    
    //Constructor for a field allowing for initialisation using a fieldarea as well as an existing harvest and harvestHistory
    public Field(Planting a, FieldArea b, ArrayList<Harvest> c) {
        currentPlanting = a;
        fieldArea = b;
        harvestHistory = c;
        activeMonitors = new SetOfSensorMonitors();
    }
    
    //Constructor for a new empty field
    public Field()
    {
        currentPlanting = new Planting();
        fieldArea = new FieldArea();
        harvestHistory = new ArrayList<Harvest>();
        activeMonitors = new SetOfSensorMonitors();
    }
    
    //Records a harvest to the field's harvestHistory then creates a new empty planting
    public void recordNewHarvest(Harvest newHarvest) {
        harvestHistory.add(newHarvest);
        currentPlanting = new Planting();
    }
    
    //Sets the current planting
    public void recordNewPlanting(Planting newPlanting) {
        currentPlanting = newPlanting;
    }
    
    //Returns the fieldArea
    public FieldArea getFieldArea() {
        return fieldArea;
    }
    
    //Returns the harvestHistory
    public ArrayList<Harvest> getHarvestHistory() {
        return harvestHistory;
    }
    
    //Returns the planting
    public Planting getPlanting()
    {
        return currentPlanting;
    }
    
    //Adds a new sensorMonitor to the field
    public void addSensorMonitor(Sensor newSensor)
    {
        SensorMonitor newMonitor = new SensorMonitor(newSensor);
        activeMonitors.add(newMonitor);
    }
    
    //Returns the field's sensorMonitors
    public SetOfSensorMonitors getMonitors()
    {
        return activeMonitors;
    }
}
