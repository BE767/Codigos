/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class TipoReporte  implements Serializable
{

    public TipoReporte() {
    }

    private int IdTipoReporte;
    private String NombreTipoReporte;
    private Date FechaCreacion;

    public int getIdTipoReporte() {
        return IdTipoReporte;
    }

    public void setIdTipoReporte(int IdTipoReporte) {
        this.IdTipoReporte = IdTipoReporte;
    }

    public String getNombreTipoReporte() {
        return NombreTipoReporte;
    }

    public void setNombreTipoReporte(String NombreTipoReporte) {
        this.NombreTipoReporte = NombreTipoReporte;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
}
