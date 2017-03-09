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
    
    public Order(){}
    
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

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Farmer getSupplier() {
        return supplier;
    }

    public void setSupplier(Farmer supplier) {
        this.supplier = supplier;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(ProductLineManager buyer) {
        this.buyer = buyer;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String toString()
    {
        String holder = "\n\nCrop: " + crop + "\nCost: " + cost + "\nSupplier: " + supplier.getFirstName() + "\nBuyer: " + buyer.getFirstName() + "\nEstimated delivery date: " + estimatedDeliveryDate + "\nDate created: " + dateCreated + "\nStatus: " + status;
        return holder;
    }
}
