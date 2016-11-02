/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentia.meteo.model;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class RegistroMeteo {

    private int idRegistro;

    private int validado;

    private String localidad;

    private Date fecha;

    private int temperatura;

    private int humedad;

    private int precipitacion;

    private int tipoDia;

    //@TODO Falta fotografia*/
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getValidado() {
        return validado;
    }

    public void setValidado(int validado) {
        this.validado = validado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(int precipitacion) {
        this.precipitacion = precipitacion;
    }

    public int getTipoDia() {
        return tipoDia;
    }

    public void setTipoDia(int tipoDia) {
        this.tipoDia = tipoDia;
    }
    
    public String getFechaString(){
        return this.fecha.getDate() + "/" + this.fecha.getMonth() + "/" + (this.fecha.getYear() + 1900);
    }
    
    @Override
    public String toString(){
        return  "Validado: " + this.validado + " | " + 
                "Localidad:" + this.localidad + " | " + 
                /*"Fecha: " + getFechaString() + " | " + */
                "Temperatura: " + this.temperatura + " | " + 
                "Humedad: " + this.humedad + " | " + 
                "Precipitacion: " + this.precipitacion + " | " + 
                "Tipo dia: " + this.tipoDia;
                
        
    }

}
