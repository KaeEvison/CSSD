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
public class Location {
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
}