package vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class FacturaVistaController {

    @FXML
    private TableColumn<?, ?> ColumnIdFactura;

    @FXML
    private TableColumn<?, ?> ColumnIva;

    @FXML
    private TableColumn<?, ?> ColumnReferenciaProducto;

    @FXML
    private Button botonActualizar;

    @FXML
    private Button buttonCrear;

    @FXML
    private TableColumn<?, ?> cedulaclienteid;

    @FXML
    private TableColumn<?, ?> ivaid;

    @FXML
    private TableColumn<?, ?> subtotalid;

    @FXML
    private TextField textIdFactura;

    @FXML
    private TextField textIdUsuario;

    @FXML
    private TextField textIdVenta;

    @FXML
    private TextField textIva;

    @FXML
    private TextField textReferenciaProducto;

    @FXML
    private TextField textSubtotal;

    @FXML
    void clickActualizar(MouseEvent event) {

    }

    @FXML
    void clickCrear(MouseEvent event) {

    }

}