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
 * @author b4027320
 */
public class SetOfFields implements Serializable{
    ArrayList<Field> fields;
    
    //Constructor creates a list of fields using a passed array
    public SetOfFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
    
    //Adds a field to the list
    public void addField(Field field) {
        fields.add(field);
    }
    
    //Removes a field from the list
    public void removeField(int index) {
        fields.remove(index);
    }
    
    //Gets a field from the list
    public Field getFieldByIndex(int index) {
        return fields.get(index);
    }
    
    //Returns the list's length
    public int size()
    {
        return fields.size();
    }
}
