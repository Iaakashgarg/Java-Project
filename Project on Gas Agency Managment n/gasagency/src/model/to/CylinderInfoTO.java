/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

/**
 *
 * @author Grapess
 */
public class CylinderInfoTO {
    private int cylinderID , filledQty , emptyQty;
    private float weight,price;
    private String companyName,typeID,typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getCylinderID() {
        return cylinderID;
    }

    public void setCylinderID(int cylinderID) {
        this.cylinderID = cylinderID;
    }

    public int getFilledQty() {
        return filledQty;
    }

    public void setFilledQty(int filledQty) {
        this.filledQty = filledQty;
    }

    public int getEmptyQty() {
        return emptyQty;
    }

    public void setEmptyQty(int emptyQty) {
        this.emptyQty = emptyQty;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }
    
    public String toString(){
        return companyName + " ( " + typeName + " )";
    }
}
