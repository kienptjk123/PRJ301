/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.util.HashMap;
import java.util.Map;
import sample.user.MobileDTO;

/**
 *
 * @author adm
 */
public class ListDTO {

    private Map<String, MobileDTO> cart;

    public ListDTO() {
    }

    public ListDTO(Map<String, MobileDTO> cart) {
        this.cart = cart;
    }

    public Map<String, MobileDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, MobileDTO> cart) {
        this.cart = cart;
    }

    public boolean add(MobileDTO product) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            this.cart.put(product.getMobileID(), product);
            
            check = true;
        } catch (Exception e) {
        }

        return check;
    }
    
    public boolean remove(String id) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

}
