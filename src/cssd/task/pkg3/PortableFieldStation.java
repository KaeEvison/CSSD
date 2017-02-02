/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.util.ArrayList;

/**
 *A Hand-held device that the farmer takes out into the field, 
 * puts a Sensor in the ground and selects to take a SensorReading. 
 * 
 * Notes: A PortableFieldStation is not associated with a SetOfSensorMonitors 
 * because the Sensors attached to the PortableFieldStation can change. 
 * It does not have to use the same Sensors every time. 
 * Like a StaticFieldStation, a PortableFieldStation also has
 * a local store of a SetOfSensorReadings that will be pushed to the Server.
 * 
 * If the PortableFieldStation loses connection to the server then
 * the reading will fail and the Farmer must try again another time.
 * 
 * @author trkirk
 */
public class PortableFieldStation {
    private ArrayList<Sensor> sensors;
    private SetOfSensorReadings sensorReadings;
    
    public void collectSensorReadings(SensorReading sensorReading){
        sensorReadings.addSensorReading(sensorReading);
    }
    
    public SetOfSensorReadings sendSensorReadings(){
        return sensorReadings;
    }
    
    
}
