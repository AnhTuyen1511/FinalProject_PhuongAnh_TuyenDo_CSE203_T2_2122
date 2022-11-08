/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.*;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class Book implements Serializable {

    private ImageIcon picture;
    private String bookID;
    private String bookTitle;
    private String bookAuthor;
    private String bookLanguage;
    private String bookType;
    private int bookYear;
    private int bookQuantity;
    private float bookPrice;

    public Book(ImageIcon picture, String bookID, String bookTitle, String bookAuthor, String bookLanguage, String bookType, int bookYear, int bookQuantity, float bookPrice) {
        this.picture = picture;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookLanguage = bookLanguage;
        this.bookType = bookType;
        this.bookYear = bookYear;
        this.bookQuantity = bookQuantity;
        this.bookPrice = bookPrice;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public void setPicture(ImageIcon picture) {
        this.picture = picture;
    }

    public String getBookID() {
        return bookID;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public float payment() {
        float payment = this.bookPrice;
        int quantity = this.bookQuantity;
        payment += payment;
        quantity -= 1;
        return payment;
    }

    public String getBookInfoAsString() {
        ImageIcon picture = this.getPicture();
        String infor = this.bookID;
        infor += "\t" + this.bookTitle;
        infor += "\t" + this.bookAuthor;
        infor += "\t" + this.bookLanguage;
        infor += "\t" + this.bookType;
        infor += "\t" + this.bookYear;
        infor += "\t" + this.bookQuantity;
        infor += "\t" + this.bookPrice;
        return picture+ "\n" +infor;
    }

    public Float totalPrice(int quantity) {
        float total = bookPrice * quantity;
        return total;
    }
}
