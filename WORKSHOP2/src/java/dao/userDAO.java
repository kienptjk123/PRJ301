/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import utils.DBUtils;

/**
 
 * @author adm
 */
public class userDAO {

    public boolean createAccount(UserDTO user) {
        String sql = "INSERT INTO USERS(username, password, email) VALUES (?,?,?)";
        if (!this.checkDuplicated(user.getUsername())) {
            try {
                Connection conn = DBUtils.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getEmail());
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            } catch (SQLException e) {
                return false;
            }   
        } else {
            return false;
        }
    }

    public boolean updateUser(UserDTO user) {
        String sql = "UPDATE USERS SET password=?,email=? WHERE userID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getUserID());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteUser(int userID) {
        String sql = "DELETE FROM USERS WHERE userID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userID);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            return false;
        }
    }
     public UserDTO getUserByID(int userID) {
        String sql = "SELECT * FROM USERS WHERE userID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return (UserDTO.builder()
                        .userID(rs.getInt("userID"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .build());
            }
            else
                 return null;
        } catch (SQLException e) {
            return null;
        }
    }
    public List<UserDTO> getAllUser() {
        String sql = "SELECT * FROM USERS";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs =  statement.executeQuery();
            List<UserDTO> userss = new ArrayList<>();
            while(rs.next()){
                UserDTO user = UserDTO.builder()
                        .userID(rs.getInt("userID"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .build();
                userss.add(user);
            }
            return userss;
        } catch (SQLException e) {
            return null;
        }
    }

    public UserDTO login(String userName, String password) {
        String sql = "SELECT * FROM USERS WHERE userName = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (BCrypt.checkpw(password, storedPassword)) {
                    UserDTO user = UserDTO.builder()
                            .userID(rs.getInt("userID"))
                            .username(rs.getString("username"))
                            .password(storedPassword)
                            .email(rs.getString("email"))
                            .build();
                    return user;
                } else {
                    return null;
                }
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    private boolean checkDuplicated(String username) {
        String sql = "SELECT * FROM USERS WHERE username=?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) { // Print the stack trace for debugging
            // Print the stack trace for debugging
            return false;
        }
    }

}
