/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.model;

/**
 *
 * @author Sewni Nanayakkara
 */
public class Clothing extends Product {
    // Additional attributes specific to clothing items
    private String size;
    private String color;
    private String material;

    // Constructor for Clothing class
    public Clothing(Integer Id,String name, double price,Integer quantity, String category,String size, String color, String material) {
        super(Id,name, price, category,quantity);// Call to superclass (Product) constructor
        this.size = size;// Set the size of the clothing
        this.color = color;// Set the color of the clothing
        this.material = material;// Set the material of the clothing
    }

    // Getter and setter methods for size, color, and material
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // Override the toString method to include additional attributes
    @Override
    public String toString() {
        // Return a string representation of the Clothing object
        return "Clothing{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", " + super.toString() +// Include superclass (Product) attributes
                '}';
    }
}

