/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.BookDAO;
import entity.Book;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BookManager {

    private ArrayList<Book> listBook;
    private BookDAO myBookDAO;

    public BookManager() {
        this.listBook = new ArrayList<>();
        this.myBookDAO = new BookDAO();
        this.myBookDAO.createFolder();
    }

    public BookManager(ArrayList<Book> listBook) {
        this.listBook = listBook;
        this.myBookDAO = new BookDAO();
        this.myBookDAO.createFolder();
    }

    public Book getBookbyId(String id) {
        Book tempBook;
        for (int i = 0; i < listBook.size(); i++) {
            tempBook = listBook.get(i);
            if (tempBook.getBookID().equalsIgnoreCase(id)) {
                return tempBook;
            }
        }
        return null;
    }
    public boolean addBook(Book book){
        boolean result =true;
        String id = book.getBookID();
        if(this.getBookbyId(id)==null){
            this.listBook.add(book);
        }else{
            result= false;
        }
        return result;
    }
    public boolean deleteBookById(String id){
        boolean result =true;
        Book tempBook = this.getBookbyId(id);
        if(tempBook!= null){
            this.listBook.remove(tempBook);
        }else{
            result = false;
        }
        return result;
    }
    public ArrayList<Book> getListBook(){
        return this.listBook;
    }
    public ArrayList<Book> getListBookByID(String id){
        ArrayList<Book> resultBookList = new ArrayList<>();
        Book tempBook;
        for(int i = 0; i < listBook.size();i++){
            tempBook= listBook.get(i);
            if(tempBook.getBookID().toLowerCase().startsWith(id)){
                resultBookList.add(tempBook);
            }
                
        }
        return resultBookList;
    }
    public ArrayList<Book> getListBookByTitle(String title){
        ArrayList<Book> resultBookList = new ArrayList<>();
        Book tempBook;
        for(int i = 0; i < listBook.size();i++){
            tempBook= listBook.get(i);
            if(tempBook.getBookTitle().toLowerCase().startsWith(title)){
                resultBookList.add(tempBook);
            }
                
        }
        return resultBookList;
    }
    public ArrayList<Book> getListBookByAuthor(String author){
        ArrayList<Book> resultBookList = new ArrayList<>();
        Book tempBook;
        for(int i = 0; i < listBook.size();i++){
            tempBook= listBook.get(i);
            if(tempBook.getBookAuthor().toLowerCase().startsWith(author)){
                resultBookList.add(tempBook);
            }
                
        }
        return resultBookList;
    }
    public ArrayList<Book> getListBookByType(String type){
        ArrayList<Book> resultBookList = new ArrayList<>();
        Book tempBook;
        for(int i = 0; i < listBook.size();i++){
            tempBook= listBook.get(i);
            if(tempBook.getBookType().toLowerCase().startsWith(type)){
                resultBookList.add(tempBook);
            }
                
        }
        return resultBookList;
    }
    public ArrayList<Book> updateQuantity (String id ,int quantity){
         ArrayList<Book> resultBookList = new ArrayList<>();
        Book tempBook = this.getBookbyId(id) ;
        if(tempBook != null){
            tempBook.setBookQuantity(quantity);
            resultBookList.add(tempBook);
        }
        return resultBookList;
            
    }
    
    public ArrayList<Book> getListBookByLanguage(String language){
        ArrayList<Book> resultBookList = new ArrayList<>();
        Book tempBook;
        for(int i = 0; i < listBook.size();i++){
            tempBook= listBook.get(i);
            if(tempBook.getBookLanguage().toLowerCase().startsWith(language)){
                resultBookList.add(tempBook);
            }
                
        }
        return resultBookList;
    }
   public ArrayList<Book> getListByPrice( float price){
        ArrayList<Book> resultBookList = new ArrayList<>();
        Book tempBook;
        for(int i = 0; i<listBook.size();i++){
            tempBook = listBook.get(i);
            if(tempBook.getBookPrice()== price){
                 resultBookList.add(tempBook);
            }               
        }
        return resultBookList;
   }

       
       
  
    public boolean updateBook(Book editedBook){
        boolean result =false;
        Book oldBook= this.getBookbyId(editedBook.getBookID());
        if(oldBook != null){
            int i=listBook.indexOf(oldBook);
            this.listBook.remove(i);
            this.listBook.add(i, editedBook);
            result=true;
        }
        return result;
    }
    
    public int saveByteData() {

        this.myBookDAO.saveListBookAsByte(listBook);
        return this.listBook.size();
    }

    public int saveCharData() {

        this.myBookDAO.saveListBookAsChar(listBook);
        return this.listBook.size();
    }

    public int getByteData() {

        this.listBook = this.myBookDAO.readListBookAsByte();
        return this.listBook.size();

    }
}
