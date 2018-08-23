/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

import java.sql.Timestamp;

/**
 *
 * @author Grapess
 */
public class BillInfoTO {
    private int billID,customerID , quantity,cylinderID;

    public int getCylinderID() {
        return cylinderID;
    }

    public void setCylinderID(int cylinderID) {
        this.cylinderID = cylinderID;
    }
    private float price;
    private String  cylinderNo , companyName , customerName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    private Timestamp billDate;

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

  

    public String getCylinderNo() {
        return cylinderNo;
    }

    public void setCylinderNo(String cylinderNo) {
        this.cylinderNo = cylinderNo;
    }

    public Timestamp getBillDate() {
        return billDate;
    }

    public void setBillDate(Timestamp billDate) {
        this.billDate = billDate;
    }
}
