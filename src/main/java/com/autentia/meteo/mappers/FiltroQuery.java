/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autentia.meteo.mappers;

/**
 *
 * @author Carlos
 */
public class FiltroQuery {
    
    private String localidad;
    
    /*Posibles valores:
    * TEMP_ASC
    * TEMP_DESC
    * LOC_ASC
    * LOC_DESC
    * DEFAULT: LOC_ASC
    */
    private String orderBy;
    
    private int pagina;
    
    private int numElemsPorPagina;
    
    private int registroInicial;
    
  
    public FiltroQuery(){
        this.localidad = "";
        this.orderBy = "LOC_ASC";
    }
    
    public FiltroQuery(String localidad,String orden){
        this.localidad = localidad;
        this.orderBy = orden;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
        this.setRegistroInicial();
    }

    public int getNumElemsPorPagina() {
        return numElemsPorPagina;
    }

    public void setNumElemsPorPagina(int numElemsPorPagina) {
        this.numElemsPorPagina = numElemsPorPagina;
        this.setRegistroInicial();
    }
    
    
    
    /*Calcula el registro inicial para la sentencia LIMIT en las consultas a BBDD*/
    private void setRegistroInicial(){
        if (this.pagina <= 0) this.pagina = 1;
        this.registroInicial = (this.pagina - 1) * this.numElemsPorPagina;
    }
    
    public int getRegistroInicial(){
        return this.registroInicial;
    }
    
    
    
    
    
    
            
    
    
    
    
}
