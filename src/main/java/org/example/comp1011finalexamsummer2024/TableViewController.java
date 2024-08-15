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

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    // Method to initialize the TableView
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

        // Update the rowsInTableLabel dynamically
        updateRowCountLabel();

        // Add a listener to update the label if the table's items change
        tableView.getItems().addListener((ObservableList<Customer> change) -> updateRowCountLabel());
    }

    // Method to update the label with the number of rows in the table
    private void updateRowCountLabel() {
        int rowCount = tableView.getItems().size(); // Get the number of rows in the table
        rowsInTableLabel.setText("Rows in table: " + rowCount);
    }

    // Dummy method to simulate loading data
    private ObservableList<Customer> loadCustomerData() {
        // Simulate loading customer data. Replace this with actual loading from JSON or DB
        return FXCollections.observableArrayList();
    }
}
