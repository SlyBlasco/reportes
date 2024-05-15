/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.reportes.entidades;

/**
 *
 * @author Luis Blasco, Daniel Labrada, Emiliano Bojorquez, Miguel Devora, Mario Le Blohic.
 */
public class Carro {
    private int id;
    private String modelo;
    private String marca;
    private String placa;

    public Carro(int id, String modelo, String marca, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
}
