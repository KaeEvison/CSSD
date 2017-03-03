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
    
    public SetOfFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
    
    public void addField(Field field) {
        fields.add(field);
    }
    
    public void removeField(int index) {
        fields.remove(index);
    }
    
    public Field getFieldByIndex(int index) {
        return fields.get(index);
    }
    
    public int size()
    {
        return fields.size();
    }
}
