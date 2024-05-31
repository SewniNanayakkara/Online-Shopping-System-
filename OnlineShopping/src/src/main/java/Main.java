/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.main.java.GUI.ProductMenuPanel;
import src.main.java.GUI.ShopGUI;
import src.main.java.utility.ShoppingManager;
import src.main.java.utility.WestminsterShoppingManager;

/**
 *
 * @author Sewni Nanayakkara
 */
public class Main {
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread to create and show the application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                String filename = "product.txt"; // Correct the filename if needed
                WestminsterShoppingManager manager = new WestminsterShoppingManager();
                try {
                    manager.startup(); // Display the console-based menu
                    
                    // If you need to launch a GUI after the console interaction, you can do it here
                    // ShopGUI shopGUI = new ShopGUI(manager);
                    // shopGUI.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
