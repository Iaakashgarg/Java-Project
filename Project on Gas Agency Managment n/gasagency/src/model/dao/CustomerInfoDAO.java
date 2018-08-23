/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.CustomerInfoTO;
import model.to.LoginInfoTO;

/**
 *
 * @author Grapess
 */
public class CustomerInfoDAO {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(CustomerInfoTO data) {
        try {
            String query = "insert into customerinfo(CustomerName,ColonyName,Address,ContactNo,NoOfCylinder,TypeID) values(?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getCustomerName());
            stmt.setString(2, data.getColonyName());
            stmt.setString(3,data.getAddress());
            stmt.setString(4,data.getContactNo());
            stmt.setInt(5,data.getNoOfCylinder());
            stmt.setString(6,data.getTypeID());
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

    public boolean updateRecord(CustomerInfoTO data) {
        try {
            String query = "update customerinfo set CustomerName=?,ColonyName=?,Address=?,ContactNo=?,NoOfCylinder=?,TypeID=? where CustomerID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getCustomerName());
            stmt.setString(2, data.getColonyName());
            stmt.setString(3,data.getAddress());
            stmt.setString(4,data.getContactNo());
            stmt.setInt(5,data.getNoOfCylinder());
            stmt.setString(6,data.getTypeID());
            stmt.setInt(7,data.getCustomerID());
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

    public boolean deleteRecord(int customerid) {
        try {
            String query = "delete from customerinfo where customerid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1,customerid);
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

    public ArrayList<CustomerInfoTO> getAllRecord() {
        try {
            String query = "select customerid,customername,colonyname,address,contactno,noofcylinder,ci.typeid,typename from customerinfo ci join cylindertype ct on ci.typeid=ct.typeid";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);

            ArrayList<CustomerInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data = new ArrayList<CustomerInfoTO>();
                rs.beforeFirst();
                while (rs.next()) {
                    CustomerInfoTO cit = new CustomerInfoTO();
                    cit.setCustomerID(rs.getInt(1));
                    cit.setCustomerName(rs.getString(2));
                    cit.setColonyName(rs.getString(3));
                    cit.setAddress(rs.getString(4));
                    cit.setContactNo(rs.getString(5));
                    cit.setNoOfCylinder(rs.getInt(6));
                    cit.setTypeID(rs.getString(7));
                    cit.setTypeName(rs.getString(8));
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
}
