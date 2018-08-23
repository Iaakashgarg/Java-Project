/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.to.CylinderTypeTO;
import model.to.LoginInfoTO;

/**
 *
 * @author Grapess
 */
public class CylinderTypeDAO {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public boolean insertRecord(CylinderTypeTO data){
        try{
            String query = "insert into cylindertype(typeid,typename) values(?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,data.getTypeID());
            stmt.setString(2,data.getTypeName());
            boolean ans = false;
            ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean updateRecord(CylinderTypeTO data){
        try{
            String query = "update cylinderType set TypeName=? where typeid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,data.getTypeName());
            stmt.setString(2,data.getTypeID());
            boolean ans = false;
            ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public boolean deleteRecord(String typeID){
        try{
            String query = "delete from cylindertype where typeid=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,typeID);            
            boolean ans = false;
            ans = stmt.executeUpdate() > 0;
            stmt.close();
            return ans;
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
 public ArrayList<CylinderTypeTO> getAllRecord(){
        try{
            String query = "select typeid , typename from cylindertype";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            
            ArrayList<CylinderTypeTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
               data = new ArrayList<CylinderTypeTO>();
               rs.beforeFirst();
               while(rs.next()){
                   CylinderTypeTO cit = new CylinderTypeTO();
                   cit.setTypeID(rs.getString(1));
                   cit.setTypeName(rs.getString(2));
                   data.add(cit);
               }
            }
            rs.close();
            stmt.close();
            return data;
        }catch(Exception ex){
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
