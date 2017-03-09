/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author b3014277
 */
public class SetOfOrders extends ArrayList<Order> implements Serializable
{
    void addOrder(Order newOrder)
    {
        super.add(newOrder);
    }
    void removeOrder(int index)
    {
        super.remove(this.get(index));
    }
    Order getOrderByIndex(int index)
    {
        return this.get(index);
    }
    
    public String toString()
    {
        String holder = "";
        for (int i = 0; i < this.size(); i++)
        {
            holder += this.get(i).toString();
        }
        return holder;
    }
}
