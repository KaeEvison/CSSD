/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.Date;

/**
 *
 * @author trkirk
 */
public class Harvest {
    
    private double yield = 0.0d;
    private Planting planting;
    private Date timeHarvested;
    
    public Harvest(Planting planting, Date timeHarvested ){
        this.planting = planting;
        this.timeHarvested = timeHarvested;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public Planting getPlanting() {
        return planting;
    }

    public void setPlanting(Planting planting) {
        this.planting = planting;
    }

    public Date getTimeHarvested() {
        return timeHarvested;
    }

    public void setTimeHarvested(Date timeHarvested) {
        this.timeHarvested = timeHarvested;
    }
}
