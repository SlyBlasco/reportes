/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.reportes.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Blasco, Daniel Labrada, Emiliano Bojorquez, Miguel Devora, Mario Le Blohic.
 */
public class MySQLConnector {
    String db = "reportes";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public MySQLConnector() {
    }
    
    //Conectar a la base de datos
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+db, user, password);
            System.out.println("SE CONECTO A DB");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NO SE CONECTO A DB");
        }
        return cx;
    }
    
    //Desconectar de la base de datos
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
