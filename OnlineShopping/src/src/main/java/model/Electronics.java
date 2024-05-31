/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.model;

/**
 *
 * @author Sewni Nanayakkara
 */
public class Electronics extends Product {
    // Attributes specific to electronic products
    private Integer warrantyPeriod;// Warranty period in years
    private String powerRequirement;// Power requirements (e.g., voltage, wattage)
    private String modelNumber;// Model number of the electronic product

    // Constructor for Electronics class
    public Electronics(Integer Id,String name, double price,Integer quantity, String category, Integer warrantyPeriod, String powerRequirement, String modelNumber) {
        super(Id,name, price, category,quantity);// Call to superclass (Product) constructor
        this.warrantyPeriod = warrantyPeriod;// Initialize warranty period
        this.powerRequirement = powerRequirement;// Initialize power requirement
        this.modelNumber = modelNumber;// Initialize model number
    }

    // Getter and setter methods for warrantyPeriod, powerRequirement, and modelNumber
    public Integer getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getPowerRequirement() {
        return powerRequirement;
    }

    public void setPowerRequirement(String powerRequirement) {
        this.powerRequirement = powerRequirement;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    // Override the toString method for displaying electronic product details
    @Override
    public String toString() {
        return "Electronics{" +
                "warrantyPeriod='" + warrantyPeriod + '\'' +
                ", powerRequirement='" + powerRequirement + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", " + super.toString() +// Include superclass (Product) attributes
                '}';
    }
}

