datos factura



package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DatosFactura {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "";
    private static final String PASSWORD = "";

    public LinkedList<factura> getDatos() {
        LinkedList<factura> data = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("SELECT * FROM PRODUCTO");
             ResultSet result = st.executeQuery()) {

            while (result.next()) {
                Factura factura = new factura(
                        result.getString("id"),
                        result.getString("cedulaCliente"),
                        result.getString("cedulaVendedor"),
                        result.getString("fecha"),
                        result.getString("subtotal"),
                        result.getString("iva")
                );
                data.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void guardarFactura(factura factura) {
        String sql = "INSERT INTO FACTURA (id, cedulaCliente, cedulaVendedor, fecha, subtotal, iva) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, factura.getId());
            pstmt.setString(2, factura.getCedulaCliente());
            pstmt.setString(3, factura.getCedulaVendedor());
            pstmt.setString(4, factura.getFecha());
            pstmt.setString(5, factura.getSubtotal());
            pstmt.setString(5, factura.getIva());

            pstmt.executeUpdate();
            System.out.println("Factura guardado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el factura en la base de datos: " + e.getMessage());
        }
    
    }

    public void eliminarFactura(String referencia) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("DELETE FROM FACTURA WHERE referencia = ?")) {

            st.setString(1, referencia);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(factura factura) {
        String sql = "UPDATE FACTURA SET descripcion = ?, categoria = ?, stock = ?, valor = ? WHERE referencia = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, factura.getDescripcion());
            pstmt.setString(2, factura.getCategoria());
            pstmt.setString(3, factura.getStock());
            pstmt.setString(4, factura.getValor());
            pstmt.setString(5, factura.getReferencia());
            

            pstmt.executeUpdate();
            System.out.println("Factura actualizado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto en la base de datos: " + e.getMessage());
        }
    }
}