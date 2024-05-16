/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.reportes.entidades;

import java.sql.Date;
/**
 *
 * @author Luis Blasco, Daniel Labrada, Emiliano Bojorquez, Miguel Devora, Mario Le Blohic.
 */
public class Registro {
    private int id;
    private Date fecha;
    private String estado;
    private int idCarro;

    public Registro(int id, Date fecha, String estado, int idCarro) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.idCarro = idCarro;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }
    
    
}
