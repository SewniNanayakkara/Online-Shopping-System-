/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.utility;

import java.util.List;
import src.main.java.model.Product;
import src.main.java.model.ShoppingCart;

/**
 *
 * @author Sewni Nanayakkara
 */
public interface ShoppingManagerInt {
   void ensureFileExists();//A method to ensure the necessary file for storing product data is present.
   List<Product>  getAllProducts();//Returns a list of all products currently in the inventory.
    void addProductToInventory(Product product);//A method to add a new product to the inventory.
    int calculateNextId();//Calculates and returns the next unique identifier for a new product.
}

