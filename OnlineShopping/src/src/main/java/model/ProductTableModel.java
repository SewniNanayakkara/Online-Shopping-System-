/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sewni Nanayakkara
 */
public class ProductTableModel extends AbstractTableModel {
    private  List<Product> products;// List to hold Product objects
    private  String[] columnNames = {"Product ID", "Name", "Category", "Price", "Info"};

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }
    public void setProducts(List<Product> newProducts) {
    this.products.clear(); // Clear existing data
    this.products.addAll(newProducts); // Add new data
    fireTableDataChanged(); // Notify the table
}
    @Override
    public int getRowCount() {
        return products.size();// Return the number of products
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;// Return the number of columns
    }

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    // Get the product at the specified row
    Product product = products.get(rowIndex);
    switch (columnIndex) {
        case 0: return product.getId();
        case 1: return product.getName();
        case 2: return product.getCategory();
        case 3: return product.getPrice();
        default: return null;// Default case for columns without specific data
    }
}

    @Override
    public String getColumnName(int column) {
        return columnNames[column];// Return the name of the specified column
    }
    

   // Method to get a product at a specific row
        public Product getProductAt(int rowIndex) {
                            System.out.println(products.size());
        if (rowIndex >= 0 && rowIndex < products.size()) {
            return products.get(rowIndex);
        } else {
            return null; // or throw an exception if the index is out of bounds
        }
    }
}
