/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.model;

/**
 *
 * @author Sewni Nanayakkara
 */
public class Product {// Attributes of a product
    private Integer id;// Unique identifier for the product
    private String name;// Name of the product
    private double price;// Price of the product
    private String category;// Category to which the product belongs
    private Integer quantity;// Quantity of the product in stock
     // Constructor with parameters to initialize a product
    public Product(Integer id,String name, double price, String category,Integer quantity) {
        this.id = id;// Set the product's ID
        this.name = name;// Set the product's name
        this.price = price;// Set the product's price
        this.category = category;// Set the product's category
        this.quantity = quantity;
    }

        // Default constructor
        public Product() {
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    //Override the toString method for easy printing of product details
    @Override
    public String toString() {
        // Return a string representation of the product
        return "Product{" +          
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}

