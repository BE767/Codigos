/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class TipoError implements Serializable
{

    public TipoError() {
    }
    
    private int IdTipoError;
    private String NombreError;
    private int IdTipoReporte;

    public int getIdTipoReporte() {
        return IdTipoReporte;
    }

    public void setIdTipoReporte(int IdTipoReporte) {
        this.IdTipoReporte = IdTipoReporte;
    }

  

    public int getIdTipoError() {
        return IdTipoError;
    }

    public void setIdTipoError(int IdTipoError) {
        this.IdTipoError = IdTipoError;
    }

    public String getNombreError() {
        return NombreError;
    }

    public void setNombreError(String NombreError) {
        this.NombreError = NombreError;
    }

   
  
}
