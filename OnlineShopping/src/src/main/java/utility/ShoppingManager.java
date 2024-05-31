/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.utility;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.main.java.model.Product;
import src.main.java.model.ShoppingCart;

/**
 *
 * @author Sewni Nanayakkara
 */
public class ShoppingManager implements ShoppingManagerInt {

    private List<Product> inventory;// List to store the inventory of products
    private String filename;// Filename where the inventory is stored

    // Constructor: Initializes the manager with products loaded from a file
    public ShoppingManager(String filename) throws IOException {
        this.filename = filename;// Set the filename
        this.inventory = FileOperations.loadProductsFromFile(filename);// Load products from file
    }


    // Method to ensure the existence of the inventory file
    @Override
    public void ensureFileExists() {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException ex) {
                Logger.getLogger(ShoppingManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Method to add a product to the inventory and save it to the file
    @Override
    public void addProductToInventory(Product product) {
        inventory.add(product);// Add product to inventory list
        try {
            FileOperations.saveProductsToFile(inventory, filename);// Save updated inventory to file
        } catch (IOException ex) {
            Logger.getLogger(ShoppingManager.class.getName()).log(Level.SEVERE, null, ex);// Log exception
        }
    }

    // Method to retrieve all products from the inventory file
    @Override
    public List<Product> getAllProducts() {
        try {
            return FileOperations.loadProductsFromFile(filename);// Load and return products from file
        } catch (IOException ex) {
            Logger.getLogger(ShoppingManager.class.getName()).log(Level.SEVERE, null, ex);// Log exception
            return null;
        }

    }

    // Method to calculate the next available ID for a new product
    @Override
    public int calculateNextId() {
        int maxId = 0;
        for (Product product : inventory) {// Find the highest existing ID
            int productId = product.getId();
            if (productId > maxId) {
                maxId = productId;
            }
        }
        return maxId + 1;// Return next ID (maxId + 1)
    }
}
