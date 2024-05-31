/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.model;

/**
 *
 * @author Sewni Nanayakkara
 */
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;// List to store products in the cart

    // Constructor to initialize the shopping cart
    public ShoppingCart() {
        products = new ArrayList<>();// Initialize the products list
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        products.add(product);// Add the given product to the list
    }

    // Method to remove a product from the cart
    public void removeProduct(Product product) {
        products.remove(product);// Remove the given product from the list
    }

    // Method to get the list of products in the cart
    public List<Product> getProducts() {
        return products;
    }

    public String getCartDetails() {
        StringBuilder details = new StringBuilder();
        for (Product product : products) {
            details.append(product.toString()).append("\n");
        }
        return details.toString();
    }

}

