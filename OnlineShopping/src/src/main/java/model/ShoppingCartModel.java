package src.main.java.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ShoppingCartModel extends AbstractTableModel {
    private List<Product> products;// List to store products in the cart
    private List<Integer> quantities;// List to store quantities of each product
    private final String[] columnNames = {"Product Name", "Quantity", "Price"};// Column names for table

    // Constructor for ShoppingCartModel
    public ShoppingCartModel() {
        this.products = new ArrayList<>();// Initialize the products list
        this.quantities = new ArrayList<>();// Initialize the quantities list
    }

    // Method to add a product to the cart
    public void addProduct(Product product, int quantity) {
        if (product == null) {
            return;// Check for null product
        }

        // Check if the product is already in the cart
        int index = findProductIndex(product);
        if (index >= 0) {
            // Product is already in the cart, update its quantity
            quantities.set(index, quantities.get(index) + quantity);
        } else {
            // New product, add it to the cart
            products.add(product);
            quantities.add(quantity);
        }
        fireTableDataChanged(); // Notify the table that the data has changed
    }
      private int findProductIndex(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
                return i;
            }
        }
        return -1; // Product not found
    }

     public void removeProduct(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < products.size()) {
            products.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Return the length of the columnNames array
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Return the name of the specified column
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0: return product.getName();
            case 1: return quantities.get(rowIndex);
            case 2: return product.getPrice() * quantities.get(rowIndex);
            default: return null;
        }
    }
}
