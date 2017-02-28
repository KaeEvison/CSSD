/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author b3014277, trkirk
 */
public class Farmer extends User{

    private ArrayList<Planting> crops;
    private SetOfFields fields;

    public SetOfFields getFields() {
        return fields;
    }

    public void setFields(SetOfFields fields) {
        this.fields = fields;
    }
    
    public Farmer(String username, String firstName, String surname, 
            String location, String phoneNumber, String password)
    {
        super(username, firstName, surname, location, phoneNumber, password);
        fields = new SetOfFields(new ArrayList<Field>());
        orders = new SetOfOrders();
    }
    
    private Boolean hasAutomatedMachinery = false;

    public Boolean hasAutomatedMachinery() {
        return hasAutomatedMachinery;
    }
    
    public ArrayList<Planting> getCrops() {
        return crops;
    }

    public void setCrops(ArrayList<Planting> crops) {
        this.crops = crops;
    }
    
    // Expects a Date?
    // Calls getGrowthTime but this returns an int?
    int getTimeForCrop(Planting planting){
        return planting.getGrowthTime();
    }
    
}