package org.example.comp1011finalexamsummer2024;

import java.util.ArrayList;

public class Customer {

    private int id;                   // Customer ID
    private String firstName;          // Customer first name
    private String lastName;           // Customer last name
    private String phone;              // Customer phone number
    private final ArrayList<String> purchasedProducts;  // List to store purchased products

    // Constructor
    public Customer(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.purchasedProducts = new ArrayList<>();  // Initialize empty product list
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<String> getPurchasedProducts() {
        return purchasedProducts;
    }

    // Method to add a product to the purchasedProducts list
    public void addPurchasedProduct(String product) {
        this.purchasedProducts.add(product);
    }

    // toString method for displaying customer details
    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + firstName + " " + lastName +
                ", Phone: " + phone + ", Purchased Products: " + purchasedProducts;
    }
}
