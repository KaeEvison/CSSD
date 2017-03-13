/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;

/**
 *
 * @author trkirk
 */
public class Planting implements Serializable{
    
    private String type = "";
    private float pricePerTon = 0.00f;
    private int growthTime = 0;
    private boolean isGrowing = false;
    private int preferredSoilMoistureLevel = 0;
    private int preferredSoilTemperatureLevel = 0;
    private int preferredSoilAcidityLevel = 0;
    private int preferredAirTemperatureLevel = 0;
    private int light = 0;
    public boolean isOrdered = false;
    
    //Empty constructor creates a planting with type empty for creation of new fields or after harvesting
    public Planting()
    {
        this.type = "Empty";
    }
    
    //Constructor for creating a planting with only a type and price
    public Planting( String type, float pricePerTon){
        this.type = type; 
        this.pricePerTon = pricePerTon; 
    }
    
    //Standard constructor requiring all fields
    public Planting(String type, 
            float pricePerTon, 
            int growthTime, 
            int preferredSoilMoistureLevel, 
            int preferredSoilTemperatureLevel, 
            int preferredSoilAcidityLevel, 
            int preferredAirTemperatureLevel)
    {
        this.type = type; 
        this.pricePerTon = pricePerTon; 
        this.growthTime = growthTime; 
        this.isGrowing = isGrowing;
        this.preferredSoilMoistureLevel = preferredSoilMoistureLevel;
        this.preferredSoilTemperatureLevel = preferredSoilTemperatureLevel;
        this.preferredSoilAcidityLevel = preferredSoilAcidityLevel;
        this.preferredAirTemperatureLevel = preferredAirTemperatureLevel;
    }
    
    //Returns the type
    public String getType() {
        return type;
    }

    //Returns the price
    public float getPricePerTon() {
        return pricePerTon;
    }

    //Returns the growth time
    public int getGrowthTime() {
        return growthTime;
    }

    //Returns whether the crop is growing
    public boolean isIsGrowing() {
        return isGrowing;
    }

    //Returns the preferred soil moisture
    public int getPreferredSoilMoistureLevel() {
        return preferredSoilMoistureLevel;
    }

    //Returns the preferred soil temperature
    public int getPreferredSoilTemperatureLevel() {
        return preferredSoilTemperatureLevel;
    }

    //Returns the preferred soil acidity
    public int getPreferredSoilAcidityLevel() {
        return preferredSoilAcidityLevel;
    }
    
    //Returns the preferred air temperature
    public int getPreferredAirTemperatureLevel() {
        return preferredAirTemperatureLevel;
    }

     public int getLight() {
        return light;
    }
    
     //Sets the preferred air temperature
    public void setPreferredAirTemperatureLevel(int preferredAirTemperatureLevel) {
        this.preferredAirTemperatureLevel = preferredAirTemperatureLevel;
    }

    public void setLight(int light) {
        this.light = light;
    }
   
    //Sets the type
    public void setType(String type) {
        this.type = type;
    }

    //Sets the price
    public void setPricePerTon(float pricePerTon) {
        this.pricePerTon = pricePerTon;
    }

    //Sets the growth time
    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    //Sets isGrowing
    public void setIsGrowing(boolean isGrowing) {
        this.isGrowing = isGrowing;
    }

    //Sest the preferred soil moisture
    public void setPreferredSoilMoistureLevel(int preferredSoilMoistureLevel) {
        this.preferredSoilMoistureLevel = preferredSoilMoistureLevel;
    }

    //Sets the preferred soil temperature
    public void setPreferredSoilTemperatureLevel(int preferredSoilTemperatureLevel) {
        this.preferredSoilTemperatureLevel = preferredSoilTemperatureLevel;
    }

    //Sets the preferred soil acidity
    public void setPreferredSoilAcidityLevel(int preferredSoilAcidityLevel) {
        this.preferredSoilAcidityLevel = preferredSoilAcidityLevel;
    }
}
