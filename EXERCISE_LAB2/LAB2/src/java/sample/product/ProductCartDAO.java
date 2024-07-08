/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author Tony
 */
public class ProductCartDAO {
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;

    public List<BookDTO> getAllByIdAndName(String description) {
        List<BookDTO> ProductCartList = new ArrayList<BookDTO>();
        BookDTO productCart;
        String sql = "SELECT * FROM tblBooks WHERE description LIKE ?;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + description + '%');
            
            rs = ps.executeQuery();
            while (rs.next()) {
                productCart = new BookDTO(
                        rs.getString("SKU"), 
                        rs.getString("Name"), 
                        rs.getFloat("Price"), 
                        rs.getString("description"),
                        rs.getInt("quantity")
                );
                    ProductCartList.add(productCart);                
            }
        } catch (Exception ex) {
        }
        
        return ProductCartList;
    }
    
 
}
