//Krish Gurung
//200560503
package org.example.comp1011finalexamsummer2024;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerJsonReader {

    public static ArrayList<Customer> readCustomersFromJson(String filePath) {
        ArrayList<Customer> customers = new ArrayList<>();

        // Try-with-resources block to automatically close the FileReader
        try (FileReader reader = new FileReader(filePath)) {
            // Create a Gson object
            Gson gson = new Gson();

            // Parse the JSON file into an ArrayList of Customer objects
            customers = gson.fromJson(reader, new TypeToken<ArrayList<Customer>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public static void main(String[] args) {
        // Provide the path to your JSON file
        String jsonFilePath = "path_to_your_customers.json";

        // Read the customers from the JSON file
        ArrayList<Customer> customers = readCustomersFromJson(jsonFilePath);

        // Print out the list of customers
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
