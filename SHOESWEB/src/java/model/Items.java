/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thuy Tran
 */
public class Items {
    private SanPham product;
    private int quantity;
    private long size;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
        
    public Items() {
    }

    public Items(SanPham product, int quantity, long size) {
        this.product = product;
        this.quantity = quantity;
        this.size = size;
    }

    public SanPham getProduct() {
        return product;
    }

    public void setProduct(SanPham product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
