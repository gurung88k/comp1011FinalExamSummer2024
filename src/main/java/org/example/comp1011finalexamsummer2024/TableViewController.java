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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    private Label rowsInTableLabel;  // Label to show rows in table

    private ObservableList<Customer> allCustomers;  // Store all customers
    @FXML
    public void initialize() {
        // Set up the columns with the corresponding getter methods from Customer class
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchases"));

        // Load customer data
        allCustomers = loadCustomerData();
        tableView.setItems(allCustomers);

        // Update the rowsInTableLabel dynamically
        updateRowCountLabel(allCustomers.size());
    }

    // Method to load the top 10 customers who have spent the most money (salePrice)
    @FXML
    public void top10Customers() {
        try {
            // Sort customers based on total purchases (sale price) in descending order and get the top 10
            List<Customer> top10Customers = allCustomers.stream()
                    .sorted(Comparator.comparingDouble(this::calculateTotalPurchases).reversed())
                    .limit(10)
                    .collect(Collectors.toList());

            // Update the tableView with the top 10 customers
            tableView.setItems(FXCollections.observableArrayList(top10Customers));

            // Update the row count label
            updateRowCountLabel(top10Customers.size());

        } catch (Exception e) {
            e.printStackTrace();  // Ensure no exceptions are triggered
        }
    }

    // Helper method to calculate the total purchases (salePrice) for a customer
    private double calculateTotalPurchases(Customer customer) {
        return customer.getPurchasedProducts().stream()
                .mapToDouble(Product::getSalePrice)
                .sum();
    }

    // Method to update the rowsInTableLabel
    private void updateRowCountLabel(int rowCount) {
        rowsInTableLabel.setText("Rows in table: " + rowCount);
    }

    // Dummy method to simulate loading data
    private ObservableList<Customer> loadCustomerData() {
        // Simulate loading customer data. Replace this with actual loading from JSON or DB
        return FXCollections.observableArrayList();
    }
}
