/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.time.LocalDateTime;
/**
 *
 * @author b3014277
 */
public class Order {
    
    String crop;
    Double cost;
    Farmer supplier;
    ProductLineManager buyer;
    LocalDateTime estimatedDeliveryDate;
    LocalDateTime dateCreated;
    String status;
    
    
}
