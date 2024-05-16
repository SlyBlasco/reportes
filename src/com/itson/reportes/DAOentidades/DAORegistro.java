/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.reportes.DAOentidades;

import com.itson.reportes.conector.MySQLConnector;
import com.itson.reportes.entidades.Registro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luism
 */
public class DAORegistro {

    public List<Registro> getAllRegistros() throws SQLException {
        List<Registro> registros = new ArrayList<>();
        String query = "SELECT * FROM registros";
        try ( Connection connection = MySQLConnector.getConnection();  Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Registro registro = new Registro(
                        resultSet.getInt("id"),
                        resultSet.getDate("fecha"),
                        resultSet.getString("estado"),
                        resultSet.getInt("idCarro")
                );
                registros.add(registro);
            }
        }
        return registros;
    }

    public Registro getRegistroById(int id) throws SQLException {
        String query = "SELECT * FROM registros WHERE id = ?";
        try ( Connection connection = MySQLConnector.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Registro(
                            resultSet.getInt("id"),
                            resultSet.getDate("fecha"),
                            resultSet.getString("estado"),
                            resultSet.getInt("idCarro")
                    );
                }
            }
        }
        return null;
    }

    public List<Registro> getRegistrosByDateRange(Date fechaInicial, Date fechaFinal) throws SQLException {
        List<Registro> registros = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConnector.getConnection();

            String query = "SELECT * FROM registros WHERE fecha BETWEEN ? AND ?";
            statement = connection.prepareStatement(query);
            statement.setDate(1, fechaInicial);
            statement.setDate(2, fechaFinal);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date fecha = resultSet.getDate("fecha");
                String estado = resultSet.getString("estado");
                int idCarro = resultSet.getInt("idCarro");
                Registro registro = new Registro(id, fecha, estado, idCarro);
                registros.add(registro);
            }
        } finally {
            // Cerrar la conexión, el statement y el resultSet
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return registros;
    }
}
