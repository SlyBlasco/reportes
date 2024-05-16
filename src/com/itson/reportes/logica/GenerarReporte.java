/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.reportes.logica;
import com.itson.reportes.conector.MySQLConnector;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.sql.Date;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author luism
 */


public class GenerarReporte {
    public void generarReporte(Date fechaInicial, Date fechaFinal) {
        try {
            // Establecer la conexión a la base de datos
            Connection connection = MySQLConnector.getConnection();

            // Cargar el archivo .jasper
            String reportPath = "C:\\Users\\luism\\Documents\\NetBeansProjects\\Reportes\\src\\com\\itson\\reportes\\ui\\Reporte.jasper"; // Cambia esto a la ruta correcta
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Crear un mapa de parámetros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("fechaInicial", fechaInicial);
            parametros.put("fechaFinal", fechaFinal);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);

            // Exportar el informe a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\luism\\Desktop\\reporte.pdf");

            // Mostrar el informe en un visor
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
            
            // Cerrar la conexión
            connection.close();

            System.out.println("Reporte generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
