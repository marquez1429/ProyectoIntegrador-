module ProyectoIntegrador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens application to javafx.fxml;
    opens vista to javafx.fxml;
    exports application;
    exports vista;
}