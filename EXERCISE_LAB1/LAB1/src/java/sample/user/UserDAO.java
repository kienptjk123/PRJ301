/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

public class UserDAO {
    private static final String LOGIN="SELECT fullName, roleID FROM tblUsers WHERE userID=? AND password=? ";    
    public boolean checkLogin(String userID, String password) throws SQLException {
        boolean user= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs= ptm.executeQuery();
                if(rs.next()){
                    String fullName= rs.getString("fullName");
                    String roleID= rs.getString("roleID");
                    user = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return user;
    }

}
