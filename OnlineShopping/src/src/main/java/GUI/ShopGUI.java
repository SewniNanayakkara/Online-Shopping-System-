package src.main.java.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import src.main.java.model.Product;
import src.main.java.model.ProductTableModel;
import src.main.java.model.ShoppingCartModel;
import src.main.java.utility.ShoppingManager;
import java.util.List;
public class ShopGUI {
    private JFrame frame;
    private JTable productsTable;
    private JTable cartTable;
    private ProductTableModel productModel;
//    private ShoppingCart shoppingCart;
    private JLabel productDetailsLabel;
    private JComboBox<String> categoryFilter;
    private JButton addToCartButton, viewCartButton;
    private CartPanel cartPanel;
     private ShoppingManager shoppingManager;
    public ShopGUI(ShoppingManager shoppingManager) {
        this.shoppingManager = shoppingManager;
        // Initialize the main frame
        frame = new JFrame("Westminster Shopping Centre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        this.cartPanel = new CartPanel(this);
        ShoppingCartModel cartModel = new ShoppingCartModel();
        this.productModel = new ProductTableModel(new ArrayList<>());
        cartTable = new JTable(cartModel);
        viewCartButton = new JButton("View Cart");
        var products = shoppingManager.getAllProducts();
        System.out.println(products);
        // Products Table
        ProductTableModel productModel = new ProductTableModel(products); 

        // Category Filter
        categoryFilter = new JComboBox<>(new String[] {"All", "Electronics", "Clothing"});
        categoryFilter.addActionListener(e -> filterProducts());
                productsTable = new JTable(productModel);
       JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        viewCartButton = new JButton("View Cart");
        viewCartButton.setPreferredSize(new Dimension(100, 30));
        // Product Details
        productDetailsLabel = new JLabel("Select a product to see details");
        ProductDetailsPanel productDetailsPanel = new ProductDetailsPanel();
        JPanel detailsContainer = new JPanel();
        detailsContainer.setLayout(new BorderLayout());
        detailsContainer.add(productDetailsLabel, BorderLayout.NORTH);
        detailsContainer.add(productDetailsPanel, BorderLayout.CENTER);
        
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCartUI();
            }
        });
        productsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                
                if (!event.getValueIsAdjusting() && productsTable.getSelectedRow() != -1) {
                    //the table model returns a Product object for the selected row
                    Product selectedProduct = ((ProductTableModel)productsTable.getModel()).getProductAt(productsTable.getSelectedRow());
                    System.out.println(selectedProduct);
                    productDetailsPanel.setProductDetails(selectedProduct);
                }
            }
        });

        // Add to Cart Button
        addToCartButton = new JButton("Add to Shopping Cart");
        addToCartButton.addActionListener(e -> addToCart());

    // Shopping Cart Table
    JPanel southPanel = new JPanel(new BorderLayout());
    southPanel.add(detailsContainer, BorderLayout.CENTER);
    southPanel.add(addToCartButton, BorderLayout.SOUTH);

 
        // Final setup
         topPanel.add(categoryFilter);
         topPanel.add(viewCartButton);

        frame.add(topPanel, BorderLayout.NORTH);

        frame.add(new JScrollPane(productsTable), BorderLayout.CENTER);
           frame.add(southPanel, BorderLayout.SOUTH);
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    
    // Method to filter products based on category selection
private void filterProducts() {
    if (this.productModel != null) {
        String selectedCategory = (String) categoryFilter.getSelectedItem();
        List<Product> filteredProducts;

        if ("All".equals(selectedCategory)) {
            filteredProducts = shoppingManager.getAllProducts();
        } else {
            filteredProducts = shoppingManager.getAllProducts().stream()
                .filter(product -> product.getCategory().equals(selectedCategory))
                .collect(Collectors.toList());
        }

        this.productModel.setProducts(filteredProducts);
    }
}
    // Method to add a product to the shopping cart
private void addToCart() {
    int selectedRow = productsTable.getSelectedRow();
    if (selectedRow >= 0) {
        Product selectedProduct = ((ProductTableModel) productsTable.getModel()).getProductAt(selectedRow);
        cartPanel.updateCart(selectedProduct, 1); // Update cartPanel with the selected product
    }
}
private void showCartUI() {
    JFrame cartFrame = new JFrame("Shopping Cart");
    cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    cartFrame.setLayout(new BorderLayout());

    cartFrame.add(cartPanel);

    cartFrame.pack();
    cartFrame.setVisible(true);
}
  public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
