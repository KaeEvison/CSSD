/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.Timer;

/**
 *
 * @author b4027320
 */
public class AutomatedMachineryMonitor {
    //AutomatedMachinery automatedMachinery;
    Server server;
    Timer timer;
    Planting planting;
    
    public boolean checkIfTreatmentNeeded() {
        return true;
    }
    
    public void provideTreatment() {
        return;
    }
    
    public void setPlanting(Planting planting) {
        this.planting = planting;
    }
}
