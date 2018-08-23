/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.BillInfoTO;
import model.to.CylinderStockTO;

/**
 *
 * @author Grapess
 */
public class BillInfoDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(BillInfoTO data) {
        try {
            String query = "insert into billinfo(customerid,price,cylinderid,cylinderno,quantity,billdate) values(?,?,?,?,?,sysdate())";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, data.getCustomerID());
            stmt.setFloat(2, data.getPrice());
            stmt.setInt(3, data.getCylinderID());
            stmt.setString(4, data.getCylinderNo());
            stmt.setInt(5, data.getQuantity());
            boolean ans = false;
            ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public ArrayList<BillInfoTO> getAllRecord() {
        try {
            String query = "select billid , bi.customerid , price ,  cylinderno , quantity , billdate ,customername , ( select concat(CompanyName,' ( ',TypeName,' )') from cylinderinfo cif join cylindertype ct on cif.typeid = ct.typeid where cif.cylinderid = bi.cylinderid ) as CompanyName from billinfo bi join customerinfo ci on bi.customerid = ci.customerid order by billdate desc";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);

            ArrayList<BillInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data = new ArrayList<BillInfoTO>();
                rs.beforeFirst();
                while (rs.next()) {
                    BillInfoTO cit = new BillInfoTO();
                    cit.setBillID(rs.getInt(1));
                    cit.setCustomerID(rs.getInt(2));
                    cit.setPrice(rs.getFloat(3));
                    cit.setCylinderNo(rs.getString(4));
                    cit.setQuantity(rs.getInt(5));
                    cit.setBillDate(rs.getTimestamp(6));
                    cit.setCustomerName(rs.getString(7));
                    cit.setCompanyName(rs.getString(8));
                    data.add(cit);
                }
            }
            rs.close();
            stmt.close();
            return data;
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean deleteRecord(int billid) {
        try {
            String query = "delete from  billinfo where billid =?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, billid);
            boolean ans = false;
            ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public int getTotalCylinder(int customerid) {
        try {
            String query = "select ifnull(sum(quantity),0) from  billinfo where customerid =? and month(billdate) = month(sysdate()) and year(billdate) = year(sysdate())";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, customerid);
            int ans = 0;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                ans = rs.getInt(1);
            }
            stmt.close();
            return ans;
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
