/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.utility;

/**
 *
 * @author Sewni Nanayakkara
 */
import java.io.*;
import java.util.*;
import src.main.java.model.Clothing;
import src.main.java.model.Electronics;
import src.main.java.model.Product;

public class FileOperations {
  
// Method to save products to a file
public static void saveProductsToFile(List<Product> products, String filename) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        // Write the header line in the file
        writer.write("type,id,name,price,quantity,category,specificAttributes"); // Header
        writer.newLine();
        // Iterate through each product and write its details
        for (Product product : products) {
            String specificAttributes = "";
            
            // Check if the product is Electronics or Clothing and set specific attributes
            if (product instanceof Electronics) {
                // Cast to Electronics and get specific attributes
                Electronics electronics = (Electronics) product;
                specificAttributes = electronics.getWarrantyPeriod() + "," + electronics.getPowerRequirement() + "," + electronics.getModelNumber();
            } else if (product instanceof Clothing) {
                // Cast to Clothing and get specific attributes
                Clothing clothing = (Clothing) product;
                specificAttributes = clothing.getSize() + "," + clothing.getColor() + "," + clothing.getMaterial();
            }
            // Write product details to the file
            writer.write((product instanceof Electronics ? "Electronics" : "Clothing") + "," +
                         product.getId() + "," + product.getName() + "," + product.getPrice() + "," +
                         product.getQuantity() + "," + product.getCategory() + "," + specificAttributes);
            writer.newLine();
        }
    }
}
// Method to load products from a file
public static List<Product> loadProductsFromFile(String filename) throws IOException {
    List<Product> products = new ArrayList<>();
    
    // Open the file and read its contents
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        reader.readLine(); // Skip header
        System.out.println();
        // Read each line, representing a product
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            // Ensure the line has enough parts to represent a product
            if (parts.length >= 8) {
                // Parse product details
                String type = parts[0];
                Integer id = Integer.parseInt(parts[1]);
                String name = parts[2];
                double price = Double.parseDouble(parts[3]);
                Integer quantity = Integer.parseInt(parts[4]);
                String category = parts[5];
                // Create and add products to the list based on the type
                if ("Electronics".equalsIgnoreCase(type)) {
                    Integer warrantyPeriod = Integer.parseInt(parts[6]);
                    String powerRequirement = parts[7];
                    String modelNumber = parts[8];
                    products.add(new Electronics(id, name, price, quantity, category, warrantyPeriod, powerRequirement, modelNumber));
                } else if ("Clothing".equalsIgnoreCase(type)) {
                    String size = parts[6];
                    String color = parts[7];
                    String material = parts[8];
                    products.add(new Clothing(id, name, price, quantity, category, size, color, material));
                }
            }
        }
    }
    return products;// Return the list of products
}

}

