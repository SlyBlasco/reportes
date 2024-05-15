/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.reportes.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Blasco, Daniel Labrada, Emiliano Bojorquez, Miguel Devora, Mario Le Blohic.
 */
public class MySQLConnector {
    
    private static final String url = "jdbc:mysql://localhost:3306/estacionamiento";
    private static final String user = "root";
    private static final String contraseña = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, contraseña);
    }
    
    public static void main(String[] args) throws SQLException {
        getConnection();
        System.out.println("SE CONECTO A BD");
    }
}

