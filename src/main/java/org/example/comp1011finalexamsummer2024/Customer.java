package org.example.comp1011finalexamsummer2024;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private List<Product> purchasedProducts;

    // Constructor
    public Customer(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.purchasedProducts = new ArrayList<>();
    }

    // Method to add a purchased product to the customer's list
    public void addPurchasedProduct(Product product) {
        this.purchasedProducts.add(product);
    }

    // 4.1 Method to calculate total purchases using streams
    public double getTotalPurchases() {
        return purchasedProducts.stream()
                .mapToDouble(Product::getSalePrice)
                .sum();
    }

    // 4.2 Method to calculate total savings using streams
    public double getTotalSavings() {
        return purchasedProducts.stream()
                .mapToDouble(product -> product.getRegularPrice() - product.getSalePrice())
                .sum();
    }

    // 4.3 Method to check if the customer saved $5 or more across all purchases
    public boolean hasSavedFiveDollarsOrMore() {
        return getTotalSavings() >= 5.0;
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

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
    // 4.3 Method to check if the customer saved $5 or more on all their purchases
    public boolean hasSavedFiveDollarsOrMoreOnAll() {
        return purchasedProducts.stream()
                .allMatch(product -> (product.getRegularPrice() - product.getSalePrice()) >= 5.0);
    }

}

