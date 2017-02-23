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
public class Location implements Serializable{
    private int x = 0;
    private int y = 0;
    
    public Location(int setX, int setY){
        x = setX;
        y = setY;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int X){
        x = X;
    }
    
    public void setY(int Y){
        y = Y;
    }
    
    public String toString()
    {
        String holder = new String("");
        holder += "(";
        holder += x;
        holder += ", ";
        holder += y;
        holder += ")";
        return holder;
    }
}