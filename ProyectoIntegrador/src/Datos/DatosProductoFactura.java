package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatosProductoFactura {
    private static final String URL = "jdbc:oracle:thin:@localhost";
    private static final String USER = "tornillitos2";
    private static final String PASSWORD = "tornillitos2";

    public LinkedList<productoFactura> getDatos() {
        LinkedList<productoFactura> data = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("SELECT * FROM PRODUCTO_FACTURA");
             ResultSet result = st.executeQuery()) {
        
            while (result.next()) {
            	productoFactura productoFactura = new productoFactura(
                        result.getString("idProducto"),
                        result.getString("idFactura"),
                        result.getString("cantidadVendida")
                );
                data.add(productoFactura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void guardaProductoFactura(productoFactura productoFactura) {
        String sql = "INSERT INTO PRODUCTO_FACTURA (idPrducto, idFactura, cantidadVendida) VALUES ( ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productoFactura.getIdProducto());
            pstmt.setString(2, productoFactura.getIdFactura());
            pstmt.setString(2, productoFactura.getCantidadVendida());
            
            
            pstmt.executeUpdate();
            System.out.println("Los productos han sido guardado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el Producto en la base de datos: " + e.getMessage());
        }
    
    }

    public void eliminarproductoFactura(String idProducto, String idFactura) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("DELETE FROM PRODUCTO WHERE idProducto = ? and WHERE idFactura = ?")) {

            st.setString(1, idProducto);
            st.setString(2, idFactura);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(productoFactura productoFactura) {
        String sql = "UPDATE PRODUCTO_FACTURA SET cantidadVendida = ? WHERE idProducto = ? and WHERE idFactura  = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, productoFactura.getIdProducto());
            pstmt.setString(2, productoFactura.getIdFactura());
            pstmt.setString(3, productoFactura.getCantidadVendida());

            pstmt.executeUpdate();
            System.out.println("Producto actualizado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto en la base de datos: " + e.getMessage());
        }
    }
}