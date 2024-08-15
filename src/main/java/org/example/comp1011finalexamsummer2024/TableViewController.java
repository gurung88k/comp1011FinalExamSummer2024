package org.example.comp1011finalexamsummer2024;
//Krish Gurung
//200560503

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class TableViewController {
    @FXML
    private Label saleLabel;

    @FXML
    private Label msrpLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> totalPurchaseColumn;

    @FXML
    private ListView<Product> purchaseListView;

    @FXML
    private ImageView imageView;


    @FXML
    private void top10Customers()
    {
        System.out.println("called method top10Customers()");
    }

    @FXML
    private void customersSavedOver5()
    {
        System.out.println("called method customersSavedOver5()");
    }

    @FXML
    private void loadAllCustomers()
    {
        System.out.println("called method loadAllCustomers");
    }
    @FXML
    private Label totalPurchaseLabel;  // Label to display total purchases



    @FXML
    public void initialize() {
        // Set up the columns with the corresponding getter methods from Customer class
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchases"));

        // Load customer data
        ObservableList<Customer> customers = loadCustomerData();
        tableView.setItems(customers);

        // Add listener to the TableView to detect when a customer is selected
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updatePurchaseList(newValue);  // Update ListView when a customer is selected
                updatePriceLabels(newValue);   // Update the price labels (msrpLabel, saleLabel, savingsLabel)
            }
        });
    }

    // Method to update the ListView with the selected customer's purchases
    private void updatePurchaseList(Customer customer) {
        ObservableList<String> purchaseItems = FXCollections.observableArrayList();

        // Loop through customer's purchased products and add to list
        for (Product product : customer.getPurchasedProducts()) {
            purchaseItems.add(product.getName() + " - $" + String.format("%.2f", product.getSalePrice()));
        }

        // If there are no products, add a fake product
        if (purchaseItems.isEmpty()) {
            purchaseItems.add("Sample Product - $0.00");
        }

        purchaseListView.setItems(purchaseItems);  // Update the ListView

        // Optionally, display the total purchase amount for the customer
        totalPurchaseLabel.setText("Total purchase: " + customer.getTotalPurchases());
    }

    // Method to update the msrpLabel, saleLabel, and savingsLabel
    private void updatePriceLabels(Customer customer) {
        double totalRegularPrice = 0.0;
        double totalSalePrice = 0.0;

        // Calculate total regular price and sale price
        for (Product product : customer.getPurchasedProducts()) {
            totalRegularPrice += product.getRegularPrice();
            totalSalePrice += product.getSalePrice();
        }

        // Calculate savings
        double totalSavings = totalRegularPrice - totalSalePrice;

        // Update the labels with the calculated values
        msrpLabel.setText(String.format("Total regular price: $%.2f", totalRegularPrice));
        saleLabel.setText(String.format("Total sale price: $%.2f", totalSalePrice));
        savingsLabel.setText(String.format("Total savings: $%.2f", totalSavings));
    }

    // Dummy method to simulate loading data
    private ObservableList<Customer> loadCustomerData() {
        // Simulate loading customer data. Replace this with actual loading from JSON or DB
        return FXCollections.observableArrayList();
    }
}
