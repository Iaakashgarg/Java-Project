/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.CylinderInfoTO;
import model.to.CylinderStockTO;

/**
 *
 * @author Grapess
 */
public class CylinderStockDAO {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(CylinderStockTO data) {
        try {
            String query = "insert into cylinderstock(cylinderid,stocktype,cylinderstatus,stockdate,quantity) values(?,?,?,sysdate(),?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1,data.getCylinderID());
            stmt.setString(2,data.getStockType());
            stmt.setString(3,data.getCylinderStatus());
            stmt.setInt(4,data.getQuantity());            
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

    
    public ArrayList<CylinderStockTO> getAllRecord() {
        try {
            String query = "select stockid , cs.cylinderid , concat(CompanyName,'( ' ,TypeName,' )') as CompanyName , stocktype , cylinderstatus , quantity , stockdate from cylinderstock cs join cylinderinfo ci on cs.cylinderid = ci.cylinderid join cylindertype ct on ci.typeid = ct.typeid order by stockdate desc";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);

            ArrayList<CylinderStockTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data = new ArrayList<CylinderStockTO>();
                rs.beforeFirst();
                while (rs.next()) {
                    CylinderStockTO cit = new CylinderStockTO();
                    cit.setStockID(rs.getInt(1));
                    cit.setCylinderID(rs.getInt(2));
                    cit.setCompanyName(rs.getString(3));
                    cit.setStockType(rs.getString(4));
                    cit.setCylinderStatus(rs.getString(5));
                    cit.setQuantity(rs.getInt(6));
                    cit.setStockDate(rs.getTimestamp(7));
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
