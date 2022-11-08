/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BookDAO {
    

    private String pathStr = "Data\\Private";
    private String fileNameByte = "bookData_Byte.dat";
    private String fileNameChar = "bookData_Char.txt";

    public BookDAO(String pathStr, String fileNameByte, String fileNameChar) {
        this.pathStr = pathStr;
        this.fileNameByte = fileNameByte;
        this.fileNameChar = fileNameChar;
    }

    public BookDAO() {
        this.pathStr = "Data\\Private";
        this.fileNameByte = "bookData_Byte.dat";
        this.fileNameChar = "bookData_Char.txt";
    }

    public void createFolder() {
        File folder = new File(pathStr);

        if (folder.exists()) {
            System.out.println("Folder exists");
        } else {
            System.out.println("Folder not exits");
            folder.mkdirs();
            System.out.println("Folder Created");
        }
    }

    public void saveListBookAsByte(ArrayList<Book> listBook) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(pathStr + "\\" + fileNameByte);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(listBook);
            oos.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<Book> readListBookAsByte() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Book> listBook = null;

        try {
            fis = new FileInputStream(pathStr + "\\" + fileNameByte);
            ois = new ObjectInputStream(fis);

            listBook = (ArrayList<Book>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        if (listBook== null) {
            listBook = new ArrayList<>();
        }

        return listBook;

    }
    
    public void saveListBookAsChar(ArrayList<Book> listBook) {       
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(pathStr + "\\" + fileNameChar);
            bw = new BufferedWriter(fw);

            Book tempBook;
//            String line;
            for (int i = 0; i < listBook.size(); i++) {
                tempBook = listBook.get(i);

                bw.write(tempBook.getBookInfoAsString());
                bw.newLine();
            }
            bw.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
 
    }

    
}
