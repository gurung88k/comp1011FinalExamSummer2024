module org.example.comp1011finalexamsummer2024 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens org.example.comp1011finalexamsummer2024 to javafx.fxml;
    exports org.example.comp1011finalexamsummer2024;
}