/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.CylinderInfoTO;
import model.to.LoginInfoTO;

/**
 *
 * @author Grapess
 */
public class CylinderInfoDAO {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(CylinderInfoTO data) {
        try {
            String query = "insert into cylinderinfo(companyname,filledqty,typeid,emptyqty,weight,price) values(?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,data.getCompanyName());
            stmt.setInt(2,data.getFilledQty());
            stmt.setString(3,data.getTypeID());
            stmt.setInt(4,data.getEmptyQty());
            stmt.setFloat(5, data.getWeight());
            stmt.setFloat(6,data.getPrice());
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

    public boolean updateRecord(CylinderInfoTO data) {
        try {
            String query = "update cylinderinfo set companyname=?,typeid=?,weight=?,price=? where cylinderid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,data.getCompanyName());
            stmt.setString(2,data.getTypeID());            
            stmt.setFloat(3, data.getWeight());
            stmt.setFloat(4,data.getPrice());
            stmt.setInt(5,data.getCylinderID());
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

    public boolean deleteRecord(int cylinderid) {
        try {
            String query = "delete from cylinderinfo where cylinderid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, cylinderid);
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

    public boolean updateInFilledQuantity(int cylinderid,int fillQty) {
        try {
            String query = "update cylinderinfo set FilledQty = FilledQty + ? where cylinderid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, fillQty);
            stmt.setInt(2, cylinderid);
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
    public boolean updateInEmptyQuantity(int cylinderid,int emptyQty) {
        try {
            String query = "update cylinderinfo set emptyQty = emptyQty + ? where cylinderid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, emptyQty);
            stmt.setInt(2, cylinderid);
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
    public ArrayList<CylinderInfoTO> getAllRecord() {
        try {
            String query = "select cylinderid , companyname , filledqty , ci.typeid , price , emptyqty ,  weight , ct.typename from cylinderinfo ci join cylindertype ct on ci.typeid = ct.typeid ";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);

            ArrayList<CylinderInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data = new ArrayList<CylinderInfoTO>();
                rs.beforeFirst();
                while (rs.next()) {
                    CylinderInfoTO cit = new CylinderInfoTO();
                    cit.setCylinderID(rs.getInt(1));
                    cit.setCompanyName(rs.getString(2));
                    cit.setFilledQty(rs.getInt(3));
                    cit.setTypeID(rs.getString(4));
                    cit.setPrice(rs.getFloat(5));
                    cit.setEmptyQty(rs.getInt(6));
                    cit.setWeight(rs.getFloat(7));
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
    
    public ArrayList<CylinderInfoTO> getAllRecord(String typeid) {
        try {
            String query = "select cylinderid , companyname , filledqty , ci.typeid , price , emptyqty ,  weight , ct.typename from cylinderinfo ci join cylindertype ct on ci.typeid = ct.typeid where ci.typeid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,typeid);
            ArrayList<CylinderInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data = new ArrayList<CylinderInfoTO>();
                rs.beforeFirst();
                while (rs.next()) {
                    CylinderInfoTO cit = new CylinderInfoTO();
                    cit.setCylinderID(rs.getInt(1));
                    cit.setCompanyName(rs.getString(2));
                    cit.setFilledQty(rs.getInt(3));
                    cit.setTypeID(rs.getString(4));
                    cit.setPrice(rs.getFloat(5));
                    cit.setEmptyQty(rs.getInt(6));
                    cit.setWeight(rs.getFloat(7));
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
