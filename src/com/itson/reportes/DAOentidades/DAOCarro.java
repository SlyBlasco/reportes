/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.reportes.DAOentidades;

import com.itson.reportes.conector.MySQLConnector;
import com.itson.reportes.entidades.Carro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author luism
 */
public class DAOCarro {
    
    public void agregarCarro(Carro carro) throws SQLException {
        String query = "INSERT INTO carros (modelo, marca, placa) VALUES (?, ?, ?)";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, carro.getModelo());
            preparedStatement.setString(2, carro.getMarca());
            preparedStatement.setString(3, carro.getPlaca());
            preparedStatement.executeUpdate();
        }
    }

    public List<Carro> getAllCarros() throws SQLException {
        List<Carro> carros = new ArrayList<>();
        String query = "SELECT * FROM Carros";
        try (Connection connection = MySQLConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Carro carro = new Carro(resultSet.getInt("id"), resultSet.getString("modelo"),
                                        resultSet.getString("marca"), resultSet.getString("placa"));
                carros.add(carro);
            }
        }
        return carros;
    }

        public Carro getCarroById(int id) throws SQLException {
        String query = "SELECT * FROM Carros WHERE id = ?";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Carro(
                        resultSet.getInt("id"),
                        resultSet.getString("modelo"),
                        resultSet.getString("marca"),
                        resultSet.getString("placa")
                    );
                }
            }
        }
        return null;
    }

    public void actualizarCarro(Carro carro) throws SQLException {
        String query = "UPDATE Carros SET modelo = ?, marca = ?, placa = ? WHERE id = ?";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, carro.getModelo());
            preparedStatement.setString(2, carro.getMarca());
            preparedStatement.setString(3, carro.getPlaca());
            preparedStatement.setInt(4, carro.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void eliminarCarro(int id) throws SQLException {
        String query = "DELETE FROM Carros WHERE id = ?";
        try (Connection connection = MySQLConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}



