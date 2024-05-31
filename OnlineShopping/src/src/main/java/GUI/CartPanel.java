/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import src.main.java.model.Product;
import src.main.java.model.ShoppingCartModel;

/**
 *
 * @author Sewni Nanayakkara
 */
public class CartPanel extends JPanel {
    // GUI components for the cart panel
    private JTable cartTable;// Table to display cart items
    private ShoppingCartModel cartTableModel;// Model for cart table
    private JLabel totalPriceLabel;// Label to display total price
    private ShopGUI shopGUI; // Reference to the main shop GUI
    private JButton removeButton;// Button to remove an item from the cart

    // Constructor for CartPanel
    public CartPanel(ShopGUI shopGUI) {
        this.shopGUI = shopGUI; // Initialize shopGUI reference
        setLayout(new BorderLayout());
        
        // Initialize and set up the remove button
        removeButton = new JButton("Remove Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedItem();
            }
            
        });
        
        // Set up the cart table model and table
        this.cartTableModel = new ShoppingCartModel(); 
        cartTable = new JTable(this.cartTableModel);
        add(removeButton, BorderLayout.NORTH);
        // Add scroll pane for the cart table
        JScrollPane scrollPane = new JScrollPane(cartTable);
        add(scrollPane, BorderLayout.CENTER);

        // Initialize and add the total price label
        totalPriceLabel = new JLabel("Total: $0.00");
        add(totalPriceLabel, BorderLayout.SOUTH);
    }

    // Method to update the cart when a product is added
    public void updateCart(Product product, int quantity) {
        cartTableModel.addProduct(product, quantity);
        updateTotalPrice();
    }
    
    // Method to remove a selected item from the cart
    private void removeSelectedItem() {
        int selectedRow = cartTable.getSelectedRow();
        if (selectedRow >= 0) {
            cartTableModel.removeProduct(selectedRow);
            updateTotalPrice(); // Update the total price after removal
        }
    }
    
    // Method to update the total price label
    private void updateTotalPrice() {
        double total = 0.0;

        // Calculate the total price of all items in the cart
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            int quantity = (Integer) cartTableModel.getValueAt(i, 1);
            double price = (Double) cartTableModel.getValueAt(i, 2);
            total += price * quantity;
        }

        // Update the total price label
        totalPriceLabel.setText(String.format("Total: Rs.%.2f", total));
    }

}