/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import src.main.java.GUI.ShopGUI;
import src.main.java.model.Clothing;
import src.main.java.model.Electronics;
import src.main.java.model.Product;

/**
 *
 * @author Sewni Nanayakkara
 */
/**
 * This class manages the shopping operations. It includes functions for user
 * login, product management, and displaying a GUI for different user roles.
 */
public class WestminsterShoppingManager {

    private static final int MAX_PRODUCTS = 50;
    private List<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Constructor: Initializes the shopping manager by loading products from a file.
    
    
    public WestminsterShoppingManager() {
        try {
            products = FileOperations.loadProductsFromFile("product.txt");
        } catch (IOException e) {
            System.err.println("Error loading products: " + e.getMessage());
            products = new ArrayList<>(); // Start with an empty list if loading fails
        }
    }

    // Verifies user login by checking credentials against a stored file.
    
    private String verifyLogin() {
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String role = parts[0];
                    String username = parts[1];
                    String password = parts[2];
                    if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                        return role;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user file: " + e.getMessage());
        }
        return null;
    }
    
    
    // Manages the startup process, including user login and role-based GUI display.

    public void startup() throws IOException {
        String userRole = verifyLogin();

        if (userRole != null) {
            if ("manager".equalsIgnoreCase(userRole)) {
                displayMenu();
            } else if ("customer".equalsIgnoreCase(userRole)) {
                ShoppingManager manager = new ShoppingManager("product.txt");
                ShopGUI shopGUI = new ShopGUI(manager);
                shopGUI.setVisible(true);
            }
        } else {
            System.out.println("Login failed.");
        }
    }
    
    
    // Displays the main menu for the manager with different options like add, delete, or print products.

    public void displayMenu() {
        while (true) {
            System.out.println("\n*** Westminster Shopping Manager ***");
            System.out.println("1. Add a new product");
            System.out.println("2. Delete a product");
            System.out.println("3. Print the list of products");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    printAllProducts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
    // Handles adding a new product to the product list.

    private void addNewProduct() {
        if (products.size() >= MAX_PRODUCTS) {
            System.out.println("Maximum product capacity reached.");
            return;
        }
        System.out.println("Enter product type (Electronics/Clothing):");
        String type = scanner.nextLine();

        // Gather common product information
        System.out.println("Enter product ID:");
        Integer id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter product quantity:");
        Integer quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if ("Electronics".equalsIgnoreCase(type)) {
            System.out.println("Enter warranty period (in years):");
            Integer warrantyPeriod = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter power requirement:");
            String powerRequirement = scanner.nextLine();
            System.out.println("Enter model number:");
            String modelNumber = scanner.nextLine();

            Electronics electronics = new Electronics(id, name, price, quantity, type, warrantyPeriod, powerRequirement, modelNumber);
            products.add(electronics);
        } else if ("Clothing".equalsIgnoreCase(type)) {
            System.out.println("Enter size:");
            String size = scanner.nextLine();
            System.out.println("Enter color:");
            String color = scanner.nextLine();
            System.out.println("Enter material:");
            String material = scanner.nextLine();

            Clothing clothing = new Clothing(id, name, price, quantity, type, size, color, material);
            products.add(clothing);
        }
        try {
            FileOperations.saveProductsToFile(products, "product.txt");
        } catch (IOException e) {
            System.err.println("Error saving products: " + e.getMessage());
        }
    }
    
    
    // Handles deleting a product from the product list.

    private void deleteProduct() {
        try {
            products = FileOperations.loadProductsFromFile("product.txt");
        } catch (IOException e) {
            System.err.println("Error loading products: " + e.getMessage());
            return;
        }
        System.out.println(products);
        System.out.println("Enter product ID to delete:");
        Integer id = scanner.nextInt();

        Product productToRemove = null;
        for (Product product : products) {
            if (product.getId().equals(id)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Deleted product: " + productToRemove);
            System.out.println("Total products left: " + products.size());
        } else {
            System.out.println("Product not found.");
        }
        try {
            FileOperations.saveProductsToFile(products, "product.txt");
        } catch (IOException e) {
            System.err.println("Error saving products: " + e.getMessage());
        }
    }
    
    
    // Prints all products in the product list.

    private void printAllProducts() {
        try {
            products = FileOperations.loadProductsFromFile("product.txt");
        } catch (IOException e) {
            System.err.println("Error loading products: " + e.getMessage());
            return;
        }

        Collections.sort(products, Comparator.comparing(Product::getId));
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
