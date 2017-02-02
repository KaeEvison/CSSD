/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

/**
 *
 * @author thoma
 */
public class Sensor {
    
    protected String dataUnit = "";
    protected Location location;
    
    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
    public SensorReading takeReading(double pValue, String pUnit, String pType, String pLocation)
    {
        return new SensorReading(pValue, pUnit, pType, pLocation);
    }
}
