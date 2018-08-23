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
public class CylinderStockTO {
    private int stockID , cylinderID , quantity;
    private String stockType , cylinderStatus,companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    private Timestamp stockDate;

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getCylinderID() {
        return cylinderID;
    }

    public void setCylinderID(int cylinderID) {
        this.cylinderID = cylinderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getCylinderStatus() {
        return cylinderStatus;
    }

    public void setCylinderStatus(String cylinderStatus) {
        this.cylinderStatus = cylinderStatus;
    }

    public Timestamp getStockDate() {
        return stockDate;
    }

    public void setStockDate(Timestamp stockDate) {
        this.stockDate = stockDate;
    }
}
