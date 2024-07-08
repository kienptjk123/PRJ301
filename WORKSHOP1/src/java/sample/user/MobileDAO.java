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
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author adm
 */
public class MobileDAO {

    private static final String SEARCH = "SELECT * FROM tbl_Mobile WHERE mobileName like ?";
    private static final String SEARCH_CART = "SELECT * FROM tbl_Mobile WHERE price BETWEEN ? AND ?";
    private static final String DELETE = "DELETE tbl_Mobile WHERE mobileId=?";
    private static final String UPDATE = "UPDATE tbl_Mobile SET description=?, price=?, quantity=?, notSale=? WHERE mobileId=?";
    private static final String INSERT = "INSERT INTO tbl_Mobile(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SEARCH_CART1 = "SELECT mobileId, description, price, mobileName, yearOfProduction, quantity, notSale FROM tbl_Mobile WHERE price BETWEEN ? AND ?";
    private static final String CHECK_DUPLICATE = "SELECT mobileId FROM tbl_Mobile WHERE mobileId=?  ";

    public List<MobileDTO> getListUser(String search) throws SQLException {
        List<MobileDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    int notSale = rs.getInt("notSale");

                    list.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<MobileDTO> getListUserPrice(double priceFrom, double priceTo) throws SQLException {
        List<MobileDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_CART);
                ptm.setDouble(1, priceFrom);
                ptm.setDouble(2, priceTo);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    int notSale = rs.getInt("notSale");

                    list.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public List<MobileDTO> getListUserPrice1(double priceFrom, double priceTo) throws SQLException {
        List<MobileDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_CART1);
                ptm.setDouble(1, priceFrom);
                ptm.setDouble(2, priceTo);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    int notSale = rs.getInt("notSale");

                    list.add(new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean delete(String mobileId) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, mobileId);
                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public boolean update(MobileDTO mobile) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, mobile.getDescription());
                ptm.setDouble(2, mobile.getPrice());
                ptm.setInt(3, mobile.getQuantity());
                ptm.setInt(4, mobile.getNotSale());
                ptm.setString(5, mobile.getMobileID());
                checkUpdate = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }

    public boolean insert(MobileDTO mobile) throws SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, mobile.getMobileID());
                ptm.setString(2, mobile.getDescription());
                ptm.setDouble(3, mobile.getPrice());
                ptm.setString(4, mobile.getMobileName());
                ptm.setInt(5, mobile.getYearOfProduction());
                ptm.setInt(6, mobile.getQuantity());
                ptm.setInt(7, mobile.getNotSale());
                checkInsert = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }

    public boolean checkDuplicate(String mobileId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, mobileId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

}
