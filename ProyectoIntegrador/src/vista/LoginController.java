package vista;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Datos.DatosVendedor;

public class LoginController {

    @FXML
    private Label bienvenidoid;
    @FXML
    private Button botonacceder;
    @FXML
    private TextField idusuario;
    @FXML
    private TextField idcontraseña;

    @FXML
    public void clickAcceder(MouseEvent event) {
        String usuario = idusuario.getText();
        String contrasena = idcontraseña.getText();
        DatosVendedor datosVendedor = new DatosVendedor();

        if (datosVendedor.validarVendedor(usuario, contrasena)) {
            // Cargar la siguiente ventana
            try {
                Parent root = FXMLLoader.load(getClass().getResource("facturavista.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                // Cerrar la ventana actual
                Stage currentStage = (Stage) botonacceder.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            bienvenidoid.setText("Usuario o contraseña incorrectos");
        }
    }
}