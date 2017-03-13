/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 *
 * @author b3014277
 */
public class Order implements Serializable {
    
    private String crop;
    private double cost;
    private Farmer supplier;
    private User buyer;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime dateCreated;
    private String status;
    
    //empty constructor allows for easy access to an empty order
    public Order(){}
    
    //Standard constructor, requires all fields
    public Order(
            String crop,
            double cost,
            Farmer supplier,
            User buyer,
            LocalDateTime estimatedDeliveryDate,
            LocalDateTime dateCreated,
            String status )
    {
        this.crop = crop;
        this.cost = cost;
        this.supplier = supplier;
        this.buyer = buyer;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    //Returns the current crop
    public String getCrop() {
        return crop;
    }

    //Sets the current crop
    public void setCrop(String crop) {
        this.crop = crop;
    }

    //Returns the cost
    public double getCost() {
        return cost;
    }

    //Sets the cost
    public void setCost(Double cost) {
        this.cost = cost;
    }

    //Returns the supplier
    public Farmer getSupplier() {
        return supplier;
    }

    //Sets the supplier
    public void setSupplier(Farmer supplier) {
        this.supplier = supplier;
    }

    //Returns the buyer
    public User getBuyer() {
        return buyer;
    }

    //Sets the buyer
    public void setBuyer(ProductLineManager buyer) {
        this.buyer = buyer;
    }

    //Returns the estimated delivery time
    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    //Sets the estimated delivery time
    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    //Returns the creation date
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    //Sets the creation date
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    //Returns the status
    public String getStatus() {
        return status;
    }

    //Sets the status
    public void setStatus(String status) {
        this.status = status;
    }
    
    //Overrides the default toString for easier reading
    public String toString()
    {
        String holder = "\n\nCrop: " + crop + "\nCost: " + cost + "\nSupplier: " + supplier.getFirstName() + "\nBuyer: " + buyer.getFirstName() + "\nEstimated delivery date: " + estimatedDeliveryDate + "\nDate created: " + dateCreated + "\nStatus: " + status;
        return holder;
    }
}
