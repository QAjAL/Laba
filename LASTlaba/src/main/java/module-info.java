module com.example.lastlaba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lastlaba to javafx.fxml;
    exports com.example.lastlaba;
}