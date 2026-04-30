module com.rbruetzmnann {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rbruetzmnann to javafx.fxml;
    exports com.rbruetzmnann;
}
