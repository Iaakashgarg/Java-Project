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
public class LoginInfoDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(LoginInfoTO data) {
        try {
            String query = "insert into logininfo(username,password) values(?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getUserName());
            stmt.setString(2, data.getPassword());
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

    public boolean updateRecord(LoginInfoTO data) {
        try {
            String query = "update Logininfo set Password=? where username=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getPassword());
            stmt.setString(2, data.getUserName());
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

    public boolean deleteRecord(String username) {
        try {
            String query = "delete from logininfo where username=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, username);
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

    public ArrayList<LoginInfoTO> getAllRecord() {
        try {
            String query = "select username , password from logininfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);

            ArrayList<LoginInfoTO> data = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                data = new ArrayList<LoginInfoTO>();
                rs.beforeFirst();
                while (rs.next()) {
                    LoginInfoTO cit = new LoginInfoTO();
                    cit.setUserName(rs.getString(1));
                    cit.setPassword(rs.getString(2));
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
    
     public boolean checkUser(String username,String password) {
        try {
            String query = "select * from logininfo where username=? and password=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2,password);
            boolean ans = false;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                ans = true;
            }
            rs.close();
            stmt.close();
            return ans;
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
