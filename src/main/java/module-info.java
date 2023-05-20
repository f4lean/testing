module com.example.system_testing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.system_testing to javafx.fxml;
    opens com.example.system_testing.controller to javafx.fxml;
    opens com.example.system_testing.database to javafx.fxml;
    opens com.example.system_testing.essences to javafx.fxml;
    opens com.example.system_testing.auxiliary to javafx.fxml;
    exports com.example.system_testing;
    exports com.example.system_testing.auxiliary;
    exports com.example.system_testing.controller;
    exports com.example.system_testing.database;
    exports com.example.system_testing.essences;
}