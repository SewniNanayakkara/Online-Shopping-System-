/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import src.main.java.model.Product;
import src.main.java.utility.ShoppingManager;

/**
 *
 * @author Sewni Nanayakkara
 */
//
public class ProductMenuPanel {
    // Declare UI components and a reference to the shopping manager
    private JFrame frame;
    private JPanel panel;
    private JButton addButton, deleteButton, showCartButton,createOrderButton;
    private ShoppingManager shoppingManager;

    // Constructor for the ProductMenuPanel
    public ProductMenuPanel(ShoppingManager shoppingManager) {
        this.shoppingManager = shoppingManager;

        // Setup for the frame and panel
        frame = new JFrame();
        panel = new JPanel();

        // Initialize buttons for various product actions
        addButton = new JButton("Add Product");
        deleteButton = new JButton("Delete Product");
        showCartButton = new JButton("Show Cart");
        createOrderButton = new JButton("Create Order");
        // Configure panel layout and add buttons
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(showCartButton);
        panel.add(createOrderButton);
        // Add panel to the frame and set frame properties
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Online Shop");
        frame.pack();
        frame.setVisible(true);

        // Action listeners for each button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProduct();
            }

            private void deleteProduct() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        showCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCart();
            }

            private void showCart() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openShopGUI(shoppingManager);
            }
        });
    }
    
// Method to add a product    
private void addProduct() {
    // Fields for product details input
    JTextField nameField = new JTextField(5);
    JTextField priceField = new JTextField(5);
    JTextField categoryField = new JTextField(5);
    JTextField infoField = new JTextField(5);
    JTextField quantityField = new JTextField(5);
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("Name:"));
    myPanel.add(nameField);
    myPanel.add(Box.createHorizontalStrut(15)); 
    myPanel.add(new JLabel("Price:"));
    myPanel.add(priceField);
    myPanel.add(Box.createHorizontalStrut(15));
    myPanel.add(new JLabel("Category:"));
    myPanel.add(categoryField);
        myPanel.add(Box.createHorizontalStrut(15)); 
    myPanel.add(new JLabel("Info:"));
    myPanel.add(infoField);
    myPanel.add(Box.createHorizontalStrut(15)); 
        myPanel.add(new JLabel("Quantity:"));
    myPanel.add(quantityField);
    int result = JOptionPane.showConfirmDialog(null, myPanel, 
             "Please Enter Product Details", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            String category = categoryField.getText();
            Integer id = shoppingManager.calculateNextId();
            Integer quantity = Integer.parseInt(quantityField.getText());
            Product newProduct = new Product(id,name, price, category,quantity);

            shoppingManager.addProductToInventory(newProduct);
            JOptionPane.showMessageDialog(frame, "Product added successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid price format");
        }
    }
}

  
     // Method to open the shopping GUI
    private void openShopGUI(ShoppingManager shoppingManager) {
        // Create and display the ShopGUI
        ShopGUI shopGUI = new ShopGUI(shoppingManager);
        shopGUI.setVisible(true);
    }

}
