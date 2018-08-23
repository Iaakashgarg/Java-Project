/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

/**
 *
 * @author Grapess
 */
public class CylinderTypeTO {
    private String typeID , typeName;

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public String toString(){
        return typeName + " [ " + typeID + " ]";
    }
}
