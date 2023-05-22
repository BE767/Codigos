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
public class Reportes implements Serializable
{

    public Reportes() {
    }
    
    
    private int IdReporte;
    private Date FechaCreacion;
    private Date FechaActualizacion;
    private Date UsuarioActualizacion;
    private Date UsuarioCreacion;
    private int IdTipoReporte;
    private int IdLaboratorio;
    private int IdUsuario;
    private int IdTipoError;
    private int IdEstatusReporte;

    public int getIdTipoReporte() {
        return IdTipoReporte;
    }

    public void setIdTipoReporte(int IdTipoReporte) {
        this.IdTipoReporte = IdTipoReporte;
    }

    public int getIdLaboratorio() {
        return IdLaboratorio;
    }

    public void setIdLaboratorio(int IdLaboratorio) {
        this.IdLaboratorio = IdLaboratorio;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdTipoError() {
        return IdTipoError;
    }

    public void setIdTipoError(int IdTipoError) {
        this.IdTipoError = IdTipoError;
    }

    public int getIdEstatusReporte() {
        return IdEstatusReporte;
    }

    public void setIdEstatusReporte(int IdEstatusReporte) {
        this.IdEstatusReporte = IdEstatusReporte;
    }
    
    public int getIdReporte() {
        return IdReporte;
    }

    public void setIdReporte(int IdReporte) {
        this.IdReporte = IdReporte;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Date getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(Date FechaActualizacion) {
        this.FechaActualizacion = FechaActualizacion;
    }

    public Date getUsuarioActualizacion() {
        return UsuarioActualizacion;
    }

    public void setUsuarioActualizacion(Date UsuarioActualizacion) {
        this.UsuarioActualizacion = UsuarioActualizacion;
    }

    public Date getUsuarioCreacion() {
        return UsuarioCreacion;
    }

    public void setUsuarioCreacion(Date UsuarioCreacion) {
        this.UsuarioCreacion = UsuarioCreacion;
    }

   

  
}
