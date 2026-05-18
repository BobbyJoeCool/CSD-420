module com.rbreutzman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.rbreutzman to javafx.fxml;
    exports com.rbreutzman;
}
