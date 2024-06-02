package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatosCliente {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "tornillitos2";
    private static final String PASSWORD = "tornillitos2";

    public LinkedList<cliente> getDatos() {
        LinkedList<cliente> data = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("SELECT * FROM CLIENTE");
             ResultSet result = st.executeQuery()) {
        
            while (result.next()) {
                cliente cliente = new cliente(
                        result.getString("cedula"),
                        result.getString("nombre"),
                        result.getString("apellido"),
                        result.getString("email"),
                        result.getString("direccion")
                );
                data.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void guardaCliente(cliente cliente) {
        String sql = "INSERT INTO CLIENTE (cedula, nombre, apellido, email, direccion) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getCedula());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getApellido());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getDireccion());
            
            pstmt.executeUpdate();
            System.out.println("Cliente guardado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente en la base de datos: " + e.getMessage());
        }
    
    }

    public void eliminarCliente(String cedula) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("DELETE FROM CLIENTE WHERE cedula = ?")) {

            st.setString(1, cedula);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCliente(cliente cliente) {
        String sql = "UPDATE CLIENTE SET nombre = ?, apellido = ?, email = ?, direccion = ? WHERE cedula = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setString(5, cliente.getCedula());

            pstmt.executeUpdate();
            System.out.println("Cliente actualizado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente en la base de datos: " + e.getMessage());
        }
    }
}
