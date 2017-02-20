/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

/**
 *
 * @author trkirk
 */
public class Planting {
    
    private String type = "";
    private double pricePerTon = 0.0d;
    private int growthTime = 0;
    private boolean isGrowing = false;
    private int preferredSoilMoistureLevel = 0;
    private int preferredSoilTemperatureLevel = 0;
    private int preferredSoilAcidityLevel = 0;
    private int preferredAirTemperatureLevel = 0;
    private int light = 0;

    
    public String getType() {
        return type;
    }

    public double getPricePerTon() {
        return pricePerTon;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public boolean isIsGrowing() {
        return isGrowing;
    }

    public int getPreferredSoilMoistureLevel() {
        return preferredSoilMoistureLevel;
    }

    public int getPreferredSoilTemperatureLevel() {
        return preferredSoilTemperatureLevel;
    }

    public int getPreferredSoilAcidityLevel() {
        return preferredSoilAcidityLevel;
    }
    
    public int getPreferredAirTemperatureLevel() {
        return preferredAirTemperatureLevel;
    }

     public int getLight() {
        return light;
    }
    
    public void setPreferredAirTemperatureLevel(int preferredAirTemperatureLevel) {
        this.preferredAirTemperatureLevel = preferredAirTemperatureLevel;
    }

    public void setLight(int light) {
        this.light = light;
    }
   

    public void setType(String type) {
        this.type = type;
    }

    public void setPricePerTon(double pricePerTon) {
        this.pricePerTon = pricePerTon;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public void setIsGrowing(boolean isGrowing) {
        this.isGrowing = isGrowing;
    }

    public void setPreferredSoilMoistureLevel(int preferredSoilMoistureLevel) {
        this.preferredSoilMoistureLevel = preferredSoilMoistureLevel;
    }

    public void setPreferredSoilTemperatureLevel(int preferredSoilTemperatureLevel) {
        this.preferredSoilTemperatureLevel = preferredSoilTemperatureLevel;
    }

    public void setPreferredSoilAcidityLevel(int preferredSoilAcidityLevel) {
        this.preferredSoilAcidityLevel = preferredSoilAcidityLevel;
    }
}
