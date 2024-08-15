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
        allCustomers = loadCustomerData();
        tableView.setItems(allCustomers);

        // Update the rowsInTableLabel dynamically
        updateRowCountLabel(allCustomers.size());
    }

    // Method to filter customers who saved $5.00 or more
    @FXML
    public void customersSavedOver5() {
        try {
            ObservableList<Customer> filteredCustomers = FXCollections.observableArrayList();

            // Filter customers
            for (Customer customer : allCustomers) {
                if (customer.hasSavedFiveDollarsOrMore()) {
                    filteredCustomers.add(customer);
                }
            }

            // Update the tableView with filtered customers
            tableView.setItems(filteredCustomers);

            // Update the row count label
            updateRowCountLabel(filteredCustomers.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
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
