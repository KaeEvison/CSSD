/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author trkirk
 */
public class Harvest implements Serializable{
    
    private double yield = 0.0d;
    private Planting planting;
    private Date timeHarvested;
    public int field;
    
    //Standard constructor, all fields are required
    public Harvest(Planting planting, Date timeHarvested, double yield, int field){
        this.planting = planting;
        this.timeHarvested = timeHarvested;
        this.yield = yield;
        this.field = field;
    }

    //Returns the yield
    public double getYield() {
        return yield;
    }

    //Allows for manual setting of the yield
    public void setYield(double yield) {
        this.yield = yield;
    }

    //Returns the planting
    public Planting getPlanting() {
        return planting;
    }

    //Allows for manual setting of the planting
    public void setPlanting(Planting planting) {
        this.planting = planting;
    }

    //Returns the time harvested
    public Date getTimeHarvested() {
        return timeHarvested;
    }

    //Allows for manual setting of the planting
    public void setTimeHarvested(Date timeHarvested) {
        this.timeHarvested = timeHarvested;
    }
}
