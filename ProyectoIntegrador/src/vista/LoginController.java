package vista;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import Datos.DatosVendedor;

public class LoginController {
    @FXML
    private Label bienvenidoid;
    @FXML
    private Button botonacceder;
    @FXML
    private TextField idusuario;
    @FXML
    private TextField idcontrasena;

    @FXML
    void clickAcceder(MouseEvent event) {
        String usuario = idusuario.getText();
        String contrasena = idcontrasena.getText();
        DatosVendedor datosVendedor = new DatosVendedor();

        if (datosVendedor.validarVendedor(usuario, contrasena)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuOpciones.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) botonacceder.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error de Autenticación");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
        }
    }
}

