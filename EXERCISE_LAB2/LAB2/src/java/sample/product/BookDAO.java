/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

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
public class BookDAO {
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
        private static final String SHOW="SELECT SKU, Name, Price, Description, Quantity FROM tblBooks WHERE Name LIKE ?";

    public List<BookDTO> getListBook(String search) throws SQLException {
        List<BookDTO> books = new ArrayList<>();

        try {
            Connection conn = DBUtils.getConnection();
            if(conn != null) {
                PreparedStatement ptm = conn.prepareStatement(SHOW);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while(rs.next()) {
                    String SKU = rs.getString("SKU");
                    String Name = rs.getString("Name");
                    double Price = rs.getDouble("Price");
                    String Description = rs.getString("Description");
                    int Quantity = rs.getInt("Quantity");
                    books.add(new BookDTO(SKU, Name, Price, Description, Quantity));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
                return books;
    }
}
        

