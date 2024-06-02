package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatosProducto {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "tornillitos2";
    private static final String PASSWORD = "tornillitos2";

    public LinkedList<producto> getDatos() {
        LinkedList<producto> data = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("SELECT * FROM PRODUCTO");
             ResultSet result = st.executeQuery()) {
        
            while (result.next()) {
                producto producto = new producto(
                        result.getString("id"),
                        result.getString("nombre"),
                        result.getString("descripcion"),
                        result.getString("precio"),
                        result.getString("cantidad")
                );
                data.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void guardaProducto(producto producto) {
        String sql = "INSERT INTO PRODUCTO (id, nombre, descripcion, precio, cantidad) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getId());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getDescripcion());
            pstmt.setString(4, producto.getPrecio());
            pstmt.setString(5, producto.getCantidad());
            
            pstmt.executeUpdate();
            System.out.println("Producto guardado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el Producto en la base de datos: " + e.getMessage());
        }
    
    }

    public void eliminarProducto(String id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("DELETE FROM PRODUCTO WHERE id = ?")) {

            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(producto producto) {
        String sql = "UPDATE PRODUCTO SET nombre = ?, descripcion = ?, precio = ?, cantidad = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getId());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getDescripcion());
            pstmt.setString(4, producto.getPrecio());
            pstmt.setString(5, producto.getCantidad());

            pstmt.executeUpdate();
            System.out.println("Producto actualizado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto en la base de datos: " + e.getMessage());
        }
    }
}
