/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.session.ClienteFachadaLocal;
import com.session.TarjetaFachadaLocal;
import com.entity.Cliente;
import com.entity.Tarjeta;
import com.services.QrGenerator;
import com.session.TransaccionFachadaLocal;
import java.io.Console;
import java.io.File;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "transaccionMBean")
@SessionScoped

public class TransaccionMBean implements Serializable {

    @EJB
    private ClienteFachadaLocal clienteFachada;

    @EJB
    private TarjetaFachadaLocal tarjetaFachada;

    @EJB
    private TransaccionFachadaLocal transaccionFachada;

    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private String direccion;
    private String cvv;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String tipoDeTarjeta;
    private double valor;
    private QrGenerator qrGenerator;

    public TransaccionMBean() {
        qrGenerator = new QrGenerator();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.id = identificacion;
    }

    public String getIdentificacion() {
        return this.id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

    // Tarjeta
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTarjeta() {
        return this.numeroTarjeta;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setTipoDeTarjeta(String tipoDeTarjeta) {
        this.tipoDeTarjeta = tipoDeTarjeta;
    }

    public String getTipoDeTarjeta() {
        return this.tipoDeTarjeta;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public String registrarTransaccion() {
        
        Cliente cliente = clienteFachada.find(this.id);
        if(cliente == null){
            cliente = new  Cliente(this.id, this.nombre, this.direccion, this.telefono, this.correo);
            clienteFachada.registrar(cliente);  
        }
        
        Tarjeta tarjeta = tarjetaFachada.find(this.numeroTarjeta);
        if(tarjeta == null){
             tarjeta = new Tarjeta(this.numeroTarjeta, this.cvv, this.fechaVencimiento, this.tipoDeTarjeta);
             tarjetaFachada.registrar(tarjeta);                 
        }
        
        if(transaccionFachada.registrar(cliente, tarjeta, this.valor)){              // Guarda la transaccion en la db
            qrGenerator.saveQr("Identificacion:" + this.id + "Valor:" + this.valor); //Almacena el codigo QR en la ruta: C:\
            return "GUARDAR";
        }
       return "ERROR";
    }
}
