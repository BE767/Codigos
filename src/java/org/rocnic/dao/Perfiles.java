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
public class Perfiles implements Serializable
{

    public Perfiles() {
    }
    
    
    private  int IdPerfil;
    private String NombrePerfil;

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public String getNombrePerfil() {
        return NombrePerfil;
    }

    public void setNombrePerfil(String NombrePerfil) {
        this.NombrePerfil = NombrePerfil;
    }      
}
