package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatosFactura {
    private static final String URL = "jdbc:oracle:thin:@localhost";
    private static final String USER = "tornillitos2";
    private static final String PASSWORD = "tornillitos2";

    public LinkedList<factura> getDatos() {
        LinkedList<factura> data = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("SELECT * FROM FACTURA");
             ResultSet result = st.executeQuery()) {
        
            while (result.next()) {
                factura factura = new factura(
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

    public void guardaFactura(factura factura) {
        String sql = "INSERT INTO FACTURA (id, cedulaCliente, cedulaVendedor, fecha, subtotal, iva) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, factura.getId());
            pstmt.setString(2, factura.getCedulaCliente());
            pstmt.setString(3, factura.getCedulaVendedor());
            pstmt.setString(4, factura.getFecha());
            pstmt.setString(5, factura.getSubtotal());
            pstmt.setString(5, factura.getIva());
            
            pstmt.executeUpdate();
            System.out.println("Factura guardada correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el Factura en la base de datos: " + e.getMessage());
        }
    
    }

    public void eliminarFactura(String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("DELETE FROM CLIENTE WHERE id = ?")) {

            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarFactura(factura factura) {
        String sql = "UPDATE FACTURA SET id = ?, cedulaCliente = ?, cedulaVendedor = ?, fecha = ?, subtotal = ?, iva = ?,  WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, factura.getId());
            pstmt.setString(2, factura.getCedulaCliente());
            pstmt.setString(3, factura.getCedulaVendedor());
            pstmt.setString(4, factura.getFecha());
            pstmt.setString(5, factura.getSubtotal());
            pstmt.setString(6, factura.getIva());

            pstmt.executeUpdate();
            System.out.println("Factura actualizada correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar la factura en la base de datos: " + e.getMessage());
        }
    }
}