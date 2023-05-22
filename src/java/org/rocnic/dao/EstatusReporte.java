/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao;

import java.io.Serializable;

/**
 *
 * @author Evelyn
 */
public class EstatusReporte implements Serializable 

{

    public EstatusReporte() {
    }
   
    private int IdEstatusReporte;
    private String NombreEstatus;

    public int getIdEstatusReporte() {
        return IdEstatusReporte;
    }

    public void setIdEstatusReporte(int IdEstatusReporte) {
        this.IdEstatusReporte = IdEstatusReporte;
    }

    public String getNombreEstatus() {
        return NombreEstatus;
    }

    public void setNombreEstatus(String NombreEstatus) {
        this.NombreEstatus = NombreEstatus;
    }
    
    
}
