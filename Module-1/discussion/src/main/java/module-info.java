module com.rbreutzmann {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rbreutzmann to javafx.fxml;
    exports com.rbreutzmann;
}
