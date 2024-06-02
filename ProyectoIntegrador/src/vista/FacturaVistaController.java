package vista;

import Datos.DatosFactura;
import Datos.factura;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FacturaVistaController {

    @FXML
    private Button botonActualizar;

    @FXML
    private Button buttonCrear;

    @FXML
    private TableColumn< factura, String> idCedulaVendedor;

    @FXML
    private TableColumn<factura, String> idColum;

    @FXML
    private TableColumn<factura, String> idColumnCedulaCliente;

    @FXML
    private TableColumn<factura, String> idColumnFecha;

    @FXML
    private TableColumn<factura, String> idColumnIva;

    @FXML
    private TableColumn<factura, String> idColumnSubtotal;

    @FXML
    private TableView<factura> idTabla;

    @FXML
    private TextField textIdCedulaCliente;

    @FXML
    private TextField textIdFactura;

    @FXML
    private TextField textIdFecha;

    @FXML
    private TextField textIdSubtotal;

    @FXML
    private TextField textIdVenta;


    @FXML
    private TextField textidCedulaVendedor;
    
    private DatosFactura dataprovider = new DatosFactura();

    @FXML
    void clickActualizar(MouseEvent event) {
    	factura actualizada = new factura(textIdFactura.getText(),textIdCedulaCliente.getText(), textidCedulaVendedor.getText(),textIdFecha.getText(),textIdSubtotal.getText(), textIdVenta.getText());
    	    
    	    
    	    boolean updatefactura = this.dataprovider.actualizarFactura(actualizada);
    	    
    	    
    	    if (updatefactura) {
    	        Alert alt = new Alert(Alert.AlertType.INFORMATION);
    	        alt.setContentText("Factura Actualizada");
    	        alt.setHeaderText("Actualizado");
    	        alt.show();
    	    } else {
    	        Alert alt = new Alert(Alert.AlertType.ERROR);
    	        alt.setContentText("Error actualizando la factura");
    	        alt.setHeaderText("Error");
    	        alt.show();
    	    }
    	}
    	;


    @FXML
    void clickCrear(MouseEvent event) {
    	factura nuevo = new factura(textIdFactura.getText(), textIdCedulaCliente.getText(), textidCedulaVendedor.getText(), textIdFecha.getText(), textIdSubtotal.getText(), textIdVenta.getText());
    			
    			
    	boolean añadirfactura = this.dataprovider.guardaFactura(nuevo);
    	if (añadirfactura){
    		Alert alt = new Alert(Alert.AlertType.INFORMATION);
            alt.setContentText("Factura Añadida");
            alt.setHeaderText("Creado");
            alt.show();
    	}
    	else {
    		Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setContentText("Error añadiendo la factura");
            alt.setHeaderText("error");
            alt.show();
    	}
    
    	
    	}
   
    private Connection getConnection() {
        // Método de conexión a la base de datos
        try {
            // Ajusta la URL, el usuario y la contraseña según tu configuración
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "tornillitos2";
            String password = "tornillitos2";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

	
