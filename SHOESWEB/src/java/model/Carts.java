/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thuy Tran
 */
public class Carts {

    private HashMap<Integer, Items> cartItems;

    public Carts() {
        cartItems = new HashMap<>();
    }

    public Carts(HashMap<Integer, Items> cartItems) {
        this.cartItems = cartItems;
    }

    public HashMap<Integer, Items> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Integer, Items> cartItems) {
        this.cartItems = cartItems;
    }

    // insert to cart
    public void plusToCart(Integer key, Items item) {
        boolean check = cartItems.containsKey(key);
        //boolean check2 = cartItems.containsKey(item.getSize());
        if (check) {
            int quantity_old = item.getQuantity();           
            item.setQuantity(quantity_old + 1);            
            cartItems.put(key, item);
        } else {
            cartItems.put(key, item);
        }
    }

    // sub to cart
    public void subToCart(Integer key, Items item) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();            
            if (quantity_old <= 1) {
                cartItems.remove(key);
            } else {
                item.setQuantity(quantity_old - 1);               
                cartItems.put(key, item);
            }
        }
    }

    // remove to cart
    public void removeToCart(Integer key) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            cartItems.remove(key);
        }
    }

    // count item
    public int countItem() {
        return cartItems.size();
    }

    // sum total 
    public double totalCart() {
        double count = 0;
        // count = price * quantity
        for (Map.Entry<Integer, Items> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getDonGia()* list.getValue().getQuantity();
        }
        return count;
    }
}
