module org.example.heapsort {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.heapsort to javafx.fxml;
    exports org.example.heapsort;
}