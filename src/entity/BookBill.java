/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author phuon
 */
public class BookBill implements Serializable{
    
    private String titlePrintBill;
    private float total;
    private float price;
    private int quantityBill;

    public BookBill(String titlePrintBill, float total, float price, int quantityBill) {
        this.titlePrintBill = titlePrintBill;
        this.total = total;
        this.price = price;
        this.quantityBill = quantityBill;
    }
    public BookBill(){
        
    }

    public String getTitlePrintBill() {
        return titlePrintBill;
    }

    public void setTitlePrintBill(String titlePrintBill) {
        this.titlePrintBill = titlePrintBill;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantityBill() {
        return quantityBill;
    }

    public void setQuantityBill(int quantityBill) {
        this.quantityBill = quantityBill;
    }
    
    
    
    
    
    
}
