package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuOpcionesController {

    @FXML
    private Button idCrfactura;

    @FXML
    private Button idVrVentas;

    @FXML
    private Button idOpCRUD;

    @FXML
    private Button idGeReporte;

    @FXML
    private void botonCrFactura(MouseEvent event) {
        abrirVentana("FacturaVista.fxml", "Creacion de factura");
    }

    @FXML
    private void botonVrVentas(MouseEvent event) {
        abrirVentana("RegistroVentas.fxml", "Ver Registro de Ventas");
    }

    @FXML
    private void botonOpCRUD(MouseEvent event) {
        abrirVentana("MenuCrud.fxml", "Operaciones CRUD");
    }

    @FXML
    private void botonGeReporte(MouseEvent event) {
        abrirVentana("ReportesVista.fxml", "Generacion de Reporte");
    }

    private void abrirVentana(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
