package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatosVendedor {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "tornillitos2";
    private static final String PASSWORD = "tornillitos2";
    
    public LinkedList<vendedor> getDatos() {
        LinkedList<vendedor> data = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("SELECT * FROM VENDEDOR");
             ResultSet result = st.executeQuery()) {
        	
            while (result.next()) {
            	vendedor vendedor = new vendedor(
                        result.getString("cedula"),
                        result.getString("nombre"),
                        result.getString("apellido"),
                        result.getString("email"),
                        result.getString("direccion"),
                        result.getString("comision"),
                        result.getString("usuario"),
                        result.getString("contrasena"),
                        result.getString("nivelAcceso")
                );
                data.add(vendedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void guardarVendedor(vendedor vendedor) {
        String sql = "INSERT INTO VENDEDOR (cedula, nombre, apellido, email, direccion, comision, usuario, contrasena, nivelAcesso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vendedor.getCedula());
            pstmt.setString(2, vendedor.getNombre());
            pstmt.setString(3, vendedor.getApellido());
            pstmt.setString(4, vendedor.getEmail());
            pstmt.setString(5, vendedor.getDireccion());
            pstmt.setString(6, vendedor.getComision());
            pstmt.setString(7, vendedor.getUsuario());
            pstmt.setString(8, vendedor.getContrasena());
            pstmt.setString(9, vendedor.getNivelAcceso());
            
            pstmt.executeUpdate();
            System.out.println("Vendedor guardado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el vendedor en la base de datos: " + e.getMessage());
        }
    
    }

    public void eliminarVendedor(String cedula) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = conn.prepareStatement("DELETE FROM PRODUCTO WHERE cedula = ?")) {

            st.setString(1, cedula);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarVendedor(vendedor vendedor) {
        String sql = "UPDATE CLIENTE SET nombre = ?, apellido = ?, email = ?, direccion = ?, comision = ?, usuario = ?, contrasena = ?, nivelAcceso = ? WHERE cedula = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vendedor.getCedula());
            pstmt.setString(2, vendedor.getNombre());
            pstmt.setString(3, vendedor.getApellido());
            pstmt.setString(4, vendedor.getEmail());
            pstmt.setString(5, vendedor.getDireccion());
            pstmt.setString(6, vendedor.getComision());
            pstmt.setString(7, vendedor.getUsuario());
            pstmt.setString(8, vendedor.getContrasena());
            pstmt.setString(9, vendedor.getNivelAcceso());

            pstmt.executeUpdate();
            System.out.println("Vendedor actualizado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el vendedor en la base de datos: " + e.getMessage());
        }
         
    }
    public boolean validarVendedor(String usuario, String contrasena) {
        String sql = "SELECT * FROM vendedor WHERE usuario = ? AND contraseña = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario);
            pstmt.setString(2, contrasena);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al validar el usuario en la base de datos: " + e.getMessage());
        }
        return false;
    }
}