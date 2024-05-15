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
        public void agregarRegistro(Registro registro) throws SQLException {
        String query = "INSERT INTO Registros (fecha, estado, pagado, idCarro) VALUES (?, ?, ?, ?)";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, registro.getFecha());
            preparedStatement.setString(2, registro.getEstado());
            preparedStatement.setBoolean(3, registro.isPagado());
            preparedStatement.setInt(4, registro.getIdCarro());
            preparedStatement.executeUpdate();
        }
    }

    public List<Registro> getAllRegistros() throws SQLException {
        List<Registro> registros = new ArrayList<>();
        String query = "SELECT * FROM Registros";
        try (Connection connection = MySQLConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Registro registro = new Registro(
                    resultSet.getInt("id"),
                    resultSet.getDate("fecha"),
                    resultSet.getString("estado"),
                    resultSet.getBoolean("pagado"),
                    resultSet.getInt("idCarro")
                );
                registros.add(registro);
            }
        }
        return registros;
    }

        public Registro getRegistroById(int id) throws SQLException {
        String query = "SELECT * FROM Registros WHERE id = ?";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Registro(
                        resultSet.getInt("id"),
                        resultSet.getDate("fecha"),
                        resultSet.getString("estado"),
                        resultSet.getBoolean("pagado"),
                        resultSet.getInt("idCarro")
                    );
                }
            }
        }
        return null;
    }

    public void actualizarRegistro(Registro registro) throws SQLException {
        String query = "UPDATE Registros SET fecha = ?, estado = ?, pagado = ?, idCarro = ? WHERE id = ?";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, registro.getFecha());
            preparedStatement.setString(2, registro.getEstado());
            preparedStatement.setBoolean(3, registro.isPagado());
            preparedStatement.setInt(4, registro.getIdCarro());
            preparedStatement.setInt(5, registro.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void eliminarRegistro(int id) throws SQLException {
        String query = "DELETE FROM Registros WHERE id = ?";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}

