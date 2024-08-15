package org.example.comp1011finalexamsummer2024;
//product classs
public class Product {
    //creating instant variables
    private String sku;
    private String name;
    private double salePrice;
    private double regularPrice;
    private String imageUrl;
//creating constructor
    public Product(String sku, String name, double salePrice, double regularPrice, String imageUrl) {
        this.sku = sku;
        this.name = name;
        this.salePrice = salePrice;
        this.regularPrice = regularPrice;
        this.imageUrl = imageUrl;
    }

    //getters and setters
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // toString method to display product details in the format "[name]-$[sale price]"
    @Override
    public String toString() {
        return name + "-$" + String.format("%.2f", salePrice);  // Format salePrice to 2 decimal places
    }
}
