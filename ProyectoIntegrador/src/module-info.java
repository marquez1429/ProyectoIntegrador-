module ProyectoIntegrador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    
    opens application to javafx.fxml;
    opens vista to javafx.fxml;
    opens Datos to javafx.base;
    
    exports application;
    exports vista;
}
