/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import entity.Book;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author phuon
 */
public class BookTableModel extends AbstractTableModel {
     private String[] columnNames = {"Book ID", "Title", "Author", "Language", "Type", "Year of Release","Quantity", "Price"};
    private ArrayList<Book> listData;
    private ArrayList<Object[]> listRow = new ArrayList<>();

    public BookTableModel(ArrayList<Book> listData) {
        this.listData = listData;
        Book book;
        for (int i = 0; i < this.listData.size(); i++) {
            book = this.listData.get(i);
            Object[] row = {book.getBookID(), book.getBookTitle(), book.getBookAuthor(), book.getBookLanguage(), book.getBookType()
            , book.getBookYear(),book.getBookQuantity(), book.getBookPrice()};
            this.listRow.add(row);
        }
        
        

    }

    @Override
    public int getRowCount() {
        return this.listRow.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         return this.listRow.get(rowIndex)[columnIndex];
    }
    
    public String getColumnName(int column)
    {
        return this.columnNames[column];
    }

    public java.lang.Class getColumnClass(int column)
    {
        return this.listRow.get(0)[column].getClass();
    }

    public Object getObjectAtRow(int row)
    {
        return this.listData.get(row);
    }
    

    
}
