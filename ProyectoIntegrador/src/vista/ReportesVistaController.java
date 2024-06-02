package vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportesVistaController {

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private Button buttonGenerarReporte;

    private Connection connect() {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "tornillitos2";
        String password = "tornillitos2";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conn;
    }

    @FXML
    void generarReporte(MouseEvent event) {
        generarReporteComisiones();
        generarReporteVentasVendedor();
        generarReporteVentasProducto();
        generarReporteImpuestosPagados();
        generarReporteTendenciaVentas();
    }

    private void generarReporteComisiones() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        String sql = "SELECT vendedor, SUM(comision) AS total_comision FROM ventas GROUP BY vendedor";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                pieChartData.add(new PieChart.Data(rs.getString("vendedor"), rs.getDouble("total_comision")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        pieChart.setData(pieChartData);
    }

    private void generarReporteVentasVendedor() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        String sql = "SELECT vendedor, SUM(total_venta) AS total_venta FROM ventas GROUP BY vendedor";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString("vendedor"), rs.getDouble("total_venta")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        barChart.getData().add(series);
    }

    private void generarReporteVentasProducto() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        String sql = "SELECT producto, SUM(cantidad) AS total_ventas FROM ventas GROUP BY producto";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString("producto"), rs.getDouble("total_ventas")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        barChart.getData().add(series);
    }

    private void generarReporteImpuestosPagados() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        String sql = "SELECT fecha, SUM(impuesto) AS total_impuesto FROM ventas GROUP BY fecha";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString("fecha"), rs.getDouble("total_impuesto")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        lineChart.getData().add(series);
    }

    private void generarReporteTendenciaVentas() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        String sql = "SELECT TO_CHAR(fecha, 'YYYY-MM') AS mes, SUM(total_venta) AS total_venta FROM ventas GROUP BY TO_CHAR(fecha, 'YYYY-MM')";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString("mes"), rs.getDouble("total_venta")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        lineChart.getData().add(series);
    }
}
