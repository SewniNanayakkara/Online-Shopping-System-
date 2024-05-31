/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.GUI;

/**
 *
 * @author Sewni Nanayakkara
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import src.main.java.model.Product;

public class ProductDetailsPanel extends JPanel {
    // Declare JLabels for displaying product details
    private JLabel productIdLabel;
    private JLabel categoryLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;

     // Constructor for the ProductDetailsPanel
    public ProductDetailsPanel() {
        // Set the layout of the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Initialize labels with initial text
        productIdLabel = new JLabel("Product ID: ");
        categoryLabel = new JLabel("Category: ");
        nameLabel = new JLabel("Name: ");
        quantityLabel = new JLabel("Items Available: ");

        // Add the labels to the panel
        add(productIdLabel);
        add(categoryLabel);
        add(nameLabel);
        add(quantityLabel);
    }

    // Method to set the details of the product on the labels
    public void setProductDetails(Product product) {
        // Update each label with specific product information
        productIdLabel.setText("Product ID: " + product.getId());
        categoryLabel.setText("Category: " + product.getCategory());
        nameLabel.setText("Name: " + product.getName());
        quantityLabel.setText("Items Available: " + product.getQuantity());
    }
}

