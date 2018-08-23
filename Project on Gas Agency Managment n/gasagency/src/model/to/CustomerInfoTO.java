/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

/**
 *
 * @author Grapess
 */
public class CustomerInfoTO {
    private int customerID , noOfCylinder;
    private String customerName,colonyName,address,contactNo,typeID,typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getNoOfCylinder() {
        return noOfCylinder;
    }

    public void setNoOfCylinder(int noOfCylinder) {
        this.noOfCylinder = noOfCylinder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getColonyName() {
        return colonyName;
    }

    public void setColonyName(String colonyName) {
        this.colonyName = colonyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }
    
    public String toString(){
        return customerName + " ( " + customerID + " )";
    }
}
